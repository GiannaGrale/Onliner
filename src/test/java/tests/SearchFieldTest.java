package tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import util.RandomSymbolUtil;

public class SearchFieldTest extends BaseTest {

    @Feature("Search field")
    @Test(description = "TC-9, Test to check the input hint while entering nonexistent item")
    public void searchFieldTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .insertTextIntoSearch(RandomSymbolUtil.getRandomQuery());
        Assert.assertEquals(mainPage.getSearchInputMessage(), "ничего не найдено", "The search field wasn't opened or the item that shouldn't be found appears in the search");
    }
}
