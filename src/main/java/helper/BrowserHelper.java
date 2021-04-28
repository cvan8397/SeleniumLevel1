package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    private static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

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
            default:
                System.out.println("You're in a big trouble!I'm just kidding.");
                break;
        }

        driver.manage().window().maximize();
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

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("window.scrollBy(0,500)");
    }

    public static void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }

    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //getAlertText()
    public static String getTextAlert(){
        return driver.switchTo().alert().getText();
    }
}
