package pages;

import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

public class AboutCompanyPage extends BasePage {

    private static final String ABOUT_PAGE_URL = "https://blog.onliner.by/about";

    @FindBy(xpath = "//p[2]/strong")
    protected Text requisitesLabel;

    public AboutCompanyPage() {
        super();
    }

    @Override
    public AboutCompanyPage openPage() {
        driver.navigate().to(ABOUT_PAGE_URL);
        logger.debug("Navigation to the aboutURl...");
        return this;
    }

    @Override
    public AboutCompanyPage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(requisitesLabel);
        } catch (TimeoutException e) {
            Assert.fail("AboutCompanyPage was not opened");
        }
        return this;
    }

    /***
     * Get "About company" message
     * @return about company page header
     */
    public String getAboutPageText() {
        return requisitesLabel.getText().toLowerCase().trim();
    }
}
