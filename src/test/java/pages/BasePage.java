package pages;

import factory.ElementFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.ReadProperties;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected ReadProperties properties = new ReadProperties();

    /***
     * Navigate the webdriver to the chosen url
     * @return page of the defined url
     */
    protected abstract BasePage openPage();

    /***
     * Checks element presence on a page
     * @return page if the elements presents
     */
    protected abstract BasePage isPageOpened();

    public BasePage() {
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
