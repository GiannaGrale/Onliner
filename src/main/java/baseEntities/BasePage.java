package baseEntities;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected ReadProperties properties;

    public BasePage() {
        driver = BaseTest.getDriver();
        properties = ReadProperties.getInstance();
    }
}
