package tests;

import indices.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import properties.Type;


public class PositiveSmokeTest extends BaseTest {

    @Test(description = "Test to check if the entrance form opens")
    public void entranceFormTest() {
        MainPage newMainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail", "Message under login field wasn't found.");
    }

    @Test(description = "Test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        ShoppingCartPage shoppingCartPage = new MainPage()
                .openPage()
                .isPageOpened()
                .goToShoppingCart()
                .isPageOpened();
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "корзина", "Shopping cart message wasn't found.");
    }

    @Test(description = "Test for registration of a new user", enabled = false)
    public void registrationTest() {
        String password = faker.internet().password();
        String login = faker.internet().emailAddress();
        RegistrationPage registrationPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .goToRegistrationLink()
                .isPageOpened()
                .setLogin(login)
                .setPassword(password)
                .setRepeatPassword(password)
                .acceptPrivacyPolicy()
                .clickRegistrationButton();
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Test(description = "Test for login with correct credentials")
    public void logInTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty(Type.LOGIN))
                .insertPassword(props.getKeyProperty(Type.PASSWORD))
                .clickEntranceButton();
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The avatar cannot be displayed");
    }

    @Test(description = "Add an item to the shopping cart test")
    public void addItemToCartTest() {
        ShoppingCartPage cartPage = new MainPage()
                .openPage()
                .isPageOpened()
                .clickOnCatalogue()
                .isPageOpened()
                .getIconOption(Icons.FOOD)
                .getLeftDropdown(Icons.FOOD, Food.PIZZA)
                .getMiddleDropdown(DominoPage.class, Icons.FOOD, Pizza_Options.DOMINO)
                .isPageOpened()
                .choosePizza(PepperoniPage.class, "Пицца Domino's Пепперони (классика, 36 см)")
                .clickAddToCartButton()
                .clickCartButton();
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added");
    }

    @Test(description = "Redirection to 'About' page test")
    public void aboutPageTest() {
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .isPageOpened()
                .goToAboutCompanyLink();
        Assert.assertEquals(aboutCompanyPage.getAboutPageText(), "реквизиты и юридический адрес:", "About page wasn't opened");
    }

    @Test(description = "Test to choose Apple manufacturer in the filter")
    public void chooseManufacturerTest() {
        ApplePage applePage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .getIconOption(Icons.ELECTRONICS)
                .getLeftDropdown(Icons.ELECTRONICS, Electronics.MOBILE_PHONES)
                .getMiddleDropdown(SmartphonePage.class, Icons.ELECTRONICS, Phone_Devices.SMARTPHONES)
                .chooseManufacturer(ApplePage.class, "apple")
                .displayTag();
        Assert.assertEquals(applePage.tagText(), "apple", "The filter doesn't work");
    }
}
