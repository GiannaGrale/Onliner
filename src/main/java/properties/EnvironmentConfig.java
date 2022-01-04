package properties;

/***
 * Project environment data
 */
public class EnvironmentConfig {

    private static final String MAIN_URL = "url";
    private static final String REGISTRATION_URL = "regURl";
    private static final String CATALOGUE_URL = "catalogueURL";
    private static final String CART_URL = "cartURL";
    private static final String PASSWORD = "password";
    private static final String LOGIN = "login";

    private static String FILE_NAME = null;

    private static String environment = System.getProperty("environment");

    public static String setEnvironment(String environment) {
        return FILE_NAME = String.format("application-%s.properties", environment.toLowerCase());
    }

    public static String getMainUrl() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), MAIN_URL);
    }

    public static String getRegistrationUrl() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), REGISTRATION_URL);
    }

    public static String getCatalogueUrl() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), CATALOGUE_URL);
    }

    public static String getCartUrl() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), CART_URL);
    }

    public static String getLogin() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), LOGIN);
    }

    public static String getPassword() {
        return ReadProperties.getInstance().getKeyProperty(setEnvironment(environment), PASSWORD);
    }
}
