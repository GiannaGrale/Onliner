package pages;

import core.ReadProperties;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    protected ReadProperties properties;

    public BasePage() {
        driver = DriverManager.getDriver();
        properties = ReadProperties.getInstance();
        PageFactory.initElements(this.driver, this);
    }
}
