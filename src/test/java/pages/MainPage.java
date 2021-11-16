package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    @FindBy(className = "auth-bar__item--text")
    public WebElement entranceButton;

    @FindBy(xpath = "//form/descendant::div[@class='auth-form__label-title']")
    public WebElement loginViaNickNameMessage;

    public MainPage() {
        super();
    }

    @Override
    public void openPage() {
        driver.navigate().to(properties.getPropertyValueByKey("url"));
    }

    public void enterAccount() {
        entranceButton.click();
    }

    public String getLoginViaNickNameMessage() {
        return loginViaNickNameMessage.getText();
    }
}
