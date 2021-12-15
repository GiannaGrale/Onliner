package pages;

import elements.Button;
import elements.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.ScrollUtils;
import util.WaitUtils;

public class PepperoniPage extends BasePage {

    private static final String PEPPERONI_ENDPOINT = "dominos/dominospizza/domipepperonito5";

    @FindBy(className = "product-aside__price--primary")
    private Text priceLabelText;

    @FindBy(css = ".button-style.button-style_expletive")
    private Button addToCartButton;

    @FindBy(xpath = "//a[@title='Корзина']")
    private Button cartButton;

    public PepperoniPage() {
        super();
    }

    @Override
    @Step("Open a pepperoni pizza page")
    protected PepperoniPage openPage() {
        driver.navigate().to(CATALOGUE_URL + PEPPERONI_ENDPOINT);
        logger.debug("Navigation to the URL " + PEPPERONI_ENDPOINT);
        return this;
    }

    @Override
    public PepperoniPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(priceLabelText);
        } catch (TimeoutException e) {
            Assert.fail("PepperoniPage was not opened");
        }
        return this;
    }

    /***
     * Add an item to the cart by clicking the add to cart button
     */
    @Step("Click on the add to cart button")
    public PepperoniPage clickAddToCartButton() {
        waitForPageOpened();
        ScrollUtils.scrollToElementView(addToCartButton);
        addToCartButton.click();
        return this;
    }

    /***
     * Click the shopping cart button
     */
    @Step("Open a shopping cart")
    public ShoppingCartPage clickCartButton() {
        WaitUtils.waitForInvisibility(addToCartButton);
        ScrollUtils.scrollUp(cartButton);
        cartButton.click();
        return new ShoppingCartPage();
    }
}
