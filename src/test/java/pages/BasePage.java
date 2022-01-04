package pages;

import factory.ElementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import properties.EnvironmentConfig;

public abstract class BasePage {

    protected final Logger logger = LogManager.getLogger(this);

    protected WebDriver driver;
    protected final String CATALOGUE_URL = EnvironmentConfig.getCatalogueUrl();

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
        driver = DriverManager.getDriver();
        ElementFactory.initElements(this.driver, this);
    }
}
