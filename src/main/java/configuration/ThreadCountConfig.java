package configuration;

import java.util.regex.Pattern;

/***
 * Set up the number of test run threads
 */
public class ThreadCountConfig {

    private static final Pattern INTEGER_PATTERN = Pattern.compile("^\\d+$");

    public static int getThreads() {
        String threadCount = System.getProperty("threadNumber");
        return getThreadNumberFrom(threadCount);
    }

    private static int getThreadNumberFrom(String threadNum) {
        if (INTEGER_PATTERN.matcher(threadNum).matches()) {
            return Integer.parseInt(threadNum);
        } else {
            throw new IllegalArgumentException("Unknown thread count value : " + threadNum);
        }
    }
}
