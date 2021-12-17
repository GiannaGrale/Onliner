package util;

import com.automation.remarks.video.recorder.VideoRecorder;
import drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import ws.schild.jave.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AllureUtil {

    /***
     Attach log file to allure report
     */
    @Attachment(value = "Test.log", type = "text/plain")
    public byte[] appendLogToAllure() {
        try {
            return FileUtils.readFileToByteArray(new File("target/test.log"));
        } catch (IOException ignored) {
            return null;
        }
    }

    @Attachment(value = "Record screen MP4", type = "video/mp4")
    public byte[] attachVideoMP4(ITestResult result) throws IOException {
        convertAviToMp4(VideoRecorder.getLastRecording().getAbsolutePath(), result.getName() + ".mp4");
        File video = new File(result.getName() + ".mp4");
        return FileUtils.readFileToByteArray(video);
    }

    /***
     * Attach avi video to allure report
     */
    @Attachment(value = "Record screen AVI", type = "video/avi")
    public byte[] attachVideoAVI() throws IOException {
        File file = new File(VideoRecorder.getLastRecording().getPath());
        return FileUtils.readFileToByteArray(file);
    }

    /***
     * Attach a screenshot to allure report
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /***
     * Clear log file
     */
    public void clearFile() throws IOException {
        File myFoo = new File("target/test.log");
        FileOutputStream fooStream = new FileOutputStream(myFoo, false);
        byte[] myBytes = "".getBytes();
        fooStream.write(myBytes);
    }

    /***
     * Autodelete folder with video
     */
    public void deleteFolderWithVideo(ITestResult result) {
        File video = new File(result.getName() + ".mp4");
        video.deleteOnExit();
    }

    /***
     * Converts avi to mp4 video format
     * @param oldPath path to the existent avi video
     * @param newPath path to a new mp4 video
     */
    public File convertAviToMp4(String oldPath, String newPath) {
        File target = new File(newPath);
        File source = new File(oldPath);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(800000));
        audio.setChannels(new Integer(1));
        VideoAttributes video = new VideoAttributes();
        video.setCodec("libx264");
        video.setBitRate(new Integer(3200000));
        video.setFrameRate(new Integer(15));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp4");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            encoder.encode(multimediaObject, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
        return new File(oldPath, newPath);
    }
}
