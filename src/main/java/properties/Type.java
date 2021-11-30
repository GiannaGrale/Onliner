package properties;

public enum Type {
    URL("url"),
    REGISTRATION_URL("regURl"),
    CATALOGUE_URL("catalogueURL"),
    CART_URL("cartURL"),
    ABOUT_PAGE_URL("aboutURl"),
    PASSWORD("password"),
    LOGIN("login");

    private final String title;

    Type(String title) {
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