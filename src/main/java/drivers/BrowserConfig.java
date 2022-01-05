package drivers;

import java.util.Arrays;

/**
 * Get the type of browser to use.
 */
public class BrowserConfig {

    public static BrowserType getType() {
        String defaultBrowser = System.getProperty("browser");
        String browser = defaultBrowser == null ? System.getProperty("browser") : defaultBrowser;
        return readValue(browser);
    }

    public static BrowserType readValue(String text) {
        return Arrays.stream(BrowserType.values())
                .filter(browser -> browser.name().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown browser value : " + text));
    }
}
