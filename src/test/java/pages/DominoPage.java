package pages;


import elements.*;
import endpoints.OnlinerEndpoints;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.FindElementUtils;
import util.ScrollUtils;
import util.WaitUtils;

public class DominoPage extends BasePage {

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
        driver.navigate().to(props.getKeyProperty(Type.valueOf(Type.CATALOGUE_URL + OnlinerEndpoints.dominosEndpoint)));
        logger.debug("Navigation to the catalogueURL...");
        return this;
    }

    @Override
    public DominoPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(headerLabel);
        } catch (TimeoutException e) {
            logger.debug("DominoPage wasn't opened. HeaderLabel wasn't found ");
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
            WaitUtils.waitForVisibility(pizzaPic);
            Link dominoLink;
            dominoLink = FindElementUtils.findLink(By.partialLinkText(pizza));
            ScrollUtils.scrollToElementView(dominoLink);
            dominoLink.click();
            clazz = (Class<T>) Class.forName(page.getName());
            return clazz.newInstance();
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
