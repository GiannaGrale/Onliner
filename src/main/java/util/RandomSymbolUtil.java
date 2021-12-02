package util;

import com.github.javafaker.Faker;

public class RandomSymbolUtil {

    static Faker faker = new Faker();

    public static String fakeLogin = faker.internet().emailAddress();
    public static String fakePassword = faker.internet().password();
    public static String fakeQuery = faker.internet().ipV6Address();
    public static String noCredentials = "";
}
