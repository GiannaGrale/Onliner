package elements;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;

/**
 * Wrapper class with Button functionalities
 */
public class ButtonImpl extends ElementImpl implements Button {

    public ButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        try {
            getWrappedElement().click();
        } catch (ElementNotInteractableException ex) {
            ScrollUtils.scrollToElementView(getWrappedElement());
            getWrappedElement().click();
        }
    }
}

