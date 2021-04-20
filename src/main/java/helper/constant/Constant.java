package helper.constant;

import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;

public class Constant {
    public static Calendar cal = Calendar.getInstance();
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railwayqa.somee.com/Page/HomePage.cshtml";

    //login
    public static final String USERNAME = "thanhle@logigear.com";
    public static final String PASSWORD = "12345678";

    //register
    public static final String EMAIL = "van0123456789ab@gmail.com";
    public static final String PASSWORD1 = "123123123";
    public static final String CONFIRM = "123123123";
    public static final String PID = "123456789";

    //book ticket
    public static final Date DEPART_DATE = cal.getTime();
    //public static final Date DEPART_FROM =  cal.add(Calendar.MONTH, 1);
}
