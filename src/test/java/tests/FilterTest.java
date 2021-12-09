package tests;

import entities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApplePage;
import pages.DominoPage;
import pages.MainPage;
import pages.SmartphonePage;
import testData.Catalogue;

public class FilterTest extends BaseTest {
    @Test(description = "TC-5, Test to choose a manufacturer in the filter")
    public void chooseManufacturerTest() {
        ApplePage applePage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .selectCatalogueDetail(SmartphonePage.class, Icons.ELECTRONICS, Electronics.MOBILE_PHONES, CatalogueOptions.SMARTPHONES)
                .chooseBrand(Catalogue.APPLE)
                .displayTag();
        Assert.assertEquals(applePage.tagText(), "apple", "The filter doesn't work");
    }

    @Test(description = "TC-10, Test to check system behavior while entering negative start price for the goods")
    public void negativePriceTest() {
        DominoPage dominoPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .selectCatalogueDetail(DominoPage.class, Icons.FOOD, Food.PIZZA, CatalogueOptions.DOMINO)
                .setMinPrice(Catalogue.PRICE);
        Assert.assertTrue(dominoPage.areNoGoodsWarning(), "Goods are available");
    }
}
