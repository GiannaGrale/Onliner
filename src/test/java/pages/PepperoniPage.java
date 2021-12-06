package pages;

import elements.Button;
import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.ScrollUtils;
import util.WaitUtils;


public class PepperoniPage extends BasePage {

    public static final String PEPPERONI_ENDPOINT = "dominos/dominospizza/domipepperonito5";

    @FindBy(className = "product-aside__price--primary")
    protected Text priceLabel;

    @FindBy(css = ".button-style.button-style_expletive")
    protected Button addToCartButton;

    @FindBy(xpath = "//a[@title='Корзина']")
    protected Button cartButton;

    public PepperoniPage() {
        super();
    }

    @Override
    protected PepperoniPage openPage() {
        driver.navigate().to(props.getKeyProperty(Property.valueOf(Property.CATALOGUE_URL + PEPPERONI_ENDPOINT)));
        logger.debug("Navigation to the catalogueURL" + PEPPERONI_ENDPOINT);
        return this;
    }

    @Override
    public PepperoniPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(priceLabel);
        } catch (TimeoutException e) {
            Assert.fail("PepperoniPage was not opened");
        }
        return this;
    }

    /***
     * Add an item to the cart by clicking the add to cart button
     */
    public PepperoniPage clickAddToCartButton() {
        waitForPageOpened();
        ScrollUtils.scrollToElementView(addToCartButton);
        addToCartButton.click();
        return this;
    }

    /***
     * Click the shopping cart button
     */
    public ShoppingCartPage clickCartButton() {
        WaitUtils.waitForInvisibility(addToCartButton);
        ScrollUtils.scrollUp(cartButton);
        cartButton.click();
        return new ShoppingCartPage();
    }
}
