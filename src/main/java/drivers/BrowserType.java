package drivers;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BrowserType {

    FIREFOX("firefox"),
    CHROME("chrome"),
    EDGE("edge"),
    OPERA("opera");

    String name;
}
