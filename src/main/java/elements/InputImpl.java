package elements;

import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Input functionalities
 */
public class InputImpl extends ElementImpl implements Input {

    public InputImpl(WebElement element) {
        super(element);
    }

    @Override
    public void sendKeys(String text) {
        getWrappedElement().sendKeys(text);
    }

    @Override
    public void clear() {
        getWrappedElement().clear();
    }
}
