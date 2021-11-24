package elements;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;

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
            getWrappedElement().click();
        } catch (ElementNotInteractableException e) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                getWrappedElement().click();
        }
    }
}
