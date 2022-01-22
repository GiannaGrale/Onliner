package properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.Properties;

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

    private final static Properties properties;

    @Getter
    @AllArgsConstructor
    enum Environment {
        QA("qa"),
        DEV("dev"),
        LOCAL("local");

        String name;

        public static Environment getEnvironment() {
            String environment = System.getProperty("env");
            return Environment.readValue(environment);
        }

        public static Environment readValue(String text) {
            return Arrays.stream(Environment.values())
                    .filter(environment -> environment.getName().equalsIgnoreCase(text))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Unknown environment value : " + text));
        }
    }

    static {
        String environmentPropertiesFile = String.format("application-%s.properties", Environment.getEnvironment().getName());
        properties = ReadProperties.getInstance().readPropertyFile(environmentPropertiesFile);
    }

    public static String getMainUrl() {
        return properties.getProperty(MAIN_URL);
    }

    public static String getRegistrationUrl() {
        return properties.getProperty(REGISTRATION_URL);
    }

    public static String getCatalogueUrl() {
        return properties.getProperty(CATALOGUE_URL);
    }

    public static String getCartUrl() {
        return properties.getProperty(CART_URL);
    }

    public static String getLogin() {
        return properties.getProperty(LOGIN);
    }

    public static String getPassword() {
        return properties.getProperty(PASSWORD);
    }
}
