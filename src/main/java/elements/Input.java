package elements;

@ImplementedBy(InputImpl.class)
public interface Input extends Element {

    void sendKeys(String text);
    void clear();
}
