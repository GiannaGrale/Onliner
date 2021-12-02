package elements;


import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;


/***
 * Wrapper class with Checkbox functionalities
 */
public class CheckBoxImpl extends ElementImpl implements Checkbox {

    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void clickCheckbox(boolean isChecked) {
        isChecked = this.getWrappedElement().isSelected();
        try {
            if (!isChecked)
                this.getWrappedElement().click();
        } catch (ElementNotVisibleException notVisibleException) {
            try {
                WaitUtils.waitForVisibility(getWrappedElement());
                this.getWrappedElement().click();
            } catch (ElementNotInteractableException ex) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                WaitUtils.waitForVisibility(getWrappedElement());
                this.getWrappedElement().click();
            }
        }
    }
}
