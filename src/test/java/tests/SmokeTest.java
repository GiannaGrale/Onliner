package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


public class SmokeTest extends BaseTest {

    @Test (description = "Test to check the entrance form")
    public void entranceFormTest() {
        MainPage newMainPage = new MainPage();
        newMainPage.openPage();
        newMainPage.isPageOpened();
        newMainPage.openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail", "Message under login field isn't found.");
    }

    @Test (description = "Test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        MainPage newMainPage = new MainPage();
        newMainPage.openPage();
        newMainPage.isPageOpened();
        newMainPage.goToShoppingCart();
        Assert.assertEquals(newMainPage.getShoppingCartMessage(), "корзина", "Shopping cart message isn't found.");
    }
}
