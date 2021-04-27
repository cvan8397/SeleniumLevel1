package helper.elements;

import helper.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownList extends BaseElement{
    public DropDownList(By locator) {
        super(locator);
    }

    public void selectDropdown(String text) {
        Select dropdown = new Select(findElement());
        dropdown.selectByVisibleText(text);
    }
}
