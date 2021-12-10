package util;

import drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class for approaching the defined element
 */
public class ScrollUtils {

    /***
     * Scrolling to the top of the page
     */
    public static void scrollUp(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);", element);
    }

    /***
     * Click the element using jsExecutor
     */
    public static void jsElementClick(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("arguments[0].click();", element);
    }

    /***
     * Scrolling to the view of the element
     */
    public static void scrollToElementView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
