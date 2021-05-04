package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE, OPERA}

    public static void startBrowser(DriverType type) {
        switch (type) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            default:
                System.out.println("..........");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Constant.DEFAULT_TIME_WAIT, TimeUnit.SECONDS);
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void navigateToUrl(String url) {
        getWebDriver().get(url);
    }

    public static void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    public static void cancelAlert() {
        driver.switchTo().alert().dismiss();
    }

    public static void acceptAlert() {
        getWebDriver().switchTo().alert().accept();
    }

    public static String getAlertText() {
        return driver.switchTo().alert().getText();
    }
}
