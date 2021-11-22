package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class PositiveSmokeTest extends BaseTest {

    @Test(groups = {"login"}, description = "Test to check if the entrance form opens")
    public void entranceFormTest() {
        logger.info("entranceFromTest is started...");
        MainPage newMainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail", "Message under login field wasn't found.");
        logger.info("entranceFromTest is finished...");
    }

    @Test(groups = {"cart"},description = "Test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        logger.info("shoppingCartEntranceFormTest is started...");
        ShoppingCartPage shoppingCartPage = new MainPage()
                .openPage()
                .isPageOpened()
                .goToShoppingCart();
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "корзина", "Shopping cart message wasn't found.");
        logger.info("shoppingCartEntranceFormTest is finished...");
    }

    @Test(groups = {"login"}, description = "Test for registration of a new user", enabled = false)
    public void registrationTest() {
        String password = faker.internet().password();
        String login = faker.internet().emailAddress();
        logger.info("registrationTest is started...");
        RegistrationPage registrationPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .goToRegistrationLink()
                .setLogin(login)
                .setPassword(password)
                .setRepeatPassword(password)
                .acceptPrivacyPolicy()
                .clickRegistrationButton();
        logger.info("registrationTest is finished...");
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Test(groups = {"login"}, description = "Test for login with correct credentials")
    public void logInTest() {
        logger.info("logInTest is started...");
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty("login"))
                .insertPassword(props.getKeyProperty("password"))
                .clickEntranceButton();
        logger.info("logInTest is finished...");
        Assert.assertTrue(mainPage.getAvatar(), " The avatar cannot be displayed");
    }

    @Test(groups = {"cart"},description = "Add an item to the shopping cart test")
    public void addItemToCartTest() {
        logger.info("addItemToCartTest is started...");
        ShoppingCartPage cartPage = new MainPage()
                .openPage()
                .isPageOpened()
                .clickOnCatalogue()
                .getIconOption(16)
                .getLeftSideDropdownItem(16)
                .getMiddleDropdownItem(DominoPage.class,16)
                .choosePizza(PepperoniPage.class, "Пицца Domino's Пепперони (классика, 36 см)")
                .clickAddToCartButton()
                .clickCartButton();
        logger.info("addItemToCartTest is finished...");
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added");
    }

    @Test(groups = {"redirection"},description = "Redirection to 'About' page test")
    public void aboutPageTest() {
        logger.info("aboutPageTest is started...");
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .isPageOpened()
                .goToAboutCompanyLink();
        logger.info("aboutPageTest is finished...");
        Assert.assertEquals(aboutCompanyPage.getAboutPageText(), "реквизиты и юридический адрес:", "About page wasn't opened");
    }

    @Test(groups = {"filters"}, description = "Test to choose Apple manufacturer in the filter")
    public void chooseManufacturerTest()  {
        logger.info("chooseManufacturerTest is started...");
        ApplePage applePage = new MainPage()
                .openPage()
                .isPageOpened()
                .clickOnCatalogue()
                .getIconOption(1)
                .getLeftSideDropdownItem(1)
                .getMiddleDropdownItem(SmartphonePage.class,1)
                .goToCheckbox("apple")
                .chooseManufacturer(ApplePage.class)
                .displayTag();
        logger.info("chooseManufacturerTest is finished...");
        Assert.assertEquals(applePage.tagText(), "apple", "The filter doesn't work");
    }
}
