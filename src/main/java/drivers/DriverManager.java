package drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    /***
     * Threadlocal allows to to make a webdriver object thread-safe, i.e.
     * a single object can be used with multiply threads at the same time
     * without causing a problem.
     */
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    /***
     * The method removes the current thread’s copy of this thread-local variable to the specified value
     * @return webdriver of the current thread
     */
    public static WebDriver getDriver() {
        return webDriver.get();
    }

    /***
     * The method sets the current thread’s copy of this thread-local variable to the specified value
     * @param driver
     * @return webdriver of the current thread
     */
    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    /***
     * This method remove the current thread’s copy of this thread-local variable to the specified value
     * @param driver
     */
    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
