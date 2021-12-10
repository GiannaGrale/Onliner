package pages;

import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

public class AboutCompanyPage extends BasePage {

    private static final String ABOUT_PAGE_URL = "https://blog.onliner.by/about";

    @FindBy(className = "news-header__title")
    private Text requisitesHeaderText;

    public AboutCompanyPage() {
        super();
    }

    @Override
    public AboutCompanyPage openPage() {
        driver.navigate().to(ABOUT_PAGE_URL);
        logger.debug("Navigation to the URL " + ABOUT_PAGE_URL);
        return this;
    }

    @Override
    public AboutCompanyPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(requisitesHeaderText);
        } catch (TimeoutException e) {
            Assert.fail("AboutCompanyPage was not opened");
        }
        return this;
    }

    /***
     * Get "About company" message
     * @return about company page header
     */
    public String getAboutPageTitle() {
        waitForPageOpened();
        return requisitesHeaderText.getText().toLowerCase().trim();
    }
}
