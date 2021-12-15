package pages;

import elements.*;
import exceptions.ElementNotFoundException;
import exceptions.IncorrectClassRedirectionException;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.ScrollUtils;
import util.WaitUtils;

import java.lang.reflect.InvocationTargetException;

public class DominoPage extends BasePage {

    private static final String DOMINO_ENDPOINT = "dominos";

    @FindBy(xpath = "//input[@placeholder='от']")
    private Input minPriceInput;

    @FindBy(xpath = "//*[@id='schema-products']/div")
    private Text warningMessageText;

    @FindBy(className = "schema-header__title")
    private Text headerLabel;

    @FindBy(xpath = "//div[@class='schema-product__image']")
    private Picture pizzaPicture;

    public DominoPage() {
        super();
    }

    @Override
    @Step("Open a domino's page")
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
    @Step("Choose pizza")
    public <T> T choosePizza(String pizza, Class<T> clazz) throws IncorrectClassRedirectionException {
        try {
            waitForPageOpened();
            WaitUtils.waitForVisibility(pizzaPicture);
            WebElement dominoLink = driver.findElement(By.partialLinkText(pizza));
            ScrollUtils.scrollToElementView(dominoLink);
            dominoLink.click();
            return (T) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new IncorrectClassRedirectionException("Failed to redirect to another page in choosePizza");
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            throw new ElementNotFoundException("Failed to find an element during choosePizza implementation");
        }
    }

    /***
     * Set the price in the price filter
     * @param number price
     */
    @Step("Set {number} as a price")
    public DominoPage setMinPrice(String number) {
        minPriceInput.sendKeys(number);
        return this;
    }

    /***
     * Message on absence of goods on the list
     */
    public boolean areNoGoodsWarningDisplayed() {
        WaitUtils.waitForVisibility(warningMessageText);
        return warningMessageText.isDisplayed();
    }
}
