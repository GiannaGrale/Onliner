package pages;

import elements.Text;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.ScrollUtils;
import util.WaitUtils;

public class SmartphonePage extends BasePage {

    private static final String MOBILE_ENDPOINT = "mobile";

    @FindBy(xpath = "//h1[@class='schema-header__title']")
    private Text phonesTitleText;

    private static final String manufacturer = "//div[6]//li//input[@value= '%s']/../span";

    public SmartphonePage() {
        super();
    }

    @Override
    @Step("Open a smartphone page")
    public SmartphonePage openPage() {
        driver.navigate().to(CATALOGUE_URL + MOBILE_ENDPOINT);
        logger.debug("Navigation to the URL " + MOBILE_ENDPOINT);
        return this;
    }

    @Override
    public SmartphonePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(phonesTitleText);
        } catch (TimeoutException e) {
            Assert.fail("SmartphonePage was not opened");
        }
        return this;
    }

    /***
     * Click on the chosen checkbox item
     */
    @Step("Choose the brand: {brand}")
    public ApplePage chooseBrand(String brand){
        WebElement manufacturerCbx = driver.findElement(By.xpath(String.format(manufacturer, brand)));
        ScrollUtils.scrollToElementView(manufacturerCbx);
        manufacturerCbx.click();
        return new ApplePage();
    }
}
