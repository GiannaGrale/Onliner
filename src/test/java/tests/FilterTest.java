package tests;

import entities.*;
import exceptions.IncorrectClassRedirectionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ApplePage;
import pages.DominoPage;
import pages.MainPage;
import pages.SmartphonePage;
import testData.Catalogue;

public class FilterTest extends BaseTest {

    @Test(description = "TC-5, Test to choose a manufacturer in the filter")
    public void chooseManufacturerTest() throws IncorrectClassRedirectionException {
        ApplePage applePage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .selectCatalogueDetail(Icons.ELECTRONICS, Electronics.MOBILE_PHONES, CatalogueOptions.SMARTPHONES, SmartphonePage.class)
                .chooseBrand(Catalogue.APPLE);
        Assert.assertEquals(applePage.tagText(), "apple", "The apple manufacturer filter doesn't work");
    }

    @Test(description = "TC-10, Test to check system behavior while entering negative start price for the goods")
    public void negativePriceTest() throws IncorrectClassRedirectionException {
        DominoPage dominoPage = new MainPage()
                .openPage()
                .clickOnCatalogue()
                .selectCatalogueDetail(Icons.FOOD, Food.PIZZA, CatalogueOptions.DOMINO, DominoPage.class)
                .setMinPrice(Catalogue.PRICE);
        Assert.assertTrue(dominoPage.areNoGoodsWarningDisplayed(), "Goods that shouldn't be displayed, appear on the page");
    }
}
