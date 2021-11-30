package elements;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

public class TagImpl extends ElementImpl implements Tag {

    public TagImpl(WebElement element) {
        super(element);
    }

    @Override
    public boolean retryingTagSearch() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                ScrollUtils.scrollUp(getWrappedElement());
                WaitUtils.waitForVisibility(getWrappedElement());
                return getWrappedElement().isDisplayed();
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return false;
    }
}
