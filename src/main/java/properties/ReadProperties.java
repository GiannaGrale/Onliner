
package properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.Properties;


public final class ReadProperties {

    private static final Logger logger = LogManager.getLogger();
    private final Properties properties = new Properties();
    private static ReadProperties instance;

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    private ReadProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.debug("The file cannot be read...");
            e.printStackTrace();
        }
    }

    /***
     * Receives the key value from config.properties
     * @param key key from config.properties
     * @return key value
     */
    public String getKeyProperty(String key) {
        if (properties.getProperty(key) != null) {
            return properties.getProperty(key);
        } else {
            logger.debug("The key value isn't found...");
            throw new RuntimeException();
        }
    }
}
