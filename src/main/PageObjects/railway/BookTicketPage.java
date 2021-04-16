package railway;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    private final By departDate = By.name("Date");
    private final By departFrom = By.name("DepartStation");
    private final By arriveAt = By.name("ArriveStation");
    private final By seatType = By.name("SeatType");
    private final By ticketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");

    //elements

    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(departDate);
    }

    public WebElement getDepartFrom() {
        return Constant.WEBDRIVER.findElement(departFrom);
    }

    public WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(arriveAt);
    }

    public WebElement getSeatType() {
        return Constant.WEBDRIVER.findElement(seatType);
    }

    public WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(ticketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    //Methods
    public BookTicketPage bookTicket (String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount, String btnBookTicket){
        this.getDepartDate().sendKeys(departDate);
        this.getDepartFrom().sendKeys(departFrom);
        this.getArriveAt().sendKeys(arriveAt);
        this.getSeatType().sendKeys(seatType);
        this.getTicketAmount().sendKeys(ticketAmount);
        this.getBtnBookTicket().click();
        //Land on Book Ticket page
        return new BookTicketPage();
    }
}
