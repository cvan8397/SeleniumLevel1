package helper;

import org.openqa.selenium.WebDriver;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railway.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "caivan.8397@gmail.com";
    public static final String PASSWORD = "123123123";
    public static final long DEFAULT_TIME_WAIT = 10;

    /*** Book ticket ***/
    public static final String DEPART_FROM = "Quảng Ngãi";
    public static final String ARRIVE_AT = "Đà Nẵng";
    public static final String SEAT_TYPE = "Soft bed with air conditioner";
    public static final String TICKET_AMOUNT = "1";
}
