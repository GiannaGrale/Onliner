package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegistrationPage;
import properties.Property;
import util.RandomSymbolUtil;


public class LoginTest extends BaseTest {

    @Test(description = "Positive test to check if the entrance form opens")
    public void entranceFormTest() {
        MainPage newMainPage = new MainPage()
                .openPage()
                .openEntranceForm();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail", "Message under login field wasn't found.");
    }

    @Test(description = "Positive test for registration of a new user", enabled = false)
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

    @Test(description = "Positive test for login with correct credentials")
    public void logInTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty(Property.LOGIN))
                .insertPassword(props.getKeyProperty(Property.PASSWORD))
                .clickEntranceButton();
        Assert.assertTrue(mainPage.isAvatarDisplayed(), " The avatar cannot be displayed");
    }

    @Test(description = "Negative test to check system behavior using the correct password and incorrect login")
    public void setIncorrectLoginTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(RandomSymbolUtil.getRandomLogin())
                .insertPassword(props.getKeyProperty(Property.PASSWORD))
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The login is correct!");
    }

    @Test(description = "Negative test to check system behavior using the correct login and incorrect password")
    public void setIncorrectPasswordTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(props.getKeyProperty(Property.LOGIN))
                .insertPassword(RandomSymbolUtil.getRandomPassword())
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getLoginWarningMessage(), "неверный логин или пароль", "The password is correct!");
    }

    @Test(description = "Negative test to check system behavior using no credentials")
    public void setNoCredentialsTest() {
        MainPage mainPage = new MainPage()
                .openPage()
                .openEntranceForm()
                .insertLogin(RandomSymbolUtil.getNoCredentials())
                .insertPassword(RandomSymbolUtil.getNoCredentials())
                .clickEntranceButton();
        Assert.assertEquals(mainPage.getPasswordInputWarning(), "укажите пароль", "You've logged in with these credentials");
    }
}
