package tests;

import helper.BrowserHelper;
import helper.Constant;
import helper.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        Log.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.valueOf(browser.toUpperCase()));
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterMethod() {
        BrowserHelper.quitBrowser();
    }
}
