package helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    static Faker faker = new Faker();
    public static String getRandomEmail() {
        return faker.bothify("Van########@gmail.com");
    }

    public static String getRandomPassword() {
        return faker.letterify("?????????");
    }

    public static String getRandomPID() {
        return faker.numerify("##########");
    }

    public static String getDepartDateRandom() {
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(3, 30);
        cal.add(Calendar.DATE, ranNum);
        return new SimpleDateFormat("M/dd/yyyy").format(cal.getTime());
    }

}
