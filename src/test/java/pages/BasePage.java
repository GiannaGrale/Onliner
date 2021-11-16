package pages;


import core.ReadProperties;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    protected WebDriver driver;
    protected ReadProperties properties = new ReadProperties();

    protected abstract void openPage();

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
    }
}
