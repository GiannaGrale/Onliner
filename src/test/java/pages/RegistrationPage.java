package pages;

import elements.Button;
import elements.Checkbox;
import elements.Input;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.WaitUtils;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    protected Input loginInputField;

    @FindBy(xpath = "//div[6]/descendant::input")
    protected Input passwordInputField;

    @FindBy(xpath = "//div[@autocomplete='repeatPassword']/descendant::input")
    protected Input repeatPasswordInputField;

    @FindBy(xpath = "//span[@class='i-checkbox__faux']")
    protected Checkbox privacyPolicyCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    protected Button registrationButton;

    @FindBy(css = ".auth-container .auth-form__title ")
    protected Button emailConfirmationRequestButton;

    @Override
    public RegistrationPage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.REGISTRATION_URL));
        logger.debug("Navigation to the regURl...");
        return this;
    }

    @Override
    public RegistrationPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(loginInputField);
        } catch (TimeoutException e) {
            logger.debug("RegistrationPage wasn't opened. LoginInputField wasn't found ");
            Assert.fail("RegistrationPage was not opened");
        }
        return this;
    }

    /***
     * Insert the login into the login field
     * @param login login
     */
    public RegistrationPage setLogin(String login) {
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
