package helper;

import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import com.github.javafaker.Faker;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static String dateBookTicket() {
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(3, 30);
        cal.add(Calendar.DATE, ranNum);
        return new SimpleDateFormat("M/dd/yyyy").format(cal.getTime());
    }

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static File readFile(String PATH) {
        File file = new File(PATH);
        if (file.exists()) {
            return file;
        }
        return null;
    }

}
