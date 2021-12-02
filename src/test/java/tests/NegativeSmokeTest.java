package tests;

import indices.Food;
import indices.Pages;
import indices.PizzaOptions;
import testData.Catalogue;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DominoPage;
import indices.Icons;
import pages.MainPage;
import properties.Property;
import util.RandomSymbolUtil;

public class NegativeSmokeTest extends BaseTest {

    @Test(description = "Test to check system behavior using the correct password and incorrect login")
    public void setIncorrectLoginTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm()
                .insertLogin(RandomSymbolUtil.fakeLogin)
                .insertPassword(props.getKeyProperty(Property.PASSWORD))
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The login is correct!");
    }

    @Test(description = "Test to check system behavior using the correct login and incorrect password")
    public void setIncorrectPasswordTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty(Property.LOGIN))
                .insertPassword(RandomSymbolUtil.fakePassword)
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The password is correct!");
    }

    @Test(description = "Test to check system behavior using no credentials")
    public void setNoCredentialsTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .openEntranceForm()
                .insertLogin(RandomSymbolUtil.noCredentials)
                .insertPassword(RandomSymbolUtil.noCredentials)
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getPasswordInputWarning(), "укажите пароль", "You've logged in with these credentials");
    }

    @Test(description = "Test the input hint while entering nonexistent item")
    public void searchFieldTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .insertTextIntoSearch(RandomSymbolUtil.fakeQuery);
        Assert.assertEquals(mainPage.getSearchInputMessage(), "ничего не найдено", "The search field isn't opened or such item exists");
    }

    @Test(description = "Test system behavior while entering negative start price for the goods")
    public void negativePriceTest() {
        DominoPage dominoPage = new MainPage()
                .openPage()
                .waitForPageOpened()
                .clickOnCatalogue()
                .waitForPageOpened()
                .getIconOption(Icons.FOOD)
                .getLeftDropdown(Icons.FOOD, Food.PIZZA)
                .getMiddleDropdown(DominoPage.class, Pages.DOMINO, Icons.FOOD, PizzaOptions.DOMINO)
                .waitForPageOpened()
                .setMinPrice(Catalogue.PRICE);
        Assert.assertTrue(dominoPage.areGoodsDisplayed(), "Goods are available");
    }
}
