package util;

import com.automation.remarks.video.recorder.VideoRecorder;
import ws.schild.jave.*;
import java.io.File;

public class EncoderUtil {

    /***
     * Converts avi to mp4 video format
     * @param newPath path to a new mp4 video
     */
    public static File convertAviToMp4(String newPath) {
        File target = new File(newPath);
        VideoAttributes video = new VideoAttributes();
        video.setCodec("libx264");
        video.setBitRate(new Integer(3200000));
        video.setFrameRate(new Integer(15));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp4");
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        MultimediaObject multimediaObject = new MultimediaObject(VideoRecorder.getLastRecording());
        try {
            encoder.encode(multimediaObject, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
        return new File(newPath);
    }
}
