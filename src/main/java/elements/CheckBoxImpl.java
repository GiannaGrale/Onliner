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
    public void clickCheckbox() {
        try {
            changeState();
        } catch (ElementNotVisibleException notVisibleException) {
            try {
                WaitUtils.waitForVisibility(getWrappedElement());
                changeState();
            } catch (ElementNotInteractableException ex) {
                ScrollUtils.scrollToElementView(getWrappedElement());
                WaitUtils.waitForVisibility(getWrappedElement());
                changeState();
            }
        }
    }

    @Override
    public boolean isSelected() {
        return this.getWrappedElement().isSelected();
    }

    @Override
    public void changeState() {
        if (!this.isSelected()) this.getWrappedElement().click();
    }
}
