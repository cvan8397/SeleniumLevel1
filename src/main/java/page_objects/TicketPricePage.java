package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {
    private final Label lblPageHeader = new Label(By.cssSelector("#content>h1"));
    private final Label lblTableHeader = new Label(By.xpath("//div//table//tbody//tr[@class='TableSmallHeader']//th"));

    public String getPageHeader() {
        return this.lblPageHeader.getText();
    }

    public String getTableHeader() {
        return this.lblTableHeader.getText();
    }
}
