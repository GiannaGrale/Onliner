package pages;

import elements.Button;
import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.WaitUtils;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = ".cart-form__title.cart-form__title_big-alter ")
    protected Text cartMessage;

    @FindBy(css = ".button-style.button-style_primary")
    protected Button completeOrderButton;

    public ShoppingCartPage() {
        super();
    }

    @Override
    public ShoppingCartPage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.CART_URL));
        logger.debug("Navigation to the cartURL...");
        return this;
    }

    @Override
    public ShoppingCartPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(cartMessage);
        } catch (TimeoutException e) {
            logger.debug("ShoppingCartPage wasn't opened. CartMessage wasn't found ");
            Assert.fail("ShoppingCartPage was not opened");
        }
        return this;
    }

    /***
     * While entering the cart with the added item, an order completion button appears
     * @return an order completion button text
     */
    public String getCompleteOrderButtonText() {
        WaitUtils.waitForVisibility(completeOrderButton);
        return completeOrderButton.getText().toLowerCase().trim();
    }

    /***
     * While entering the cart, a cart header is displayed
     */
    public String getShoppingCartMessage() {
        return cartMessage.getText().toLowerCase().trim();
    }
}
