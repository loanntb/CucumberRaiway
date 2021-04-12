package utilities.helpers;

import com.github.javafaker.Faker;


public class DataHelper {
    private static Faker faker = new Faker();

    /***
     * random valid email
     *
     * @return
     */
    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    /***
     * random number
     * @return
     */
    public static String randomDigit() {
        return faker.number().digits(8);
    }

    /***
     * Random password
     * @param minimumLength
     * @param maximumLength
     * @return
     */
    public static String randomPassword(int minimumLength, int maximumLength) {
        return faker.lorem().characters(minimumLength, maximumLength);
    }

    public static int randomNumber() {
        return faker.number().numberBetween(2, 5);
    }
}
