package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private static ReadProperties instance;
    protected static Properties properties;

    private ReadProperties() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getURL() {
        return properties.getProperty("url");
    }
}
