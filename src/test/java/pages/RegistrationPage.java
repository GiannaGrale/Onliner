package pages;

import elements.Button;
import elements.Checkbox;
import elements.Input;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.ConfigStorage;
import util.WaitUtils;

public class RegistrationPage extends BasePage {

    private final String REGISTRATION_URL = ConfigStorage.getRegistrationUrl();

    @FindBy(xpath = "//input[@type='email']")
    private Input loginInputField;

    @FindBy(xpath = "//div[6]/descendant::input")
    private Input passwordInputField;

    @FindBy(xpath = "//div[@autocomplete='repeatPassword']/descendant::input")
    private Input repeatPasswordInputField;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    private Checkbox privacyPolicyCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private Button registrationButton;

    @FindBy(css = ".auth-container .auth-form__title ")
    private Button emailConfirmationRequestButton;

    public RegistrationPage() {
        super();
    }

    @Override
    public RegistrationPage openPage() {
        driver.navigate().to(REGISTRATION_URL);
        logger.debug("Navigation to the URL " + REGISTRATION_URL);
        return this;
    }

    @Override
    public RegistrationPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(loginInputField);
        } catch (TimeoutException e) {
            Assert.fail("RegistrationPage was not opened");
        }
        return this;
    }

    /***
     * Insert the login into the login field
     * @param login login
     */
    public RegistrationPage setLogin(String login) {
        waitForPageOpened();
        loginInputField.sendKeys(login);
        return this;
    }

    /***
     * Insert the password to the password field
     * @param password password
     */
    public RegistrationPage setPassword(String password) {
        passwordInputField.sendKeys(password);
        return this;
    }

    /***
     * Duplicate the password into the password repeat field
     * @param password password
     */
    public RegistrationPage setRepeatPassword(String password) {
        repeatPasswordInputField.sendKeys(password);
        return this;
    }

    /***
     * Click the registration button
     */
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return this;
    }

    /***
     * Check the accept privacy policy box
     */
    public RegistrationPage acceptPrivacyPolicy() {
        privacyPolicyCheckbox.click();
        return this;
    }

    /***
     * Redirection to the message on email confirmation request
     */
    public String emailConfirmationMessage() {
        WaitUtils.waitForInvisibility(registrationButton);
        WaitUtils.waitForVisibility(emailConfirmationRequestButton);
        return emailConfirmationRequestButton.getText().trim();
    }
}
