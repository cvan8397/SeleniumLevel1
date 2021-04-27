package page_objects;

import helper.BrowserHelper;
import helper.Constant;
import helper.DataHelper;
import helper.ElementHelper;
import helper.elements.Button;
import helper.elements.DropDownList;
import helper.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookTicketPage extends GeneralPage {
    private final DropDownList departDate = new DropDownList(By.name("Date"));
    private final DropDownList departFrom = new DropDownList(By.name("DepartStation"));
    private final DropDownList arriveAt = new DropDownList(By.cssSelector("select[name='ArriveStation']"));
    private final DropDownList seatType = new DropDownList(By.name("SeatType"));
    private final DropDownList ticketAmount = new DropDownList(By.name("TicketAmount"));
    private final Button btnBookTicket = new Button(By.cssSelector("input[type='submit']"));
    private final Label lblBookTicketSuccessfully = new Label(By.cssSelector("div[id='content']>h1"));

    private final Label departFromCheck = new Label(By.cssSelector(".OddRow>td:nth-child(1)"));
    private final Label arriveAtCheck = new Label(By.cssSelector(".OddRow>td:nth-child(2)"));
    private final Label seatTypeCheck = new Label(By.cssSelector(".OddRow>td:nth-child(3)"));
    private final Label departDateCheck = new Label(By.cssSelector(".OddRow>td:nth-child(4)"));
    private final Label bookDateCheck = new Label(By.cssSelector(".OddRow>td:nth-child(5)"));
    private final Label expiredDateCheck = new Label(By.cssSelector(".OddRow>td:nth-child(6)"));
    private final Label ticketAmountCheck = new Label(By.cssSelector(".OddRow>td:nth-child(7)"));
    private final Label lblMessage = new Label(By.cssSelector("#ArriveStation [href='http://somee.com']"));

    //String expectedInfoTicket;

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
        //setInfoTicket();
        this.btnBookTicket.click();
    }

//    public void setInfoTicket() {
//        String bookDate = DataHelper.getDate(0);
//        String expiredDate = DataHelper.getDate(3);
//        expectedInfoTicket = (this.departFrom.getText() + this.arriveAt.getText() + this.seatType.getText() + this.departDate.getText()
//                + bookDate + expiredDate + this.ticketAmount.getText());
//    }

//    public String getInfoTicket() {
//        return expectedInfoTicket;
//    }

    public String checkInfoTicket() {
        return (this.departFromCheck.getText() + this.arriveAtCheck.getText() + this.seatTypeCheck.getText() + this.departDateCheck.getText()
                + this.bookDateCheck.getText() + this.expiredDateCheck.getText() + this.ticketAmountCheck.getText());
    }
}
