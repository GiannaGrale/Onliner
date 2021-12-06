package tests;

import indices.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApplePage;
import pages.DominoPage;
import pages.MainPage;
import pages.SmartphonePage;
import testData.Catalogue;


public class FilterTest extends BaseTest {

    @Test(description = "Positive test to choose Apple manufacturer in the filter")
    public void chooseManufacturerTest() {
        ApplePage applePage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .getIconOption(Icons.ELECTRONICS)
                .getLeftDropdown(Icons.ELECTRONICS, Electronics.MOBILE_PHONES)
                .getMiddleDropdown(SmartphonePage.class, Pages.SMARTPHONE, Icons.ELECTRONICS, PhoneDevices.SMARTPHONES)
                .chooseManufacturer(ApplePage.class, Pages.APPLE, Catalogue.BRAND)
                .displayTag();
        Assert.assertEquals(applePage.tagText(), "apple", "The filter doesn't work");
    }

    @Test(description = "Negative test to check system behavior while entering negative start price for the goods")
    public void negativePriceTest() {
        DominoPage dominoPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .getIconOption(Icons.FOOD)
                .getLeftDropdown(Icons.FOOD, Food.PIZZA)
                .getMiddleDropdown(DominoPage.class, Pages.DOMINO, Icons.FOOD, PizzaOptions.DOMINO)
                .setMinPrice(Catalogue.PRICE);
        Assert.assertTrue(dominoPage.areGoodsDisplayed(), "Goods are available");
    }
}
