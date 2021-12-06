package util;

import com.github.javafaker.Faker;

/***
 * Random generator of strings
 */
public class RandomSymbolUtil {

    static Faker faker = new Faker();

    public static String getRandomLogin() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomQuery() {
        return faker.internet().ipV6Address();
    }

    public static String getNoCredentials() {
        return "";
    }
}
