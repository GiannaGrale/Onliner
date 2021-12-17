package cucumber_tests.steps;

import cucumber_tests.support.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import util.RandomSymbolUtil;

public class SearchStepDefinition extends BaseStepDefinition {

    @And("A random query is inserted into the search field")
    public void aRandomQueryIsInsertedIntoTheSearchField() {
         String randomQuery = RandomSymbolUtil.getRandomQuery();
         mainPage.insertTextIntoSearch(randomQuery);
         scenarioContext.setContext(Context.QUERY, randomQuery);
    }

    @Then("Check whether an item was found with the query")
    public void checkWhetherAnItemWasFound() {
        Assert.assertEquals(mainPage.getSearchInputMessage(), "ничего не найдено", "The search field wasn't opened or the item that shouldn't be found appears in the search");
    }

    @And("Check if the query was inserted into the search field")
    public void checkSearchFieldInput() {
        String randomQuery = String.valueOf(scenarioContext.getContext(Context.QUERY));
        Assert.assertEquals(mainPage.getSearchFieldText(), randomQuery);
    }
}
