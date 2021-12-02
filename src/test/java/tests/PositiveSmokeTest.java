package tests;

import indices.*;
import testData.Catalogue;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import properties.Property;
import util.RandomSymbolUtil;


public class PositiveSmokeTest extends BaseTest {

    @Test(description = "Test to check if the entrance form opens")
    public void entranceFormTest() {
        MainPage newMainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail", "Message under login field wasn't found.");
    }

    @Test(description = "Test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        ShoppingCartPage shoppingCartPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .goToShoppingCart()
                .waitForPageOpened();
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "корзина", "Shopping cart message wasn't found.");
    }

    @Test(description = "Test for registration of a new user", enabled = false)
    public void registrationTest() {
        RegistrationPage registrationPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm()
                .goToRegistrationLink()
                .waitForPageOpened()
                .setLogin(RandomSymbolUtil.fakeLogin)
                .setPassword(RandomSymbolUtil.fakePassword)
                .setRepeatPassword(RandomSymbolUtil.fakePassword)
                .acceptPrivacyPolicy()
                .clickRegistrationButton();
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Test(description = "Test for login with correct credentials")
    public void logInTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty(Property.LOGIN))
                .insertPassword(props.getKeyProperty(Property.PASSWORD))
                .clickEntranceButton();
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The avatar cannot be displayed");
    }

    @Test(description = "Add an item to the shopping cart test")
    public void addItemToCartTest() {
        ShoppingCartPage cartPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .waitForPageOpened()
                .getIconOption(Icons.FOOD)
                .getLeftDropdown(Icons.FOOD, Food.PIZZA)
                .getMiddleDropdown(DominoPage.class, Pages.DOMINO, Icons.FOOD, PizzaOptions.DOMINO)
                .waitForPageOpened()
                .choosePizza(PepperoniPage.class, Pages.PEPPERONI, Catalogue.PIZZA)
                .waitForPageOpened()
                .clickAddToCartButton()
                .clickCartButton();
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added");
    }

    @Test(description = "Redirection to 'About' page test")
    public void aboutPageTest() {
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .goToAboutCompanyLink();
        Assert.assertEquals(aboutCompanyPage.getAboutPageText(), "реквизиты и юридический адрес:", "About page wasn't opened");
    }

    @Test(description = "Test to choose Apple manufacturer in the filter")
    public void chooseManufacturerTest() {
        ApplePage applePage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .waitForPageOpened()
                .getIconOption(Icons.ELECTRONICS)
                .getLeftDropdown(Icons.ELECTRONICS, Electronics.MOBILE_PHONES)
                .getMiddleDropdown(SmartphonePage.class, Pages.SMARTPHONE, Icons.ELECTRONICS, PhoneDevices.SMARTPHONES)
                .waitForPageOpened()
                .chooseManufacturer(ApplePage.class, Pages.APPLE, Catalogue.BRAND)
                .displayTag();
        Assert.assertEquals(applePage.tagText(), "apple", "The filter doesn't work");
    }
}
