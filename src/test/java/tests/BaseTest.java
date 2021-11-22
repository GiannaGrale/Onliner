package tests;

import com.github.javafaker.Faker;
import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import properties.ReadProperties;
import static drivers.DriverManager.getDriver;

public class BaseTest {
    protected final Logger logger = LogManager.getLogger(this);
    protected Faker faker = new Faker();
    protected ReadProperties props;

    @BeforeTest(alwaysRun = true)
    public void setupProperties() {
        props = ReadProperties.getInstance();
    }

    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserType.CHROME));
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
