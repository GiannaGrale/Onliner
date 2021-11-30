package util;

import drivers.DriverManager;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/***
 * Class for finding a particular wrapper element
 */
public class FindElementUtils {

    private WebElement element;

    public FindElementUtils(WebElement element) {
        this.element = element;
    }

    public static Button findButton(By by) {
        return new ButtonImpl(DriverManager.getDriver().findElement(by));
    }

    public static Checkbox findCheckbox(By by) {
        return new CheckBoxImpl(DriverManager.getDriver().findElement(by));
    }

    public static Link findLink(By by) {
        return new LinkImpl(DriverManager.getDriver().findElement(by));
    }
}
