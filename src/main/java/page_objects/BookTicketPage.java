package page_objects;

import helper.BrowserHelper;
import helper.ElementHelper;
import helper.elements.BaseElement;
import helper.elements.Button;
import helper.elements.DropDown;
import helper.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class BookTicketPage extends GeneralPage {
    private final DropDown departDate = new DropDown(By.name("Date"));
    private final DropDown departFrom = new DropDown(By.name("DepartStation"));
    private final DropDown arriveAt = new DropDown(By.cssSelector("select[name='ArriveStation']"));
    private final DropDown seatType = new DropDown(By.name("SeatType"));
    private final DropDown ticketAmount = new DropDown(By.name("TicketAmount"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[type='submit']"));
    private final Label lblSuccessfulMsg = new Label(By.cssSelector("div[id='content']>h1"));
    private final By arriveAtElement = By.cssSelector("select[name='ArriveStation']");

    private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";

    public String getSuccessfulMsgText() {
        return this.lblSuccessfulMsg.getText();
    }

    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.departDate.selectDropdown(departDate);
        this.departFrom.selectDropdown(departFrom);
        this.seatType.selectDropdown(seatType);
        this.ticketAmount.selectDropdown(ticketAmount);
        ElementHelper.notStalenessOf(BrowserHelper.getWebDriver().findElement(arriveAtElement),10);
        this.arriveAt.selectDropdown(arriveAt);
        this.btnBookTicket.submit();
    }

    public String getTableCellValue(String header) {
        return new Label(By.xpath(String.format(dynamicTableCell, header))).getText();
    }
}
