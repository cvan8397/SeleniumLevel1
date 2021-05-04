package elements;

import helper.BrowserHelper;
import helper.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return BrowserHelper.getWebDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return BrowserHelper.getWebDriver().findElements(locator);
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getWebDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (Exception e) {
            Log.info("Element is not displayed");
            return false;
        }
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }
}
