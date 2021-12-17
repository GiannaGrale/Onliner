package listeners;

import com.automation.remarks.testng.UniversalVideoListener;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import util.AllureUtil;
import java.io.File;
import java.io.IOException;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/***
 * OnlinerTestListener is used to log information on the test run flow and to the reporting system.
 */
@Listeners(UniversalVideoListener.class)
public class OnlinerTestListener implements ITestListener {

    protected final Logger logger = LogManager.getLogger(this);
    AllureUtil allureUtil = new AllureUtil();

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
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "96.0.4664.93 (Official build), (64 bit)")
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("The test class run finished on ... " + context.getEndDate());
        try {
            FileUtils.deleteDirectory(new File("video"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " successful...");
        try {
          allureUtil.appendLogToAllure();
          allureUtil.clearFile();
          allureUtil.attachScreenshot();
          allureUtil.attachVideoMP4(result);
          allureUtil.deleteFolderWithVideo(result);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " failed...");
        try {
            allureUtil.appendLogToAllure();
            allureUtil.clearFile();
            allureUtil.attachScreenshot();
            allureUtil.attachVideoMP4(result);
            allureUtil.deleteFolderWithVideo(result);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getName() + " skipped...");
        try {
            allureUtil.appendLogToAllure();
            allureUtil.clearFile();
            allureUtil.attachScreenshot();
            allureUtil.attachVideoMP4(result);
            allureUtil.deleteFolderWithVideo(result);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
