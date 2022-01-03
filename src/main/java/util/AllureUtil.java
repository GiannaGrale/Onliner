package util;

import com.automation.remarks.video.recorder.VideoRecorder;
import drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import static util.EncoderUtil.convertAviToMp4;

public class AllureUtil {

    /***
     Attach log file to allure report
     */
    @Attachment(value = "Test.log", type = "text/plain")
    public static byte[] appendLogToAllure(String file) throws IOException {
        return FileUtils.readFileToByteArray(new File(file));
    }

    @Attachment(value = "Record screen MP4", type = "video/mp4")
    public static byte[] attachVideoMP4(ITestResult result) throws IOException {
        return FileUtils.readFileToByteArray(convertAviToMp4(result.getName() + ".mp4"));
    }

    /***
     * Attach avi video to allure report
     */
    @Attachment(value = "Record screen AVI", type = "video/avi")
    public static byte[] attachVideoAVI() throws IOException {
        File file = new File(VideoRecorder.getLastRecording().getPath());
        return FileUtils.readFileToByteArray(file);
    }

    /***
     * Attach a screenshot to allure report
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
