package elements;

import org.openqa.selenium.WebElement;

/**
 * Wrapper class with Button functionalities
 */
public class ButtonImpl extends ElementImpl implements Button {

    public ButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        getWrappedElement().click();
    }
}
