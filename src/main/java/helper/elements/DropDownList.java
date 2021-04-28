package helper.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends BaseElement{
    public DropDownList(By locator) {
        super(locator);
    }

    public void selectDropdown(String text) {
        Select dropdown = new Select(findElement());
        dropdown.selectByVisibleText(text);
    }

    public void selectDropdownByValue(String value) {
        Select dropdown = new Select(findElement());
        dropdown.selectByValue(value);
    }
}
