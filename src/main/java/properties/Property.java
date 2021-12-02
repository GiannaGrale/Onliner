package properties;

public enum Property {

    URL("url"),
    REGISTRATION_URL("regURl"),
    CATALOGUE_URL("catalogueURL"),
    CART_URL("cartURL"),
    PASSWORD("password"),
    LOGIN("login");

    private final String title;

    Property(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
