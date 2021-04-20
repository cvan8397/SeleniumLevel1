package test_cases;

import helper.common.Utilities;
import helper.constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    JavascriptExecutor js;
    ChromeOptions chromeOptions;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\src\\main\\resources\\driver\\chromedriver.exe");
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Constant.WEBDRIVER = new ChromeDriver(chromeOptions);
        Constant.WEBDRIVER.manage().window().maximize();
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
