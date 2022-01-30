package tests;

import configuration.BrowserConfig;
import com.automation.remarks.testng.UniversalVideoListener;
import drivers.DriverFactory;
import drivers.DriverManager;
import listeners.OnlinerTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import properties.EnvironmentConfig;
import static drivers.DriverManager.getDriver;
import static listeners.OnlinerTestListener.attachEnvironmentInfo;

@Listeners({OnlinerTestListener.class, UniversalVideoListener.class})
public class BaseTest {

    protected final Logger logger = LogManager.getLogger(this);

    protected static final String LOGIN = EnvironmentConfig.getLogin();
    protected static final String PSW = EnvironmentConfig.getPassword();

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserConfig.getType()));
        attachEnvironmentInfo();
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
