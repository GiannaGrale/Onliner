package listeners;


import com.google.common.collect.ImmutableMap;
import configuration.ThreadCountConfig;
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
import java.io.IOException;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;


/***
 * OnlinerTestListener is used to log information on the test run flow and to the reporting system.
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

    public static void attachEnvironmentInfo(WebDriver driver ) {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", ((RemoteWebDriver) driver).getCapabilities().getBrowserName())
                        .put("Browser.Version", ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion())
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }

    @Attachment(value = "Test.log", type = "text/plain")
    public static byte[] appendLogToAllure() {
        try {
            return FileUtils.readFileToByteArray(new File("target/test.log"));
        } catch (IOException ignored) {
            return null;
        }
    }

    public static void clearFile() throws IOException {
        File myFoo = new File("target/test.log");
        FileOutputStream fooStream = new FileOutputStream(myFoo, false);
        byte[] myBytes = "".getBytes();
        fooStream.write(myBytes);
        fooStream.close();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getName() + " successful...");
        try {
            appendLogToAllure();
            clearFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info(result.getName() + " failed...");
        try {
            appendLogToAllure();
            clearFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getName() + " skipped...");
        try {
            appendLogToAllure();
            clearFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
