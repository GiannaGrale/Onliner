package elements;


import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
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
    public void clickBtn() {
        try {
            getWrappedElement().click();
        } catch (ElementNotInteractableException ex) {
            try {
                WaitUtils.elementToBeClickable(getWrappedElement());
                ScrollUtils.jsElementClick(getWrappedElement());
                getWrappedElement().click();
            } catch (ElementNotVisibleException e) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                getWrappedElement().click();
            }
        }
    }
}
