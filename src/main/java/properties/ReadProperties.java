package properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.*;

/***
 * Class for reading properties from files
 */
public final class ReadProperties {

    private static final Logger logger = LogManager.getLogger();
    private static ReadProperties instance;
    private final Properties properties = new Properties();
    private Map<String, Properties> propsMap = new HashMap<>();
    private static String FILE_NAME = null;

    public static synchronized ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    private ReadProperties() {
    }

    /***
     * Reads property file
     * @param file property file
     */
    private void readPropertyFile(String file) {
        if (!propsMap.containsKey(file)) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                logger.debug("Cannot read the file");
                throw new UncheckedIOException(e);
            }
            propsMap.put(file, properties);
        }
    }

    /***
     * Receives the key value from property files
     * @param key key from property files
     * @return key value
     */
    public String getKeyProperty(String environment, String key) {
        switch (environment) {
            case "DEV":
                FILE_NAME = "application-dev.properties";
                readPropertyFile(FILE_NAME);
                return propsMap.get(FILE_NAME).getProperty(key);
            case "QA":
                FILE_NAME = "application-qa.properties";
                readPropertyFile(FILE_NAME);
                return propsMap.get(FILE_NAME).getProperty(key);
            case "LOCAL":
                FILE_NAME = "application-local.properties";
                readPropertyFile(FILE_NAME);
                return propsMap.get(FILE_NAME).getProperty(key);
        }
        return environment;
    }
}
