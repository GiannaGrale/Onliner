package util;


import elements.Element;


public class FormatterUtils {

    public static String getFormattedStringLocator(Element btn, Object... index) {
        String locatorToFormat = btn.toString()
                .replace("By.xpath: ", "")
                .replace("Proxy element for: DefaultElementLocator ", "")
                .replace("'", "");
        return String.format(locatorToFormat, index);
    }
}
