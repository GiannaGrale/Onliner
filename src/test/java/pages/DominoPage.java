package pages;


import elements.Input;
import elements.Link;
import elements.Text;
import endpoints.OnlinerEndpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.FindElementUtils;
import util.ScrollUtils;
import util.WaitUtils;

public class DominoPage extends BasePage {

    protected Link domino;

    @FindBy(xpath = "//input[@placeholder='от']")
    protected Input minPrice;

    @FindBy(xpath = "//*[@id='schema-products']/div/nobr")
    protected Text somethingWentWrongMessage;

    @FindBy(className = "schema-header__title")
    protected Text header;


    @Override
    public DominoPage openPage() {
        driver.navigate().to(props.getKeyProperty("catalogueURL" + OnlinerEndpoints.dominosEndpoint));
        logger.debug("Navigation to the url...");
        return this;
    }

    @Override
    public DominoPage isPageOpened() {
        try {
            WaitUtils.waitForVisibility(header);
        } catch (TimeoutException e) {
            logger.debug("Element isn't found...");
            Assert.fail("The page is not opened");
        }
        return this;
    }

    /***
     * Chose a pizza from the list
     * @param pizza pizza item
     */
    public <T> T choosePizza(Class<T> clazz, String pizza) {
        try {
            domino = FindElementUtils.findLink(By.linkText(pizza));
            ScrollUtils.scrollToElementView(domino);
            domino.click();
            return clazz.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.debug("Failed to redirect to another page..");
        return null;
    }

    /***
     * Set the price in the price filter
     * @param number price
     */
    public DominoPage setMinPrice(String number) {
        minPrice.sendKeys(number);
        return this;
    }

    /***
     * Message on absence of goods on the list
     */
    public boolean noGoods() {
        WaitUtils.waitForVisibility(somethingWentWrongMessage);
        return somethingWentWrongMessage.isDisplayed();
    }
}
