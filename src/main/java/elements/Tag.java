package elements;


@ImplementedBy(TagImpl.class)
public interface Tag extends Element{

    boolean retryingTagSearch();
}
