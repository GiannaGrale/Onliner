package pages;

import elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.FindElementUtils;
import util.WaitUtils;


public class CataloguePage extends BasePage {

    private static final String iconOptions = "//li[@data-id=%d]";
    private static final String leftDropdown = "//div[@data-id=%d]/descendant::div[4]";
    private static final String middleDropdown = "//div[@data-id=%d]/descendant::span[1]";

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    protected Text catalogueName;

    @Override
    public CataloguePage openPage() {
        driver.navigate().to(props.getKeyProperty("catalogueURL"));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public CataloguePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(catalogueName);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Choose the icon index and click it
     * @param index the icon index
     */
    public CataloguePage getIconOption(int index) {
        String iconLocator = String.format(iconOptions, index);
        FindElementUtils.findElement(By.xpath(iconLocator)).click();
        return this;
    }

    /***
     * Choose the left side dropdown option and click it
     * @param index the lef side dropdown index
     */
    public CataloguePage getLeftSideDropdownItem(int index) {
        String leftDropdownLocator = String.format(leftDropdown, index);
        FindElementUtils.findElement(By.xpath(leftDropdownLocator)).click();
        return this;
    }

    /***
     * Choose the middle dropdown option and click it
     * @param index middle dropdown option index
     * @param <T> redirection to the particular class depending on the chosen dropdown option
     */
    public <T> T getMiddleDropdownItem(Class<T> clazz, int index) {
        String middleDropdownLocator = String.format(middleDropdown, index);
        FindElementUtils.findElement(By.xpath(middleDropdownLocator)).click();
        try {
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
