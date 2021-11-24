package elements;


@ImplementedBy(ButtonImpl.class)
public interface Button extends Element {

     void click();
     Button format(Object... args);
}
