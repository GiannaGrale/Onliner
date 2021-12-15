package tests;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

@Feature("Hyperlink")
public class RedirectionPageTest extends BaseTest {

    @Test(description = "TC-3, Test to check redirection to 'About' page")
    public void aboutPageTest() {
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .goToAboutCompanyLink();
        Assert.assertEquals(aboutCompanyPage.getAboutPageTitle(), "о сайте", "About page wasn't opened");
    }
}
