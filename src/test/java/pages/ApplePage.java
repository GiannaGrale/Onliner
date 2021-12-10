package pages;

import elements.Tag;
import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

public class ApplePage extends BasePage {

    private static final String APPLE_FILTER_ENDPOINT = "mobile?mfr%5B0%5D=apple";

    @FindBy(className = "schema-tags__text")
    private Tag filterTag;

    @FindBy(className = "schema-header__title")
    private Text headerText;

    public ApplePage() {
        super();
    }

    @Override
    public ApplePage openPage() {
        driver.navigate().to(CATALOGUE_URL + APPLE_FILTER_ENDPOINT);
        logger.debug("Navigation to the URL " + APPLE_FILTER_ENDPOINT);
        return this;
    }

    @Override
    public ApplePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(headerText);
        } catch (TimeoutException e) {
            Assert.fail("ApplePage was not opened");
        }
        return this;
    }

    /***
     * Get the tag text
     * @return tag text
     */
    public String tagText() {
        waitForPageOpened();
        filterTag.findTag();
        return filterTag.getText().toLowerCase().trim();
    }
}
