package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DominoPage;
import pages.MainPage;

public class NegativeSmokeTest extends BaseTest {

    @Test (description = "Test to check system behavior using the correct password and incorrect login")
    public void setIncorrectLoginTest() {
        logger.info("setIncorrectLoginTest is started...");
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .insertLogin(faker.internet().emailAddress())
                .insertPassword(props.getKeyProperty("password"))
                .clickEntranceButton();
        logger.info("setIncorrectLoginTest is finished...");
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The login is correct!");
    }

    @Test(description = "Test to check system behavior using the correct login and incorrect password")
    public void setIncorrectPasswordTest() {
        logger.info("setIncorrectPasswordTest is started...");
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty("login"))
                .insertPassword(faker.internet().password())
                .clickEntranceButton();
        logger.info("setIncorrectPasswordTest is finished...");
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The password is correct!");
    }

    @Test(description = "Test to check system behavior using no credentials")
    public void setNoCredentialsTest() {
        logger.info("setNoCredentialsTest is started...");
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .openEntranceForm()
                .insertLogin("")
                .insertPassword("")
                .clickEntranceButton();
        logger.info("setNoCredentialsTest is finished...");
        Assert.assertEquals(mainPage.getPasswordInputWarning(), "укажите пароль", "You've logged in with these credentials");
    }

    @Test(description = "Test the input hint while entering nonexistent item")
    public void searchFieldTest() {
        logger.info("searchFieldTest is started...");
        MainPage mainPage = new MainPage()
                .openPage()
                .isPageOpened()
                .insertTextIntoSearch(faker.internet().ipV6Address());
        logger.info("searchFieldTest is finished...");
        Assert.assertEquals(mainPage.getSearchInputHint(), "ничего не найдено", "The search field isn't opened or such item exists");
    }

    @Test(description = "Test system behavior while entering negative start price for the goods")
    public void negativePriceTest() {
        logger.info("negativePriceTest is started...");
        DominoPage dominoPage = new MainPage()
                .openPage()
                .isPageOpened()
                .clickOnCatalogue()
                .getIconOption(16)
                .getLeftSideDropdownItem(16)
                .getMiddleDropdownItem(DominoPage.class,16)
                .setMinPrice("-60");
        logger.info("negativePriceTest is finished...");
        Assert.assertTrue(dominoPage.noGoods(), "Goods are available");
    }
}
