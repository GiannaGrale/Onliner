package util;

import com.github.javafaker.Faker;

/***
 * Random generator of strings
 */
public class RandomSymbolUtil {

    private static final Faker faker = new Faker();

    /***
     * Generates random string
     * @return random login string
     */
    public static String getRandomLogin() {
        return faker.internet().emailAddress();
    }

    /***
     * Generates random password
     * @return random password string
     */
    public static String getRandomPassword() {
        return faker.internet().password();
    }

    /***
     * Generates random query
     * @return random query string
     */
    public static String getRandomQuery() {
        return faker.internet().ipV6Address();
    }
}
