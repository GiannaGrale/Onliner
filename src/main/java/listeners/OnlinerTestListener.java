package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/***
 * OnlinerTestListener is used to log information on the test run flow
 */
public class OnlinerTestListener implements ITestListener {

    protected final Logger logger = LogManager.getLogger(this);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getName() + " has started...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info(result.getName() + " failed but with some percentage of success...");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info(result.getName() + " failed due to the timeout...");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("The test class run started on " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("The test class run finished on ... " + context.getEndDate());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " passed successfully...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " failed...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getName() + " skipped...");
    }
}
