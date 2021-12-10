package elements;

import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Text functionalities
 */
public class TextImpl extends ElementImpl implements Text {

    public TextImpl(WebElement element) {
        super(element);
    }

    public String getText() {
        return getWrappedElement().getText();
    }
}
