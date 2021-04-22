package driver_manager;

import helper.constant.Constant;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createWebDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        Constant.WEBDRIVER = new InternetExplorerDriver(options);
    }
}
