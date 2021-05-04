package tests;

import helper.BrowserHelper;
import helper.Constant;
import helper.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setup() {
        Log.info("Pre-condition");
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void closePage() {
        Log.info("Post-condition");
        BrowserHelper.quitBrowser();
    }
}
