package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

/**
 * Wraps a web element interface with extra functionality. Anything added here will be added to all descendants.
 */
@ImplementedBy(ElementImpl.class)
public interface Element extends WebElement, WrapsElement, Locatable {

    boolean elementWired();
    Element format(Object... replaceString);
}
