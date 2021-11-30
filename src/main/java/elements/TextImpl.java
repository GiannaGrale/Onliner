package elements;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

/***
 * Wrapper class with Text functionalities
 */
public class TextImpl extends ElementImpl implements Text {

    public TextImpl(WebElement element) {
        super(element);
    }

    public String getText() {
        try {
            return getWrappedElement().getText();
        } catch (ElementNotVisibleException notVisibleException) {
            try {
                WaitUtils.waitForVisibility(getWrappedElement());
                return getWrappedElement().getText();
            } catch (Exception ex) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                WaitUtils.waitForVisibility(getWrappedElement());
                return getWrappedElement().getText();
            }
        }
    }
}
