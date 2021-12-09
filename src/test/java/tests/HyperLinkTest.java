package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HyperLinkTest extends BaseTest {

    @Test(description = "TC-3, Test to check redirection to 'About' page")
    public void aboutPageTest() {
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .goToAboutCompanyLink();
        Assert.assertEquals(aboutCompanyPage.getAboutPageTitle(), "о сайте", "About page wasn't opened");
    }
}
