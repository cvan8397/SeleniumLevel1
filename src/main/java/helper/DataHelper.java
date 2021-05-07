package helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public static String getDateFromToday(int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, num);
        return new SimpleDateFormat("M/d/yyyy").format(cal.getTime());
    }
}
