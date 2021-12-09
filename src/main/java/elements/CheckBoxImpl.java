package elements;

import org.openqa.selenium.WebElement;
import util.WaitUtils;

/***
 * Wrapper class with Checkbox functionalities
 */
public class CheckBoxImpl extends ElementImpl implements Checkbox {

    public CheckBoxImpl(WebElement element) {
        super(element);
    }

    public void clickCheckbox(boolean isChecked) {
        if (isChecked != isSelected()) {
            WaitUtils.waitForVisibility(getWrappedElement());
            this.getWrappedElement().click();
        }
    }

    public boolean isSelected() {
        return getWrappedElement().isSelected();
    }
}
