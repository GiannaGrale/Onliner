package util;

import drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/***
 * Wrapper class for approaching the defined element
 */
public class ScrollUtils {

    public static void scrollUp(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);", element);
    }

    public static void jsElementClick(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElementView(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManager.getDriver());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
