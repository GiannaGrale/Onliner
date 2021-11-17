package tests;

import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static drivers.DriverManager.getDriver;

public class BaseTest {
    /***
     * Set and open the local thread browser type.
     */
    @BeforeMethod
    public void setUp() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserType.OPERA));
    }

    /***
     * Closes the local thread driver.
     */
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver(getDriver());
    }
}
