package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SmokeTest extends BaseTest {

    @Test (description = "Test to check the entrance form")
    public void entranceFormTest(){
        MainPage newMainPage = new MainPage();
        newMainPage.openPage();
        newMainPage.enterAccount();
        Assert.assertEquals(newMainPage.getLoginViaNickNameMessage(), "или через ник, e-mail");
    }
}
