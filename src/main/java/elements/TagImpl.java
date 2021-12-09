package elements;

import org.awaitility.Awaitility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import util.ScrollUtils;
import java.util.concurrent.TimeUnit;

public class TagImpl extends ElementImpl implements Tag {

    public TagImpl(WebElement element) {
        super(element);
    }

    @Override
    public void findTag() {
        ScrollUtils.scrollUp(getWrappedElement());
        try {
            Awaitility.waitAtMost(5, TimeUnit.SECONDS)
                    .pollInterval(1, TimeUnit.SECONDS)
                    .until(() -> getWrappedElement().isDisplayed());
        } catch (StaleElementReferenceException e) {
        }
    }
}
