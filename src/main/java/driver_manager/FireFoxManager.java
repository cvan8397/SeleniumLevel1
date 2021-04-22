package driver_manager;

import helper.constant.Constant;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        Constant.WEBDRIVER = new FirefoxDriver(options);
    }
}
