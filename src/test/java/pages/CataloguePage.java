package pages;

import elements.Text;
import entities.CatalogueOptions;
import entities.Icons;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import properties.ConfigStorage;
import util.WaitUtils;
import java.lang.reflect.InvocationTargetException;

public class CataloguePage extends BasePage {

    private final String CATALOGUE_URL = ConfigStorage.getCatalogueUrl();

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    private Text catalogueName;

    private static final String ICON_OPTION_BUTTON = "//li[@data-id=%s]";
    private static final String LEFT_DROPDOWN_BUTTON = "//div[@data-id=%s]/descendant::div[%s]";
    private static final String MIDDLE_DROPDOWN_BUTTON = "//div[@data-id=%s]/descendant::span[%s]";

    public CataloguePage() {
        super();
    }

    @Override
    public CataloguePage openPage() {
        driver.navigate().to(CATALOGUE_URL);
        logger.debug("Navigation to the URL " + CATALOGUE_URL);
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
     * Choose the middle dropdown option and click it
     * @param <T> redirection to the particular class depending on the chosen dropdown option
     * @param index middle dropdown option index
     */

    @SuppressWarnings("unchecked")
    public <T extends BasePage> T selectCatalogueDetail(Class<T> clazz, Icons icon, Enum<?> item, CatalogueOptions index) {
        waitForPageOpened();
        try {
            driver.findElement(By.xpath(String.format(ICON_OPTION_BUTTON, icon))).click();
            driver.findElement(By.xpath(String.format(LEFT_DROPDOWN_BUTTON, icon, item))).click();
            driver.findElement(By.xpath(String.format(MIDDLE_DROPDOWN_BUTTON, icon, index.getIndex()))).click();
            return (T) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return (T) this;
    }
}
