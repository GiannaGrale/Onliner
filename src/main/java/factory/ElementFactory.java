package factory;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

/**
 * Element factory for wrapped elements. Similar to {@link PageFactory}
 */
public class ElementFactory {
    /**
     * As
     * {@link ElementFactory #initElements(WebDriver, Class)}
     * but will only replace the fields of an already instantiated Page Object.
     *
     * @param searchContext A search context that will be used to look up the elements
     * @param page The object with WebElement and List<WebElement> fields that should be proxied.
     * @return the initialized page-object.
     */
    public static <T> T initElements(SearchContext searchContext, T page) {
        initElements(new ElementDecorator(new DefaultElementLocatorFactory(searchContext)), page);
        return page;
    }

    /**
     * see {@link PageFactory#initElements(ElementLocatorFactory, Object)}
     */
    public static void initElements(FieldDecorator decorator, Object page) {
        PageFactory.initElements(decorator, page);
    }
}
