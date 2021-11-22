package elements;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;

public class TagImpl extends ElementImpl implements Tag {

    public TagImpl(WebElement element) {
        super(element);
    }

    @Override
    public boolean retryingTagSearch() {
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                ScrollUtils.scrollUp(getWrappedElement());
                getWrappedElement().isDisplayed();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
}
