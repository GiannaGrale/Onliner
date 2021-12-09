package entities;

/***
 * Indices of catalogue options
 */
public enum CatalogueOptions {

    SMARTPHONES("1"),
    DOMINO("1");

    private final String index;

    CatalogueOptions(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
