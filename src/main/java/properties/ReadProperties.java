
package properties;

import java.io.*;
import java.util.Properties;

public class ReadProperties {

    private final Properties properties = new Properties();

    public ReadProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Receives the key value from config.properties
     * @param key
     * @return key value
     */
    public String getPropertyValueByKey(String key) {
        if (properties.getProperty(key) != null) {
            return properties.getProperty(key);
        } else {
            throw new RuntimeException();
        }
    }
}
