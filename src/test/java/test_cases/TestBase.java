package test_cases;

import driver_manager.DriverManager;
import driver_manager.DriverManagerFactory;
import driver_manager.DriverType;
import helper.constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    JavascriptExecutor js;


    @BeforeSuite
    public void beforeMethod() {
        DriverManager driverManager;
        System.out.println("Pre-condition");
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        Constant.WEBDRIVER = driverManager.getWebDriver();
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterSuite
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
