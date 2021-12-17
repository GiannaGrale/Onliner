package cucumber.steps;

import cucumber.support.Context;
import cucumber.support.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import util.RandomSymbolUtil;

public class SearchStepDefinition extends BaseStepDefinition {

    @And("A random query is inserted into the search field")
    public void aRandomQueryIsInsertedIntoTheSearchField() {
         String randomQuery = RandomSymbolUtil.getRandomQuery();
         mainPage.insertTextIntoSearch(randomQuery);
         ScenarioContext.getInstance().setContext(Context.QUERY, randomQuery);
    }

    @Then("Check whether an item was found with the query: {string} pops up")
    public void checkWhetherAnItemWasFound(String result) {
        Assert.assertEquals(mainPage.getSearchInputMessage(), result, "The search field wasn't opened or the item that shouldn't be found appears in the search");
    }

    @And("Check if the query was inserted into the search field")
    public void checkSearchFieldInput() {
        String randomQuery = String.valueOf(ScenarioContext.getInstance().getContext(Context.QUERY));
        Assert.assertEquals(mainPage.getSearchFieldText(), randomQuery);
    }
}
