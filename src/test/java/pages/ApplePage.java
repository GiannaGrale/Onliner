package pages;

import elements.Tag;
import elements.Text;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.WaitUtils;


public class ApplePage extends BasePage {

    public static final String APPLE_FILTER_ENDPOINT = "mobile?mfr%5B0%5D=apple";

    @FindBy(className = "schema-tags__text")
    protected Tag tagSign;

    @FindBy(className = "schema-header__title")
    protected Text headerLabel;

    public ApplePage() {
        super();
    }

    @Override
    public ApplePage openPage() {
        driver.navigate().to(props.getKeyProperty(Property.valueOf(Property.CATALOGUE_URL + APPLE_FILTER_ENDPOINT)));
        logger.debug("Navigation to the catalogueURL" + APPLE_FILTER_ENDPOINT);
        return this;
    }

    @Override
    public ApplePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(headerLabel);
        } catch (TimeoutException e) {
            Assert.fail("ApplePage was not opened");
        }
        return this;
    }

    /***
     * When the checkbox option is selected, a tag of the manufacturer appears
     */
    public ApplePage displayTag() {
        waitForPageOpened();
        tagSign.retryingTagSearch();
        return this;
    }

    /***
     * Get the tag text
     * @return tag text
     */
    public String tagText() {
        return tagSign.getText().toLowerCase().trim();
    }
}
