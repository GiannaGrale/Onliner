package elements;


import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

/***
 * Wrapper class with Picture functionalities
 */
public class PictureImpl extends ElementImpl implements Picture {

    public PictureImpl(WebElement element) {
        super(element);
    }

    @Override
    public boolean isDisplayed() {
        try {
            return getWrappedElement().isDisplayed();
        } catch (ElementNotVisibleException e) {
            try {
                WaitUtils.waitForVisibility(getWrappedElement());
                return getWrappedElement().isDisplayed();
            } catch (ElementNotInteractableException ex) {
                ScrollUtils.jsElementClick(getWrappedElement());
                return getWrappedElement().isDisplayed();
            }
        }
    }
}
