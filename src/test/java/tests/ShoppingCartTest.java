package tests;

import indices.Food;
import indices.Icons;
import indices.Pages;
import indices.PizzaOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DominoPage;
import pages.MainPage;
import pages.PepperoniPage;
import pages.ShoppingCartPage;
import testData.Catalogue;


public class ShoppingCartTest extends BaseTest {

    @Test(description = "Positive test to check the entrance to the shopping cart")
    public void shoppingCartEntranceFormTest() {
        ShoppingCartPage shoppingCartPage = new MainPage()
                .openPage()
                .goToShoppingCart();
        Assert.assertEquals(shoppingCartPage.getShoppingCartMessage(), "корзина", "Shopping cart message wasn't found.");
    }

    @Test(description = "Add an item to the shopping cart positive test")
    public void addItemToCartTest() {
        ShoppingCartPage cartPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .getIconOption(Icons.FOOD)
                .getLeftDropdown(Icons.FOOD, Food.PIZZA)
                .getMiddleDropdown(DominoPage.class, Pages.DOMINO, Icons.FOOD, PizzaOptions.DOMINO)
                .choosePizza(PepperoniPage.class, Pages.PEPPERONI, Catalogue.PIZZA)
                .clickAddToCartButton()
                .clickCartButton();
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added");
    }
}
