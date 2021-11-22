package pages;

import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

public class AboutCompanyPage extends BasePage {

    @FindBy(xpath = "//p[2]/strong")
    protected Text requisites;

    @Override
    public AboutCompanyPage openPage() {
        driver.navigate().to(props.getKeyProperty("aboutURl"));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public AboutCompanyPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(requisites);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Get "About company" message
     * @return about company page header
     */
    public String getAboutPageText() {
        return requisites.getText().toLowerCase().trim();
    }
}
