package cucumber_tests.steps;

import entities.CatalogueOptions;
import entities.Food;
import entities.Icons;
import exceptions.IncorrectClassRedirectionException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import testData.Catalogue;

public class CartStepDefinition extends BaseStepDefinition {

    @When("Food catalogue details are selected")
    public void foodCatalogueDetailsAreSelected() throws IncorrectClassRedirectionException {
        cataloguePage.selectCatalogueDetail(Icons.FOOD, Food.PIZZA, CatalogueOptions.DOMINO, DominoPage.class);
    }

    @And("The shopping cart badge is clicked on")
    public void clickOnTheShoppingCartBadge() {
        mainPage.goToShoppingCart();
    }

    @And("A food item is chosen from the catalogue list")
    public void chooseAnItemFromTheCatalogueList() throws IncorrectClassRedirectionException {
        dominoPage.choosePizza(Catalogue.PIZZA, PepperoniPage.class);
    }

    @And("The item is added to the cart")
    public void addTheItemToTheCart() {
        pepperoniPage.clickAddToCartButton();
    }

    @Then("Get the shopping cart label")
    public void checkShoppingCartMessage() {
        Assert.assertEquals(cartPage.getShoppingCartMessage(), "корзина", "Shopping cart message while opening the entrance form wasn't found.");
    }

    @Then("Check if the item was added to the shopping cart")
    public void checkIfTheItemWasAddedToTheShoppingCart() {
        Assert.assertEquals(cartPage.getCompleteOrderButtonText(), "перейти к оформлению", "The item wasn't added to the shopping cart");
    }
}
