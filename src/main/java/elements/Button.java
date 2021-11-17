package elements;

@ImplementedBy(ButtonImp.class)
public interface Button extends Element {

     void click();
}
