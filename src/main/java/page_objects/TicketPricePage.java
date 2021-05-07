package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class TicketPricePage extends GeneralPage {
    private final Label lblPageHeader = new Label(By.cssSelector("#content>h1"));
    private final Label lblTableHeader = new Label(By.xpath("//div//table//tbody//tr[@class='TableSmallHeader']//th"));
    private final String dynamicTableCell = "//td[text()= '%1$s']//parent::tr//following-sibling::tr/td[position() = count(//td[. = '%1$s']/preceding-sibling::td)+1]";

    public String getPageHeader() {
        return this.lblPageHeader.getText();
    }

    public String getTableHeader() {
        return this.lblTableHeader.getText();
    }

    public String getTableCellValue(String header) {
        return new Label(By.xpath(String.format(dynamicTableCell, header))).getText();
    }
}
