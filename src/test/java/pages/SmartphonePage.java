package pages;

import elements.Checkbox;
import elements.Text;
import endpoints.OnlinerEndpoints;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.FindElementUtils;
import util.FormatterUtils;
import util.ScrollUtils;
import util.WaitUtils;

public class SmartphonePage extends BasePage {

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    protected Text phonesTitle;

    @FindBy(xpath = "//div[6]//li//input[@value= '%s']/../span")
    protected Checkbox manufacturerCbx;

    public SmartphonePage() {
        super();
    }

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
    @SuppressWarnings("unchecked")
    public <T extends BasePage> T chooseManufacturer(Class<T> clazz, Pages page, String brand) {
        String chosenManufacturer = FormatterUtils.getFormattedStringLocator(manufacturerCbx, brand);
        manufacturerCbx = FindElementUtils.findCheckbox(By.xpath(chosenManufacturer));
        ScrollUtils.scrollToElementView(manufacturerCbx);
        manufacturerCbx.clickCheckbox();
        try {
            clazz = (Class<T>) Class.forName(page.getName());
            return clazz.newInstance();

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
