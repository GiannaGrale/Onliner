package cucumber_tests.steps;

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

    @Then("A new user is registered")
    public void aNewUseIsRegistered() {
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Then("The user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The user failed to log in");
    }

    @Then("The user failed to log in")
    public void theUserFailedToLogIn() {
        Assert.assertEquals(mainPage.getIncorrectCredentials(), "неверный логин или пароль", "The user signed in with an incorrect login");
    }

    @Then("Pops up a warning requiring to define the credentials")
    public void popsUpAWarningToDefineTheCredentials() {
        Assert.assertEquals(mainPage.getIncorrectCredentials(), "укажите ник или e-mail", "The user signed in with no credentials");
    }

    @Then("Check if the entrance form was opened")
    public void checkIfTheRegistrationFormWasOpened() {
        Assert.assertEquals(mainPage.getLoginOptionMessage(), "через социальные сети", "Message under login field wasn't found.");
    }
}
