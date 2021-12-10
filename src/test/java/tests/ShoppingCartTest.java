package tests;

import entities.CatalogueOptions;
import entities.Food;
import entities.Icons;
import exceptions.IncorrectClassRedirectionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DominoPage;
import pages.MainPage;
import pages.PepperoniPage;
import pages.ShoppingCartPage;
import testData.Catalogue;

public class ShoppingCartTest extends BaseTest {

    @Test(description = "Test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        ShoppingCartPage shoppingCartPage = new MainPage()
                .openPage()
                .goToShoppingCart();
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "корзина", "Shopping cart message while opening the entrance form wasn't found.");
    }

    @Test(description = "TC-4, Add an item to the shopping cart test")
    public void addItemToCartTest() throws IncorrectClassRedirectionException {
        ShoppingCartPage cartPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .selectCatalogueDetail(Icons.FOOD, Food.PIZZA, CatalogueOptions.DOMINO, DominoPage.class)
                .choosePizza(Catalogue.PIZZA, PepperoniPage.class)
                .clickAddToCartButton()
                .clickCartButton();
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added to the shopping cart");
    }
}
