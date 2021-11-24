package pages;

import elements.Tag;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.WaitUtils;


public class ApplePage extends BasePage {

    @FindBy(className = "schema-tags__text")
    protected Tag tagSign;

    @FindBy(className = "schema-header__title")
    protected Text headerLabel;

    @Override
    public ApplePage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.valueOf(Type.CATALOGUE_URL + OnlinerEndpoints.appleFilterEndpoint)));
        logger.debug("Navigation to the catalogueURL" + OnlinerEndpoints.appleFilterEndpoint);
        return this;
    }

    @Override
    public ApplePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(headerLabel);
        } catch (TimeoutException e) {
            logger.debug("ApplePage wasn't opened. HeaderLabel wasn't found ");
            Assert.fail("ApplePage was not opened");
        }
        return this;
    }

    /***
     * When the checkbox option is selected, a tag of the manufacturer appears
     */
    public ApplePage displayTag() {
        tagSign.retryingTagSearch();
        return new ApplePage();
    }

    /***
     * Get the tag text
     * @return tag text
     */
    public String tagText() {
        return tagSign.getText().toLowerCase().trim();
    }
}
