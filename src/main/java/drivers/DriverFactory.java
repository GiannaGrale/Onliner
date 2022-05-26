package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverFactory {
    /***
     * Chooses a webdriver of a defined type
     * @param browser chosen driver
     */
    public static WebDriver getDriver(BrowserType browser) {
        WebDriver driver;
        switch (browser) {
            case OPERA:
                driver = getOpera();
                break;
            case CHROME:
                driver = getChrome();
                break;
            case FIREFOX:
                driver = getFireFox();
                break;
            case EDGE:
                driver = getEdge();
                break;
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
        return driver;
    }

    /***
     * Chrome webdriver settings
     * @return chrome webdriver
     */
    public static ChromeDriver getChrome() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--headless");
        return new ChromeDriver(chromeOptions);
    }

    /**
     * Firefox webdriver settings
     * @return firefox webdriver
     */
    public static FirefoxDriver getFireFox() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-gpu");
        firefoxOptions.addArguments("--start-maximized");
        return new FirefoxDriver(firefoxOptions);
    }

    /***
     * Edge webdriver settings
     * @return edge webdriver
     */
    public static EdgeDriver getEdge() {
        WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("disable-gpu");
        edgeOptions.addArguments("--start-maximized");
        return new EdgeDriver(edgeOptions);
    }

    /***
     * Opera webdriver settings
     * @return opera webdriver
     */
    public static OperaDriver getOpera() {
        WebDriverManager.getInstance(DriverManagerType.OPERA).setup();
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.addArguments("disable-gpu");
        operaOptions.addArguments("--start-maximized");
        return new OperaDriver(operaOptions);
    }
}
