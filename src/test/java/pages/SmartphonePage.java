package pages;

import elements.Checkbox;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.FindElementUtils;
import util.ScrollUtils;
import util.WaitUtils;

public class SmartphonePage extends BasePage {

    private static final String manufacturer = "//div[6]//li//input[@value='%s']/../span";

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    protected Text phonesTitle;

    @Override
    public SmartphonePage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.valueOf(Type.CATALOGUE_URL + OnlinerEndpoints.mobileEndpoint)));
        logger.debug("Navigation to the catalogueURL " + OnlinerEndpoints.mobileEndpoint);
        return this;
    }

    @Override
    public SmartphonePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(phonesTitle);
        } catch (TimeoutException e) {
            logger.debug("SmartphonePage wasn't opened. PhonesTitle wasn't found ");
            Assert.fail("SmartphonePage was not opened");
        }
        return this;
    }

    /***
     * Click on the chosen checkbox item
     * @param <T> redirection to a particular class, depends on the clicked checkbox value
     */
    public <T> T chooseManufacturer(Class<T> clazz, String brand) {
        try {
            String chosenManufacturer = String.format(manufacturer, brand);
            Checkbox cBoxItem = FindElementUtils.findCheckbox(By.xpath(chosenManufacturer));
            ScrollUtils.scrollToElementView(cBoxItem);
            cBoxItem.clickCheckbox();
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
