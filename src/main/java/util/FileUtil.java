package util;

import org.testng.ITestResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    private static final String LOG_FILE_PATH = "target/test.log";
    private static final String VIDEO_EXTENSION_FORMAT = ".mp4";

    /***
     * Clear log file
     */
    public static void clearFile() throws IOException {
        File logFile = new File(LOG_FILE_PATH);
        new FileWriter(logFile, false).close();
    }

    /***
     * Autodelete of generated video
     */
    public static void deleteFolderWithVideo(ITestResult result) {
        File video = new File(result.getName() + VIDEO_EXTENSION_FORMAT);
        video.deleteOnExit();
    }
}
