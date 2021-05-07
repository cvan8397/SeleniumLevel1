package page_objects;

import elements.Button;
import org.openqa.selenium.By;

public class TimetablePage extends GeneralPage {
    private final Button btnCheckPrice = new Button(By.xpath("//tr//td[.='Đà Nẵng']//following-sibling::td[.='Sài Gòn']//following-sibling::td[.='check price']/a"));

    public void getInformationPrice() {
        this.btnCheckPrice.scrollToView();
        this.btnCheckPrice.click();
    }
}
