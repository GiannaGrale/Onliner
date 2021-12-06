package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import util.RandomSymbolUtil;


public class SearchFieldTest extends BaseTest {

    @Test(description = "Negative test to check the input hint while entering nonexistent item")
    public void searchFieldTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .insertTextIntoSearch(RandomSymbolUtil.getRandomQuery());
        Assert.assertEquals(mainPage.getSearchInputMessage(), "ничего не найдено", "The search field isn't opened or such item exists");
    }
}
