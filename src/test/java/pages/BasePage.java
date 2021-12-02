package pages;

import factory.ElementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import properties.ReadProperties;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;



public abstract class BasePage {

    protected WebDriver driver;
    protected ReadProperties props;
    public final Logger logger = LogManager.getLogger(this);

    /***
     * Navigate the webdriver to the chosen url
     * @return page of the defined url
     */
    protected abstract BasePage openPage();

    /***
     * Checks element presence on a page
     * @return page if the elements presents
     */
    protected abstract BasePage waitForPageOpened();

    public BasePage() {
        props = ReadProperties.getInstance();
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
    }
}
