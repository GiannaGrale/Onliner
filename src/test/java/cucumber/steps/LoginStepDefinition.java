package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import util.RandomSymbolUtil;

public class LoginStepDefinition extends BaseStepDefinition {

    @Given("Main page is opened")
    public void openMainPage() {
        mainPage.openPage();
    }

    @When("Open the entrance form")
    public void openRegistrationForm() {
        mainPage.openEntranceForm();
    }

    @And("Click on the registration link")
    public void goToTheRegistrationLink() {
        mainPage.goToRegistrationLink();
    }

    @And("Set a new login")
    public void setNewLogin() {
        registrationPage.setLogin(RandomSymbolUtil.getRandomLogin());
    }

    @And("Set a new password")
    public void setNewPassword() {
        String password = RandomSymbolUtil.getRandomPassword();
        registrationPage.setPassword(password);
        registrationPage.setRepeatPassword(password);
    }

    @And("Accept the privacy policy")
    public void privacyPolicyIsAccepted() {
        registrationPage.acceptPrivacyPolicy();
    }

    @And("Click on the registration button")
    public void clickTheRegistrationButton() {
        registrationPage.clickRegistrationButton();
    }

    @And("Set the login {string}")
    public void setLogin(String login) {
        mainPage.insertLogin(login);
    }

    @And("Set the password {string}")
    public void setPassword(String password) {
        mainPage.insertPassword(password);
    }

    @And("Click on the entrance button")
    public void clickTheEntranceButton() {
        mainPage.clickEntranceButton();
    }

    @Then("A new user is registered:{string} appears")
    public void aNewUseIsRegistered(String confirmation) {
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Then("The user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The user failed to log in");
    }

    @Then("The user failed to log in: {string} message appears")
    public void theUserFailedToLogIn(String incorrectCredentials) {
        Assert.assertEquals(mainPage.getIncorrectCredentials(), incorrectCredentials, "The user signed in with an incorrect login");
    }

    @Then("Pops up a warning requiring to define the credentials: {string}")
    public void popsUpAWarningToDefineTheCredentials(String credentialsWarning) {
        Assert.assertEquals(mainPage.getIncorrectCredentials(), credentialsWarning, "The user signed in with no credentials");
    }

    @Then("Check if the entrance form was opened: {string} appears")
    public void checkIfTheRegistrationFormWasOpened(String loginOptions) {
        Assert.assertEquals(mainPage.getLoginOptionMessage(), loginOptions, "Message under login field wasn't found.");
    }
}
