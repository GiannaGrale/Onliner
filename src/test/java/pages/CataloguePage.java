package pages;

import elements.Button;
import elements.Text;
import indices.Icons;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.Type;
import util.FindElementUtils;
import util.FormatterUtils;
import util.WaitUtils;


public class CataloguePage extends BasePage {

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    protected Text catalogueName;

    @FindBy(xpath = "//li[@data-id=%s]")
    protected Button iconOptionBtn;

    @FindBy(xpath = "//div[@data-id=%s]/descendant::div[%s]")
    protected Button leftDropdownBtn;

    @FindBy(xpath = "//div[@data-id=%s]/descendant::span[%s]")
    protected Button middleDropdownBtn;

    public CataloguePage() {
        super();
    }

    @Override
    public CataloguePage openPage() {
        driver.navigate().to(props.getKeyProperty(Type.CATALOGUE_URL));
        logger.debug("Navigation to the catalogueURL...");
        return this;
    }

    @Override
    public CataloguePage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(catalogueName);
        } catch (TimeoutException e) {
            logger.debug("CataloguePage wasn't opened. CatalogueName wasn't found ");
            Assert.fail("CataloguePage was not opened");
        }
        return this;
    }

    /***
     * Choose the icon index and click it
     * @param index the icon index
     */

    public CataloguePage getIconOption(Icons index) {
        String formattedLocator = FormatterUtils.getFormattedStringLocator(iconOptionBtn, index);
        FindElementUtils.findButton(By.xpath(formattedLocator)).clickBtn();
        return this;
    }

    /***
     * Choose the left side dropdown option and click it
     * @param icon catalogue icon
     * @param item item from a dropdown
     *
     */
    public <T extends Enum<T>> CataloguePage getLeftDropdown(Icons icon, T item) {
        String leftDropdownLocator = FormatterUtils.getFormattedStringLocator(leftDropdownBtn, icon, item);
        FindElementUtils.findButton(By.xpath(leftDropdownLocator)).clickBtn();
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
            String middleDropdownLocator = FormatterUtils.getFormattedStringLocator(middleDropdownBtn, icon, index);
            FindElementUtils.findButton(By.xpath(middleDropdownLocator)).clickBtn();
            clazz = (Class<T>) Class.forName(page.getName());
            return clazz.newInstance();

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        logger.debug("Failed to redirect to another page..");
        return null;
    }
}
