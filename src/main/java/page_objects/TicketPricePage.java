package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {
    private final Label lblHeaderPage = new Label(By.cssSelector("#content>h1"));
    private final Label lblHeaderTable = new Label(By.cssSelector("//div//table//tbody//tr[@class='TableSmallHeader']"));

    public String getHeaderPage() {
        return this.lblHeaderPage.getText();
    }

    public String getHeaderTable() {
        return this.lblHeaderTable.getText();
    }
}
