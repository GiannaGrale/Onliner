package pages;

import elements.Button;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

public class PepperoniPage extends BasePage {

    @FindBy(className = "product-aside__price--primary")
    protected Text price;

    @FindBy(css = ".button-style.button-style_expletive")
    protected Button addToCart;

    @FindBy(xpath = "//a[@title='Корзина']")
    protected Button cart;

    @Override
    protected PepperoniPage openPage() {
        driver.navigate().to(props.getKeyProperty("catalogueURL") + OnlinerEndpoints.pepperoniEndpoint);
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    protected PepperoniPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(price);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Add an item to the cart by clicking the add to cart button
     */
    public PepperoniPage clickAddToCartButton() {
        WaitUtils.waitForVisibility(addToCart);
        addToCart.click();
        return this;
    }

    /***
     * Click the shopping cart button
     */
    public ShoppingCartPage clickCartButton() {
        cart.click();
        return new ShoppingCartPage();
    }
}
