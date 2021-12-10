package elements;

import org.openqa.selenium.WebElement;

/***
 * Wrapper class with Picture functionalities
 */
public class PictureImpl extends ElementImpl implements Picture {

    public PictureImpl(WebElement element) {
        super(element);
    }

    @Override
    public boolean isDisplayed() {
        return getWrappedElement().isDisplayed();
    }
}
