package util;

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
     * Deletion of the generated video
     */
    public static void deleteFolderWithVideo(String methodName, String extension) {
        File video = new File(methodName + extension);
        video.deleteOnExit();
    }
}
