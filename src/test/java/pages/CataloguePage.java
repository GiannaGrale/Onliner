package pages;

import elements.Text;
import indices.Icons;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Property;
import util.WaitUtils;


public class CataloguePage extends BasePage {

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    protected Text catalogueName;

    protected static final String iconOptionBtn = "//li[@data-id=%s]";

    protected static final String leftDropdownBtn = "//div[@data-id=%s]/descendant::div[%s]";

    protected static final String middleDropdownBtn = "//div[@data-id=%s]/descendant::span[%s]";

    public CataloguePage() {
        super();
    }

    @Override
    public CataloguePage openPage() {
        driver.navigate().to(props.getKeyProperty(Property.CATALOGUE_URL));
        logger.debug("Navigation to the catalogueURL...");
        return this;
    }

    @Override
    public CataloguePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(catalogueName);
        } catch (TimeoutException e) {
            Assert.fail("CataloguePage was not opened");
        }
        return this;
    }

    /***
     * Choose the icon index and click it
     * @param index the icon index
     */
    public CataloguePage getIconOption(Icons index) {
        waitForPageOpened();
        driver.findElement(By.xpath(String.format(iconOptionBtn, index))).click();
        return this;
    }

    /***
     * Choose the left side dropdown option and click it
     * @param icon catalogue icon
     * @param item item from a dropdown
     *
     */
    public <T extends Enum<T>> CataloguePage getLeftDropdown(Icons icon, T item) {
        driver.findElement(By.xpath(String.format(leftDropdownBtn, icon, item))).click();
        return this;
    }

    /***
     * Choose the middle dropdown option and click it
     * @param <T> redirection to the particular class depending on the chosen dropdown option
     * @param index middle dropdown option index
     */
    @SuppressWarnings("unchecked")
    public <T extends BasePage> T getMiddleDropdown(Class<T> clazz, Pages page, Icons icon, String index) {
        try {
            driver.findElement(By.xpath(String.format(middleDropdownBtn, icon, index))).click();
            return (T) Class.forName(page.getName()).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
