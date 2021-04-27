package tests.test_case;

import helper.BrowserHelper;
import helper.Constant;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class TestBase {
    @BeforeMethod
    public void beforeMethod() {
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        Constant.WEBDRIVER = BrowserHelper.getWebDriver();
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void closePage() {
        BrowserHelper.quitBrowser();
    }
}
