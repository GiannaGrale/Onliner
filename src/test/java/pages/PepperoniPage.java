package pages;

import elements.Button;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.WaitUtils;

public class PepperoniPage extends BasePage {

    @FindBy(className = "product-aside__price--primary")
    protected Text priceLabel;

    @FindBy(css = ".button-style.button-style_expletive")
    protected Button addToCartButton;

    @FindBy(xpath = "//a[@title='Корзина']")
    protected Button cartButton;

    @Override
    protected PepperoniPage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.valueOf(Type.CATALOGUE_URL + OnlinerEndpoints.pepperoniEndpoint)));
        logger.debug("Navigation to the catalogueURL" + OnlinerEndpoints.pepperoniEndpoint);
        return this;
    }

    @Override
    protected PepperoniPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(priceLabel);
        } catch (TimeoutException e) {
            logger.debug("PepperoniPage wasn't opened. PriceLabel wasn't found ");
            Assert.fail("PepperoniPage was not opened");
        }
        return this;
    }

    /***
     * Add an item to the cart by clicking the add to cart button
     */
    public PepperoniPage clickAddToCartButton() {
        WaitUtils.waitForVisibility(addToCartButton);
        addToCartButton.click();
        return this;
    }

    /***
     * Click the shopping cart button
     */
    public ShoppingCartPage clickCartButton() {
        cartButton.click();
        return new ShoppingCartPage();
    }
}
