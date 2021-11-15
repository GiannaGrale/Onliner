package baseEntities;

import drivers.BrowserType;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @BeforeMethod
    public void setUp(){
        try {
            DriverManager.setWebDriver(DriverFactory.getDriver(BrowserType.OPERA));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();
        DriverManager.quitDriver(driver);

    }
}
