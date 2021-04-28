package tests;

import helper.BrowserHelper;
import helper.Constant;
import org.testng.annotations.*;


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
