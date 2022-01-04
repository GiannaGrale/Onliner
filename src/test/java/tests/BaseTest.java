package tests;

import drivers.BrowserConfig;
import drivers.DriverFactory;
import drivers.DriverManager;
import listeners.OnlinerTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import properties.TestDataStorage;
import static drivers.DriverManager.getDriver;

@Listeners(OnlinerTestListener.class)
public class BaseTest {

    protected final Logger logger = LogManager.getLogger(this);

    protected static final String LOGIN = TestDataStorage.getLogin();
    protected static final String PSW = TestDataStorage.getPassword();

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserConfig.getType()));
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
