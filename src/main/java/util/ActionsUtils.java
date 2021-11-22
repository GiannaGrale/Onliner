package util;
import drivers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    private static Actions createAction() {
        return new Actions(DriverManager.getDriver());
    }

    public static void moveToElementAndClick(WebElement target) {
        createAction().moveToElement(target).click().perform();
    }
}
