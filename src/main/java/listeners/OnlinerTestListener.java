package listeners;

import com.automation.remarks.testng.UniversalVideoListener;
import com.google.common.collect.ImmutableMap;
import configuration.ThreadCountConfig;
import drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import java.io.File;
import java.io.FileOutputStream;
import org.testng.annotations.Listeners;
import util.AllureUtil;
import util.FileUtil;
import java.io.IOException;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/***
 * OnlinerTestListener is used to log information on the test run flow and to the reporting system.
 */
@Listeners(UniversalVideoListener.class)
public class OnlinerTestListener implements ITestListener {

    protected final Logger logger = LogManager.getLogger(this);

    private static final String LOG_FILE_PATH = "target/test.log";
    private static final String VIDEO_EXTENSION_FORMAT = ".mp4";

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
        context.getCurrentXmlTest().getSuite().setParallel(XmlSuite.ParallelMode.METHODS);
        context.getCurrentXmlTest().getSuite().setThreadCount(ThreadCountConfig.getThreads());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("The test class run finished on ... " + context.getEndDate());
    }

    public static void attachEnvironmentInfo () {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getBrowserName())
                        .put("Browser.Version", ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getBrowserVersion())
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " successful...");
        try {
            AllureUtil.appendLogToAllure(LOG_FILE_PATH);
            FileUtil.clearFile(LOG_FILE_PATH);
            AllureUtil.attachScreenshot();
            AllureUtil.attachVideoMP4(result);
            FileUtil.deleteMediaFile(result.getName(), VIDEO_EXTENSION_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " failed...");
        try {
            AllureUtil.appendLogToAllure(LOG_FILE_PATH);
            FileUtil.clearFile(LOG_FILE_PATH);
            AllureUtil.attachScreenshot();
            AllureUtil.attachVideoMP4(result);
            FileUtil.deleteMediaFile(result.getName(), VIDEO_EXTENSION_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getName() + " skipped...");
        try {
            AllureUtil.appendLogToAllure(LOG_FILE_PATH);
            FileUtil.clearFile(LOG_FILE_PATH);
            AllureUtil.attachScreenshot();
            AllureUtil.attachVideoMP4(result);
            FileUtil.deleteMediaFile(result.getName(), VIDEO_EXTENSION_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
