package elements;

import org.openqa.selenium.WebElement;

public class TextImpl extends ElementImpl implements Text{

    public TextImpl(WebElement element) {
        super(element);
    }

    public String getText() {
        return getWrappedElement().getText();
    }
}
