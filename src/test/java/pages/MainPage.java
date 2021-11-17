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

    public void openEntranceForm() { entranceButton.click(); }

    public void goToShoppingCart() { shoppingCart.click(); }

    public String getLoginViaNickNameMessage() {
        return loginViaNickNameMessage.getText().toLowerCase().trim();
    }

    public String getShoppingCartMessage() { return shoppingCartMessage.getText().toLowerCase().trim(); }
}
