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
            getWrappedElement().isDisplayed();
            return true;
        }
        catch (ElementNotVisibleException e) {
            try {
                WaitUtils.waitForVisibility(getWrappedElement());
                getWrappedElement().isDisplayed();
                return true;
            }
            catch (ElementNotInteractableException ex) {
                ScrollUtils.jsElementClick(getWrappedElement());
                getWrappedElement().isDisplayed();
                return true;
            }
        }
    }
}
