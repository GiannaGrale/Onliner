package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private final static By ENTRANCE_BUTTON = By.className("auth-bar__item--text");
    private final static By LOGIN_VIA_NICKNAME_MESSAGE = By.xpath("//div[@class='auth-form__label-part auth-form__label-part_1']/following::div[@class='auth-form__label-title']");

    public MainPage() {
        super();
    }

    public void openPage() {
        driver.navigate().to(properties.getURL());
    }

    public WebElement getEntranceButton() {
        return driver.findElement(ENTRANCE_BUTTON);
    }

    public WebElement getLoginViaNicknameElement() {
        return driver.findElement(LOGIN_VIA_NICKNAME_MESSAGE);
    }

    public void enterAccount() {
        getEntranceButton().click();
    }

    public String getLoginViaNickNameMessage() {
        return  getLoginViaNicknameElement().getText();
    }
}
