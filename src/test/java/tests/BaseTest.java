package tests;


import configuration.BrowserConfig;
import com.automation.remarks.testng.UniversalVideoListener;
import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import listeners.OnlinerTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import properties.TestDataStorage;

import static drivers.DriverManager.getDriver;
import static listeners.OnlinerTestListener.attachEnvironmentInfo;

@Listeners({OnlinerTestListener.class, UniversalVideoListener.class})
public class BaseTest {

    protected final Logger logger = LogManager.getLogger(this);

    protected static final String LOGIN = TestDataStorage.getLogin();
    protected static final String PSW = TestDataStorage.getPassword();

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        WebDriver driver = DriverFactory.getDriver(BrowserConfig.getType());
        DriverManager.setWebDriver(driver);
        attachEnvironmentInfo(driver);
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
