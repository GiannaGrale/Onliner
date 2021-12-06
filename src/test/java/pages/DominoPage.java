package pages;

import elements.*;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.ScrollUtils;
import util.WaitUtils;


public class DominoPage extends BasePage {

    public static final String DOMINO_ENDPOINT = "dominos";

    @FindBy(xpath = "//input[@placeholder='от']")
    protected Input minPriceInput;

    @FindBy(xpath = "//*[@id='schema-products']/div/nobr")
    protected Text warningMessage;

    @FindBy(className = "schema-header__title")
    protected Text headerLabel;

    @FindBy(xpath = "//*[@id='schema-products']/div[1]/descendant::div[2]")
    protected Picture pizzaPic;

    public DominoPage() {
        super();
    }

    @Override
    public DominoPage openPage() {
        driver.navigate().to(props.getKeyProperty(Property.valueOf(Property.CATALOGUE_URL + DOMINO_ENDPOINT)));
        logger.debug("Navigation to the catalogueURL..." + DOMINO_ENDPOINT);
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
    public <T> T choosePizza(Class<T> clazz, Pages page, String pizza) {
        try {
            waitForPageOpened();
            WaitUtils.waitForVisibility(pizzaPic);
            WebElement dominoLink = driver.findElement(By.partialLinkText(pizza));
            ScrollUtils.scrollToElementView(dominoLink);
            dominoLink.click();
            return (T) Class.forName(page.getName()).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
    public boolean areGoodsDisplayed() {
        WaitUtils.waitForVisibility(warningMessage);
        return warningMessage.isDisplayed();
    }
}
