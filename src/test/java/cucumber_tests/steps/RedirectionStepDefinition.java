package cucumber_tests.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RedirectionStepDefinition extends BaseStepDefinition {

    @When("Click on 'About company' link")
    public void clickOnLink() {
        mainPage.goToAboutCompanyLink();
    }

    @Then("Check if the page was opened")
    public void checkIfPageWasOpened() {
        Assert.assertEquals(aboutCompanyPage.getAboutPageTitle(), "о сайте", "About page wasn't opened");
    }
}
