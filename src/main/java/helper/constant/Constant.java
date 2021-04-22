package helper.constant;

import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Constant {
    //public static Calendar cal = Calendar.getInstance();
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railwayqa.somee.com/Page/HomePage.cshtml";

    //login
    public static final String USERNAME = "caivan.8397@gmail.com";
    public static final String PASSWORD = "123123123";

    //register
    public static final String EMAIL = "van0123456789ab@gmail.com";
    public static final String PASSWORD1 = "123123123";
    public static final String CONFIRM = "123123123";
    public static final String PID = "123456789";

    //book ticket
    public static final String DEPART_FROM = "Sài Gòn";
    public static final String ARRIVE_AT = "Đà Nẵng";
    public static final String SEAT_TYPE = "Soft bed";
    public static final String TICKET_AMOUNT = "2";
}
