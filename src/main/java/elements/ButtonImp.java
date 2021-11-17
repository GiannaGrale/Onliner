package elements;


import org.openqa.selenium.WebElement;

/**
 * Wrapper class with Button functionalities
 */
public class ButtonImp extends ElementImpl implements Button {

    public ButtonImp(WebElement element) {
        super(element);
    }

    public void click() {
        getWrappedElement().click();
    }
}
