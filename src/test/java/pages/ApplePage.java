package pages;

import elements.Tag;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;


public class ApplePage extends BasePage {

    @FindBy(className = "schema-tags__text")
    protected Tag tag;

    @FindBy(className = "schema-header__title")
    protected Text header;

    @Override
    public ApplePage openPage() {
        driver.navigate().to(props.getKeyProperty("catalogueURL" + OnlinerEndpoints.appleFilterEndpoint));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public ApplePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(header);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * When the checkbox option is selected, a tag of the manufacturer appears
     */
    public ApplePage displayTag() {
        tag.retryingTagSearch();
        return new ApplePage();
    }

    /***
     * Get the tag text
     * @return tag text
     */
    public String tagText() {
        return tag.getText().toLowerCase().trim();
    }
}
