package pages;

import elements.Button;
import elements.Text;
import indices.Icons;
import indices.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import properties.Type;
import util.FindElementUtils;
import util.WaitUtils;


public class CataloguePage extends BasePage {

    private static final String iconOptionLocator = "//li[@data-id=%s]";
    private static final String leftDropdownLocator = "//div[@data-id=%s]/descendant::div[%s]";
    private static final String middleDropdownLocator = "//div[@data-id=%s]/descendant::span[%s]";

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    protected Text catalogueName;

    @FindBy(how = How.XPATH, using = "//li[@data-id=${%s}]")
    protected Button button;



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
/*
    public CataloguePage getIconOption(Icons index) {
        button.format(index).click();
        return this;
    }*/

    /***
     * Choose the icon index and click it
     * @param index the icon index
     */
    public CataloguePage getIconOption(Icons index) {
        String iconLocator = String.format(iconOptionLocator, index);
        FindElementUtils.findElement(By.xpath(iconLocator)).click();
        return this;
    }

    /***
     * Choose the left side dropdown option and click it
     * @param icon catalogue icon
     * @param item item from a dropdown
     *
     */
    public <T extends Enum<T>> CataloguePage getLeftDropdown(Icons icon, T item) {
        String leftDropdownLocator = String.format(CataloguePage.leftDropdownLocator, icon, item);
        System.out.println(leftDropdownLocator);
        FindElementUtils.findElement(By.xpath(leftDropdownLocator)).click();
        return this;
    }

    /***
     * Choose the middle dropdown option and click it
     * @param <T> redirection to the particular class depending on the chosen dropdown option
     * @param index middle dropdown option index
     */
    public <T> T getMiddleDropdown(Class<T> clazz, Icons icon, String index) {
        String middleDropdownLocator = String.format(CataloguePage.middleDropdownLocator, icon, index);
        FindElementUtils.findElement(By.xpath(middleDropdownLocator)).click();
        logger.debug("Failed to redirect to another page..");
        try {
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }
}