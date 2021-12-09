package pages;

import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.ConfigStorage;
import util.ScrollUtils;
import util.WaitUtils;

import java.lang.reflect.InvocationTargetException;

public class DominoPage extends BasePage {

    private final String CATALOGUE_URL = ConfigStorage.getCatalogueUrl();
    private static final String DOMINO_ENDPOINT = "dominos";

    @FindBy(xpath = "//input[@placeholder='от']")
    private Input minPriceInput;

    @FindBy(xpath = "//*[@id='schema-products']/div/nobr")
    private Text warningMessage;

    @FindBy(className = "schema-header__title")
    private Text headerLabel;

    @FindBy(xpath = "//*[@id='schema-products']/div[1]/descendant::div[2]")
    private Picture pizzaPic;

    public DominoPage() {
        super();
    }

    @Override
    public DominoPage openPage() {
        driver.navigate().to(CATALOGUE_URL + DOMINO_ENDPOINT);
        logger.debug("Navigation to the URL " + DOMINO_ENDPOINT);
        return this;
    }

    @Override
    public DominoPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(headerLabel);
        } catch (TimeoutException e) {
            Assert.fail("DominoPage was not opened");
        }
        return this;
    }

    /***
     * Chose a pizza from the list
     * @param pizza pizza item
     */
    @SuppressWarnings("unchecked")
    public <T> T choosePizza(Class<T> clazz, String pizza) {
        try {
            waitForPageOpened();
            WaitUtils.waitForVisibility(pizzaPic);
            WebElement dominoLink = driver.findElement(By.partialLinkText(pizza));
            ScrollUtils.scrollToElementView(dominoLink);
            dominoLink.click();
            return (T) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return (T) this;
    }

    /***
     * Set the price in the price filter
     * @param number price
     */
    public DominoPage setMinPrice(String number) {
        minPriceInput.sendKeys(number);
        return this;
    }

    /***
     * Message on absence of goods on the list
     */
    public boolean areNoGoodsWarning() {
        WaitUtils.waitForVisibility(warningMessage);
        return warningMessage.isDisplayed();
    }
}
