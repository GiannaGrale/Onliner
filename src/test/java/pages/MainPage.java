package pages;

import elements.Button;
import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class MainPage extends BasePage {

    @FindBy(className = "auth-bar__item--text")
    public Button entranceButton;

    @FindBy(className = "auth-bar__item--cart")
    public Button shoppingCart;

    @FindBy(xpath = "//form/descendant::div[@class='auth-form__label-title']")
    public Text loginViaNickNameMessage;

    @FindBy(className = "cart-form__title_condensed-additional")
    public Text shoppingCartMessage;

    public MainPage() {
        super();
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(properties.getPropertyValueByKey("url"));
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOf(entranceButton));
        } catch (TimeoutException e) {
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Click on the entrance button
     */
    public void openEntranceForm() {
        entranceButton.click();
    }

    /***
     * Click on the shopping cart icon
     */
    public void goToShoppingCart() {
        shoppingCart.click();
    }

    /***
     * Get a message under login field
     * @return the message under login field
     */
    public String getLoginViaNickNameMessage() {
        return loginViaNickNameMessage.getText().toLowerCase().trim();
    }

    /***
     * Display message "Cart" while entering the shopping cart
     * @return return message of shoppingCartMessage element
     */
    public String getShoppingCartMessage() {
        return shoppingCartMessage.getText().toLowerCase().trim();
    }
}
