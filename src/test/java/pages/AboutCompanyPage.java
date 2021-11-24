package pages;

import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.WaitUtils;

public class AboutCompanyPage extends BasePage {

    @FindBy(xpath = "//p[2]/strong")
    protected Text requisitesLabel;

    @Override
    public AboutCompanyPage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.ABOUT_PAGE_URL));
        logger.debug("Navigation to the aboutURl...");
        return this;
    }

    @Override
    public AboutCompanyPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(requisitesLabel);
        } catch (TimeoutException e) {
            logger.debug("AboutCompanyPage wasn't opened. RequisitesLabel wasn't found ");
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
