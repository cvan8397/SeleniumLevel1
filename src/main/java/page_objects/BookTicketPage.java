package page_objects;

import helper.BrowserHelper;
import helper.DataHelper;
import helper.elements.Button;
import helper.elements.DropDownList;
import helper.elements.Label;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    private final DropDownList departDate = new DropDownList(By.name("Date"));
    private final DropDownList departFrom = new DropDownList(By.name("DepartStation"));
    private final DropDownList arriveAt = new DropDownList(By.name("ArriveStation"));
    private final DropDownList seatType = new DropDownList(By.name("SeatType"));
    private final DropDownList ticketAmount = new DropDownList(By.name("TicketAmount"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[type='submit']"));
    private final Label lblBookTicketSuccessfully = new Label(By.cssSelector("div[id='content']>h1"));

    private final Label departDateCheck= new Label(By.cssSelector("div[id='content']>h1"));

    public String getLblBookSuccessfully() {
        return this.lblBookTicketSuccessfully.getText();
    }

    //Methods
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        BrowserHelper.scrollPage();
        this.departDate.selectDropdown(departDate);
        this.departFrom.selectDropdown(departFrom);
        this.arriveAt.selectDropdown(arriveAt);
        this.seatType.selectDropdown(seatType);
        this.ticketAmount.selectDropdown(ticketAmount);
        this.btnBookTicket.click();
    }

    public void checkInforTicket(){

    }
}
