package cucumber.hooks;

import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static drivers.DriverManager.getDriver;

/***
 * Cucumber Hook is used to initiate and cancel work of the current thread webdriver
 */
public class CucumberHook {

    @Before
    public static void initBrowser() {
        DriverManager.setWebDriver(DriverFactory.getDriver(BrowserType.CHROME));
    }

    @After
    public static void closeBrowser() {
        DriverManager.quitDriver(getDriver());
    }
}
