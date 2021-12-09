package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import util.RandomSymbolUtil;

public class LoginTest extends BaseTest {

    @Test(description = "Test to check if the entrance form opens")
    public void entranceFormTest() {
        MainPage newMainPage = new MainPage()
                .openPage()
                .openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginOptionMessage(), "через социальные сети", "Message under login field wasn't found.");
    }

    @Test(description = "TC-2, Test for registration of a new user", enabled = false)
    public void registrationTest() {
        RegistrationPage registrationPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .goToRegistrationLink()
                .setLogin(RandomSymbolUtil.getRandomLogin())
                .setPassword(RandomSymbolUtil.getRandomPassword())
                .setRepeatPassword(RandomSymbolUtil.getRandomPassword())
                .acceptPrivacyPolicy()
                .clickRegistrationButton();
        Assert.assertEquals(registrationPage.emailConfirmationMessage(), "Подтвердите ваш e-mail", "Fail to sign up.");
    }

    @Test(description = "TC-3, Test for login with correct credentials")
    public void logInTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(LOGIN)
                .insertPassword(PSW)
                .clickEntranceButton();
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The avatar cannot be displayed");
    }

    @Test(description = "TC-6, Test to check system behavior using the correct password and incorrect login")
    public void setIncorrectLoginTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(RandomSymbolUtil.getRandomLogin())
                .insertPassword(LOGIN)
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getIncorrectCredentials(), "неверный логин или пароль", "The login is correct!");
    }

    @Test(description = "TC-8, Test to check system behavior using the correct login and incorrect password")
    public void setIncorrectPasswordTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(PSW)
                .insertPassword(RandomSymbolUtil.getRandomPassword())
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getIncorrectCredentials(), "неверный логин или пароль", "The password is correct!");
    }

    @Test(description = "TC-7, Test to check system behavior using no credentials")
    public void setNoCredentialsTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin("")
                .insertPassword("")
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getIncorrectCredentials(), "укажите ник или e-mail", "You've logged in with these credentials");
    }
}
