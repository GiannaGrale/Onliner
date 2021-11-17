package elements;

@ImplementedBy(TextImpl.class)
public interface Text extends Element {

     String getText();
}
