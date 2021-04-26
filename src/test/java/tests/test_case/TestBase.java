package tests.test_case;

import helper.driver_manager.DriverManagerFactory;
import helper.Constant;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    @BeforeSuite
    public void beforeMethod() {
        System.out.println("Pre-condition");

        Constant.WEBDRIVER = DriverManagerFactory.getDriverManager(DriverManagerFactory.DriverType.CHROME).getWebDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
    }

    @AfterSuite
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
