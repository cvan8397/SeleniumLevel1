package helper.elements;

import helper.BrowserHelper;
import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.Option;
import java.util.List;

public class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return Constant.WEBDRIVER.findElement(locator);
    }

    public List<WebElement> findElements() {
        return Constant.WEBDRIVER.findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

}
