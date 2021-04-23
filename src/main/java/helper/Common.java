package helper;

import org.openqa.selenium.JavascriptExecutor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class Common {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }
    public static String dateBookTicket(){
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(3, 30);
        cal.add(Calendar.DATE, ranNum);
        return new SimpleDateFormat("M/dd/yyyy").format(cal.getTime());
    }
    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,500)");
    }
}
