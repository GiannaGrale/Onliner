package pages;

import drivers.DriverManager;
import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.WaitUtils;


public class MainPage extends BasePage {

    @FindBy(className = "auth-bar__item--text")
    public Button entranceButton;

    @FindBy(className = "auth-bar__item--cart")
    public Button shoppingCartButton;

    @FindBy(xpath = "//form/descendant::div[@class='auth-form__label-title']")
    public Text loginViaNickNameMessage;

    @FindBy(linkText = "Зарегистрироваться на Onlíner")
    public Link registrationLink;

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    public Input loginInput;

    @FindBy(xpath = "//input[@type='password']")
    public Input passwordInput;

    @FindBy(css = ".auth-form__control .auth-button")
    public Button loginButton;

    @FindBy(className = "js-header-user-avatar")
    public Picture avatarPicture;

    @FindBy(xpath = "//nav//li[1]/a[2]/span")
    public Link catalogueLink;

    @FindBy(xpath = "//footer//ul/li[1]/a")
    public Link aboutCompanyLink;

    @FindBy(css = ".auth-form__description.auth-form__description_extended-other")
    public Text incorrectCredentialsWarning;

    @FindBy(xpath = "//*[contains(text(),'Укажите пароль')]")
    public Text emptyPasswordWarning;

    @FindBy(xpath = "//form/input[@name='query']")
    public Input mainSearchField;

    @FindBy(css = ".search__suggest-addon.search__suggest-addon_active")
    public Text searchInputMessage;

    public MainPage() {
        super();
    }

    @Override
    public MainPage openPage() {
        DriverManager.getDriver().navigate().to(props.getKeyProperty(Property.URL));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public MainPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(entranceButton);
        } catch (TimeoutException e) {
            Assert.fail("MainPage was not opened");
        }
        return this;
    }

    /***
     * Click on the entrance button
     */
    public MainPage openEntranceForm() {
        waitForPageOpened();
        entranceButton.click();
        return this;
    }

    /***
     * Click on the shopping cart icon
     */
    public ShoppingCartPage goToShoppingCart() {
        shoppingCartButton.click();
        return new ShoppingCartPage();
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
    public String getLoginWarningMessage() {
        WaitUtils.waitForVisibility(incorrectCredentialsWarning);
        return incorrectCredentialsWarning.getText().toLowerCase().trim();
    }

    /***
     * While entering no password, a warning message appears
     * @return warning message
     */
    public String getPasswordInputWarning() {
        WaitUtils.waitForVisibility(emptyPasswordWarning);
        return emptyPasswordWarning.getText().toLowerCase().trim();
    }

    /***
     * While entering a phrase into the input field, a hint appears
     * @return hint message
     */
    public String getSearchInputMessage() {
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        WaitUtils.waitForVisibility(searchInputMessage);
        return searchInputMessage.getText().toLowerCase().trim();
    }

    /***
     * Insert the login into the login input
     * @param login login
     */
    public MainPage insertLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    /***
     * Insert the password to into the password input
     * @param psw password
     */
    public MainPage insertPassword(String psw) {
        passwordInput.sendKeys(psw);
        return this;
    }

    /***
     * Click the entrance button
     */
    public MainPage clickEntranceButton() {
        loginButton.click();
        return this;
    }

    /***
     * Insert a text into the search field and look for items
     * @param text any query
     */
    public MainPage insertTextIntoSearch(String text) {
        mainSearchField.sendKeys(text);
        mainSearchField.sendKeys(Keys.ENTER);
        return this;
    }

    /***
     * Click on the catalogue button
     */
    public CataloguePage clickOnCatalogue() {
        catalogueLink.click();
        return new CataloguePage();
    }

    /***
     * When signed in, an avatar appears on the main page
     */
    public boolean isAvatarDisplayed() {
        WaitUtils.waitForVisibility(avatarPicture);
        return avatarPicture.isDisplayed();
    }

    /***
     * Redirection to the registration form
     */
    public RegistrationPage goToRegistrationLink() {
        registrationLink.click();
        return new RegistrationPage();
    }

    /***
     * Redirection to "About company" page
     */
    public AboutCompanyPage goToAboutCompanyLink() {
        aboutCompanyLink.click();
        return new AboutCompanyPage();
    }
}
