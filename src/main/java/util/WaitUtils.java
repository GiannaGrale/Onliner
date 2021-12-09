package util;

import drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/***
 * The class is used to wait for the element to show up or be clickable
 */
public class WaitUtils {

    private static final Duration TIMEOUT = Duration.ofSeconds(35);

    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TIMEOUT);

    /***
     * Waits for the element visibility
     */
    public static void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * Waits until the element is clickable
     */
    public static void elementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /***
     * Waits until the element invisibility
     */
    public static void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
