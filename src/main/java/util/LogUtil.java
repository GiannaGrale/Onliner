package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogUtil {

    /***
     * Clear log file
     */
    public static void clearFile() throws IOException {
        File logFile = new File("target/test.log");
        new FileWriter(logFile.getAbsolutePath(), false).close();
    }
}
