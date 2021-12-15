package pages;

import elements.Text;
import entities.CatalogueOptions;
import entities.Icons;
import exceptions.ElementNotFoundException;
import exceptions.IncorrectClassRedirectionException;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WaitUtils;

import java.lang.reflect.InvocationTargetException;

public class CataloguePage extends BasePage {

    @FindBy(xpath = "//h1[@class='catalog-navigation__title']")
    private Text catalogueNameText;

    private static final String ICON_OPTION_BUTTON = "//li[@data-id=%s]";
    private static final String LEFT_DROPDOWN_BUTTON = "//div[@data-id=%s]/descendant::div[%s]";
    private static final String MIDDLE_DROPDOWN_BUTTON = "//div[@data-id=%s]/descendant::span[%s]";

    public CataloguePage() {
        super();
    }

    @Override
    @Step("Open a catalogue page")
    public CataloguePage openPage() {
        driver.navigate().to(CATALOGUE_URL);
        logger.debug("Navigation to the URL " + CATALOGUE_URL);
        return this;
    }

    @Override
    public CataloguePage waitForPageOpened() {
        try {
            WaitUtils.waitForVisibility(catalogueNameText);
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
    @Step("Choose a catalogue option")
    public <T extends BasePage> T selectCatalogueDetail(Icons icon, Enum<?> item, CatalogueOptions index, Class<T> clazz) throws IncorrectClassRedirectionException {
        try {
            waitForPageOpened();
            driver.findElement(By.xpath(String.format(ICON_OPTION_BUTTON, icon))).click();
            driver.findElement(By.xpath(String.format(LEFT_DROPDOWN_BUTTON, icon, item))).click();
            driver.findElement(By.xpath(String.format(MIDDLE_DROPDOWN_BUTTON, icon, index.getIndex()))).click();
            return (T) Class.forName(clazz.getName()).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            throw new IncorrectClassRedirectionException("Failed to redirect to another page in selectCatalogueDetail");
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            throw new ElementNotFoundException("Failed to find an element during selectCatalogueDetail implementation");
        }
    }
}
