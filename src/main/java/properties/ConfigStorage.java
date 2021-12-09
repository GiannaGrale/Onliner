package properties;

/***
 * Project URLs
 */
public class ConfigStorage {

    private static final String MAIN_URL = "url";
    private static final String REGISTRATION_URL = "regURl";
    private static final String CATALOGUE_URL = "catalogueURL";
    private static final String CART_URL = "cartURL";
    private static final String FILE_NAME = "config.properties";

    public static String getMainUrl() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, MAIN_URL);
    }

    public static String getRegistrationUrl() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, REGISTRATION_URL);
    }

    public static String getCatalogueUrl() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, CATALOGUE_URL);
    }

    public static String getCartUrl() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, CART_URL);
    }
}
