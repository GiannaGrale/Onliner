package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

public class SmokeTest extends BaseTest {

    @Test
    public void entranceFormTest(){
        MainPage newMainPage = new MainPage();
        newMainPage.openPage();
        newMainPage.enterAccount();
        Assert.assertEquals(new MainPage().getLoginViaNickNameMessage(), "или через ник, e-mail");
    }
}
