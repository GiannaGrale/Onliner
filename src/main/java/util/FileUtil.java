package util;

import org.testng.ITestResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    /***
     * Clear log file
     */
    public static void clearFile(String file) throws IOException {
        File logFile = new File(file);
        new FileWriter(logFile, false).close();
    }

    /***
     * Autodelete of generated video
     */
    public static void deleteFolderWithVideo(ITestResult result, String extension) {
        File video = new File(result.getName() + extension);
        video.deleteOnExit();
    }
}
