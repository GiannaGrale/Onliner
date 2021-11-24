package util;

import drivers.DriverManager;
import elements.*;
import org.openqa.selenium.By;

/***
 * Class for finding a particular wrapper element
 */
public class FindElementUtils {

    public static Element findElement(By by) {
        return new ElementImpl(DriverManager.getDriver().findElement(by));
    }

    public static Checkbox findCheckbox(By by) {
        return new CheckBoxImpl(DriverManager.getDriver().findElement(by));
    }

    public static Link findLink(By by) {
        return new LinkImpl(DriverManager.getDriver().findElement(by));
    }


}
