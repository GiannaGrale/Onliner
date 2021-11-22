package pages;

import elements.Checkbox;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.FindElementUtils;
import util.ScrollUtils;
import util.WaitUtils;

public class SmartphonePage extends BasePage {

    protected Checkbox cBoxItem;

    private static final String manufacturer = "//div[6]/descendant::li/.//input[@value='%s']/../span";

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    protected Text phones;

    @Override
    public SmartphonePage openPage() {
        driver.navigate().to(props.getKeyProperty("catalogueURL" + OnlinerEndpoints.mobileEndpoint));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public SmartphonePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(phones);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Scroll to the manufacturer checkbox
     * @param brand a mobile phone brand
     */
    public SmartphonePage goToCheckbox(String brand) {
        String chosenManufacturer = String.format(manufacturer, brand);
        cBoxItem = FindElementUtils.findCheckbox(By.xpath(chosenManufacturer));
        ScrollUtils.scrollToElementView(cBoxItem);
        return this;
    }

    /***
     * Click on the chosen checkbox item
     * @param <T> redirection to a particular class, depends on the clicked checkbox value
     */
    public <T> T chooseManufacturer(Class<T> clazz) {
        try {
            cBoxItem.clickCheckbox();
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
