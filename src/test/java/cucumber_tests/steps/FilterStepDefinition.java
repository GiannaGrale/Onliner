package cucumber_tests.steps;

import entities.CatalogueOptions;
import entities.Electronics;
import entities.Food;
import entities.Icons;
import exceptions.IncorrectClassRedirectionException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import testData.Catalogue;

public class FilterStepDefinition extends BaseStepDefinition {

    @When("Pizza catalogue details are selected")
    public void pizzaCatalogueDetailsAreSelected() throws IncorrectClassRedirectionException {
        cataloguePage.selectCatalogueDetail(Icons.FOOD, Food.PIZZA, CatalogueOptions.DOMINO, DominoPage.class);
    }

    @When("Smartphone catalogue details are selected")
    public void catalogueDetailsAreSelected() throws IncorrectClassRedirectionException {
        cataloguePage.selectCatalogueDetail(Icons.ELECTRONICS, Electronics.MOBILE_PHONES, CatalogueOptions.SMARTPHONES, SmartphonePage.class);
    }

    @And("Set a price {string}")
    public void setAPrice(String price) {
        dominoPage.setMinPrice(price);
    }

    @And("Catalogue is opened")
    public void catalogueIsOpened() {
        mainPage.clickOnCatalogue();
    }

    @And("Brand is chosen")
    public void brandIsChosen() {
        smartphonePage.chooseBrand(Catalogue.APPLE);
    }

    @Then("Check if the page was filtered")
    public void checkIfThePageWasFiltered() {
        Assert.assertEquals(applePage.tagText(), "apple", "The apple manufacturer filter doesn't work");
    }

    @Then("Check the goods according to the price filter")
    public void checkThePresenceOfGoodsAccordingToThePriceFilter() {
        Assert.assertTrue(dominoPage.areNoGoodsWarningDisplayed(), "Goods that shouldn't be displayed, appear on the page");
    }
}
