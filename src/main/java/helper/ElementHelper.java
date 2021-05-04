package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementHelper {
    public static void waitElementExist(By locator, int seconds, String place) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getWebDriver(), seconds);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, place));
    }

    public static void notStalenessOf(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getWebDriver(), seconds);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
    }
}
