package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(className = "auth-bar__item--text")
    public static WebElement entrance_Button;

    @FindBy(xpath = "//div[@class='auth-form__label-part auth-form__label-part_1']/following::div[@class='auth-form__label-title']")
    public static WebElement login_Via_NickName_Message;

    public MainPage() {
        super();
    }

    public void openPage() {
        driver.navigate().to(properties.getURL());
    }

    public void enterAccount() {
        entrance_Button.click();
    }

    public String getLoginViaNickNameMessage() {
        return login_Via_NickName_Message.getText();
    }
}
