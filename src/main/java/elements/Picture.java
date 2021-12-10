package elements;

@ImplementedBy(PictureImpl.class)
public interface Picture extends Element{

    boolean isDisplayed();
}
