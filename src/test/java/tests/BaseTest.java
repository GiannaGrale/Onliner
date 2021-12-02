package tests;

import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import properties.ReadProperties;
import static drivers.DriverManager.getDriver;

public class BaseTest {

    protected final Logger logger = LogManager.getLogger(this);
    protected ReadProperties props = ReadProperties.getInstance();

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod
    public void setUp() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserType.CHROME));
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
