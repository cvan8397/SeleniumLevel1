package page_objects;

import elements.Button;
import elements.DropDown;
import elements.Label;
import models.Ticket;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    private final Label lblBookTicket = new Label(By.cssSelector("#content>h1"));
    private final Label lblBookTicketForm = new Label(By.cssSelector("fieldset>legend"));
    private final DropDown ddDepartDate = new DropDown(By.name("Date"));
    private final DropDown ddDepartFrom = new DropDown(By.name("DepartStation"));
    private final DropDown ddArriveAt = new DropDown(By.name("ArriveStation"));
    private final DropDown ddSeatType = new DropDown(By.name("SeatType"));
    private final DropDown ddTicketAmount = new DropDown(By.name("TicketAmount"));
    private final Button btnBookTicket = new Button(By.cssSelector("fieldset input"));

    public String getBookTicketTitle() {
        return this.lblBookTicket.getText();
    }

    public String getBookTicketFormTitle() {
        return this.lblBookTicketForm.getText();
    }

    public void bookTicket(Ticket ticket) {
        this.btnBookTicket.scrollToView();
        this.ddDepartFrom.selectDropdown(ticket.getDepartFrom());
        this.ddDepartDate.selectDropdown(ticket.getDepartDate());
        this.ddSeatType.selectDropdown(ticket.getSeatType());
        this.ddTicketAmount.selectDropdown(ticket.getTicketAmount());
        this.ddArriveAt.selectDropdown(ticket.getArriveAt());
        this.btnBookTicket.click();
    }
}
