package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class HyperLinkTest extends BaseTest {

    @Test(description = "Positive test to check redirection to 'About' page")
    public void aboutPageTest() {
        AboutCompanyPage aboutCompanyPage = new MainPage()
                .openPage()
                .goToAboutCompanyLink();
        Assert.assertEquals(aboutCompanyPage.getAboutPageText(), "реквизиты и юридический адрес:", "About page wasn't opened");
    }
}
