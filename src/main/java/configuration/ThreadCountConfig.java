package configuration;

import java.util.regex.Pattern;

/***
 * Set up the number of test run threads
 */
public class ThreadCountConfig {

    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static int getThreads() {
        String threadCount = System.getProperty("threadNumber");
        String currentThreads = threadCount == null ? System.getProperty("threadNumber") : threadCount;
        return getThreadNumber(currentThreads);
    }

    private static int getThreadNumber(String strNum) {
        if (pattern.matcher(strNum).matches()) {
            return Integer.parseInt(strNum);
        } else {
            throw new IllegalArgumentException("Unknown thread count value : " + strNum);
        }
    }
}
