package pages;

import elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.ConfigStorage;
import util.WaitUtils;

public class MainPage extends BasePage {

    private final String MAIN_URL = ConfigStorage.getMainUrl();

    @FindBy(className = "auth-bar__item--text")
    private Button entranceButton;

    @FindBy(className = "auth-bar__item--cart")
    private Button shoppingCartButton;

    @FindBy(className = "auth-form__label-title")
    private Text loginViaText;

    @FindBy(linkText = "Зарегистрироваться на Onlíner")
    private Link registrationLink;

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private Input loginInput;

    @FindBy(xpath = "//input[@type='password']")
    private Input passwordInput;

    @FindBy(css = ".auth-form__control .auth-button")
    private Button loginButton;

    @FindBy(className = "js-header-user-avatar")
    private Picture avatarPicture;

    @FindBy(xpath = "//nav//li[1]/a[2]/span")
    private Link catalogueLink;

    @FindBy(xpath = "//footer//ul/li[1]/a")
    private Link aboutCompanyLink;

    @FindBy(css = ".auth-form__description.auth-form__description_extended-other")
    private Text incorrectCredentialsWarningText;

    @FindBy(xpath = "//form/input[@name='query']")
    private Input mainSearchFieldText;

    @FindBy(css = ".search__suggest-addon.search__suggest-addon_active")
    private Text searchInputText;

    public MainPage() {
        super();
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(MAIN_URL);
        logger.debug("Navigation to the URL " + MAIN_URL);
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
    public String getLoginOptionMessage() {
        return loginViaText.getText().toLowerCase().trim();
    }

    /***
     * Display message "Cart" while entering the shopping cart
     * @return return message of shoppingCartMessage element
     */
    public String getIncorrectCredentials() {
        WaitUtils.waitForVisibility(incorrectCredentialsWarningText);
        return incorrectCredentialsWarningText.getText().toLowerCase().trim();
    }
    /***
     * While entering a phrase into the input field, a hint appears
     * @return hint message
     */
    public String getSearchInputMessage() {
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        WaitUtils.waitForVisibility(searchInputText);
        return searchInputText.getText().toLowerCase().trim();
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
        mainSearchFieldText.sendKeys(text);
        mainSearchFieldText.sendKeys(Keys.ENTER);
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
