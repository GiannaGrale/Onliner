package util;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class WaitUtils {

    private static final Duration TIMEOUT = Duration.ofSeconds(35);
    private static final Duration POLLING_TIME = Duration.ofSeconds(1);
    private static final Duration FLUENT_TIMEOUT = Duration.ofSeconds(5);

    private static final FluentWait<WebDriver> fluentWait = new FluentWait<>(DriverManager.getDriver());
    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TIMEOUT);

    /***
     * Waits for the element visibility
     */
    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * Waits until the element invisibility
     */
    public static void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /***
     * Waits until the element is displayed using standard timeout & polling timing
     */
    public static void waitForElementToBeDisplayed(WebElement element) {
        createWaitForElementToBeDisplayed(element, FLUENT_TIMEOUT, POLLING_TIME);
    }

    /***
     * Waits until the element is displayed using custom timing
     */
    public static void createWaitForElementToBeDisplayed(WebElement element, Duration timeoutSeconds, Duration pollingTimeSeconds) {
        fluentWait
                .withTimeout(timeoutSeconds)
                .pollingEvery(pollingTimeSeconds)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
