package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/***
 * RetryAnalyzer helps to check if the failure was caused by a product bug or another reason.
 */
public class Retry implements IRetryAnalyzer {
    private int attempt = 0;
    private static final int MAX_RETRY = 4;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                iTestResult.setStatus(ITestResult.FAILURE);
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
