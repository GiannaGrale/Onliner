package elements;

import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import util.WaitUtils;

public class TagImpl extends ElementImpl implements Tag {

    public TagImpl(WebElement element) {
        super(element);
    }

    @Override
    public void findTag() {
        ScrollUtils.scrollToElementView(getWrappedElement());
        WaitUtils.waitForElementToBeDisplayed(getWrappedElement());
    }
}
