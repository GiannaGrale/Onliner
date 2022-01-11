package configuration;

import java.util.regex.Pattern;

/***
 * Set up the number of test run threads
 */
public class ThreadCountConfig {

    private static final Pattern isInteger = Pattern.compile("^\\d+$");

    public static int getThreads() {
        String threadCount = System.getProperty("threadNumber");
        return getThreadNumber(threadCount);
    }

    private static int getThreadNumber(String strNum) {
        if (isInteger.matcher(strNum).matches()) {
            return Integer.parseInt(strNum);
        } else {
            throw new IllegalArgumentException("Unknown thread count value : " + strNum);
        }
    }
}
