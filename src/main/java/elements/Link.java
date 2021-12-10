package elements;

@ImplementedBy(LinkImpl.class)
public interface Link extends Element {

    @Override
    void click();
}
