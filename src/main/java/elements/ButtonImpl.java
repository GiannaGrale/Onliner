package elements;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;


/**
 * Wrapper class with Button functionalities
 */
public class ButtonImpl extends ElementImpl implements Button {

    public By foundBy;
    public By formatLocator;


    public ButtonImpl(WebElement element, By foundBy, String using) {
        super(element);
        this.foundBy = foundBy;
        this.formatLocator = FindByHelper.getLocator(using);
    }

    @Override
    public void click() {
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


    public Button format(Object... args) {
        if (this.formatLocator == null) {
            this.formatLocator = this.foundBy;
        }
        String locator = String.format(this.formatLocator.toString(), args);
        this.foundBy = FindByHelper.getLocator(formatLocator.toString());
        return this;

    }
}
