package pages;

import elements.Text;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.ScrollUtils;
import util.WaitUtils;


public class SmartphonePage extends BasePage {

    public static final String MOBILE_ENDPOINT = "mobile";

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    protected Text phonesTitle;

    protected static final String manufacturer = "//div[6]//li//input[@value= '%s']/../span";

    public SmartphonePage() {
        super();
    }

    @Override
    public SmartphonePage openPage() {
        driver.navigate().to(props.getKeyProperty(Property.valueOf(Property.CATALOGUE_URL + MOBILE_ENDPOINT)));
        logger.debug("Navigation to the catalogueURL " + MOBILE_ENDPOINT);
        return this;
    }

    @Override
    public SmartphonePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(phonesTitle);
        } catch (TimeoutException e) {
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
        waitForPageOpened();
        WebElement manufacturerCbx = driver.findElement(By.xpath(String.format(manufacturer, brand)));
        ScrollUtils.scrollToElementView(manufacturerCbx);
        manufacturerCbx.click();
        try {
            return (T) Class.forName(page.getName()).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
