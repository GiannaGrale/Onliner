package elements;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

/***
 * Wrapper class with Link functionalities
 */
public class LinkImpl extends ElementImpl implements Link {

    public LinkImpl(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        try {
            WaitUtils.elementToBeClickable(getWrappedElement());
            getWrappedElement().click();
        } catch (ElementNotInteractableException ex) {
            ScrollUtils.scrollToElementView(getWrappedElement());
            getWrappedElement().click();
        }
    }
}
