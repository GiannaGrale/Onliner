package elements;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;

/***
 * Wrapper class with Picture functionalities
 */
public class PictureImpl extends ElementImpl implements Picture {

    public PictureImpl(WebElement element) {
        super(element);
    }

    @Override
    public boolean isDisplayed() {
        try {
            return getWrappedElement().isDisplayed();
        } catch (ElementNotInteractableException e) {{
                ScrollUtils.jsElementClick(getWrappedElement());
                return getWrappedElement().isDisplayed();
            }
        }
    }
}
