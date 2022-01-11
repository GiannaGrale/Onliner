package configuration;

import drivers.BrowserType;
import java.util.Arrays;

/**
 * Get the type of browser to use.
 */
public class BrowserConfig {

    public static BrowserType getType() {
         String browser = System.getProperty("browser");
         return readValue(browser);
    }

    public static BrowserType readValue(String text) {
        return Arrays.stream(BrowserType.values())
                .filter(browser -> browser.getName().equalsIgnoreCase(text))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unknown browser value : " + text));
    }
}
