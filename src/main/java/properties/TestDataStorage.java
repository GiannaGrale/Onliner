package properties;

/***
 * Authorization data
 */
public class TestDataStorage {

    private static final String PASSWORD = "password";
    private static final String LOGIN = "login";

    private static final String FILE_NAME = "testData.properties";

    public static String getLogin() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, LOGIN);
    }

    public static String getPassword() {
        return ReadProperties.getInstance().getKeyProperty(FILE_NAME, PASSWORD);
    }
}
