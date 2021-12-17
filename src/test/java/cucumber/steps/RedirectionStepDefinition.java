package cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RedirectionStepDefinition extends BaseStepDefinition {

    @When("Click on 'About company' link")
    public void clickOnLink() {
        mainPage.goToAboutCompanyLink();
    }

    @Then("Check if the page was opened:{string} label appears")
    public void checkIfPageWasOpened(String page) {
        Assert.assertEquals(aboutCompanyPage.getAboutPageTitle(), page, "About page wasn't opened");
    }
}
