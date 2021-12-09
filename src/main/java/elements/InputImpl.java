package elements;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

/***
 * Wrapper class with Input functionalities
 */
public class InputImpl extends ElementImpl implements Input {

    public InputImpl(WebElement element) {
        super(element);
    }

    @Override
    public void sendKeys(String text) {
        try {
            getWrappedElement().sendKeys(text);
        } catch (ElementNotInteractableException e) {
            {
                ScrollUtils.scrollToElementView(getWrappedElement());
                WaitUtils.waitForVisibility(getWrappedElement());
                getWrappedElement().sendKeys(text);
            }
        }
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }
}
