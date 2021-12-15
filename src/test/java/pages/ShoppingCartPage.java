package pages;

import elements.Button;
import elements.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.ConfigStorage;
import util.WaitUtils;

public class ShoppingCartPage extends BasePage {

    private final String CART_URL = ConfigStorage.getCartUrl();

    @FindBy(css = ".cart-form__title.cart-form__title_big-alter ")
    private Text cartMessageText;

    @FindBy(css = ".button-style.button-style_primary")
    private Button completeOrderButton;

    public ShoppingCartPage() {
        super();
    }

    @Override
    @Step("Open a shopping cart page")
    public ShoppingCartPage openPage() {
        driver.navigate().to(CART_URL);
        logger.debug("Navigation to the URL " + CART_URL);
        return this;
    }

    @Override
    public ShoppingCartPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(cartMessageText);
        } catch (TimeoutException e) {
            Assert.fail("ShoppingCartPage was not opened");
        }
        return this;
    }

    /***
     * While entering the cart with the added item, an order completion button appears
     * @return an order completion button text
     */
    public String getCompleteOrderButtonText() {
        waitForPageOpened();
        WaitUtils.waitForVisibility(completeOrderButton);
        return completeOrderButton.getText().toLowerCase().trim();
    }

    /***
     * While entering the cart, a cart header is displayed
     */
    public String getShoppingCartMessage() {
        return cartMessageText.getText().toLowerCase().trim();
    }
}
