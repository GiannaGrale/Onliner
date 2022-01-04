package drivers;

public class BrowserConfig {

    /**
     * Get the type of browser to use.
     * @return the type of browser
     */
    public static BrowserType getType() {
        return BrowserType.valueOf(System.getProperty("browser").toUpperCase());
    }
}
