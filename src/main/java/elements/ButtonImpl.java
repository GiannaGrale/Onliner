package elements;

import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

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
        }
        catch (Exception ex) {
            try {
                WaitUtils.elementToBeClickable(getWrappedElement());
                ScrollUtils.jsElementClick(getWrappedElement());
                getWrappedElement().click();
            }
            catch (Exception e) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                getWrappedElement().click();
            }
        }
    }
}
