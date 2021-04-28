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


    public String getLblBookSuccessfully() {
        return this.lblBookTicketSuccessfully.getText();
    }

    //Methods
    public void bookTicket(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        BrowserHelper.scrollPage();
        this.departDate.selectDropdown(departDate);
        this.departFrom.selectDropdown(departFrom);
        this.seatType.selectDropdown(seatType);
        this.ticketAmount.selectDropdown(ticketAmount);
        this.arriveAt.selectDropdown(arriveAt);
        this.btnBookTicket.submit();
    }

    public WebElement getTdTextByHeader(String header){
        String tdText = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";
        return BrowserHelper.getWebDriver().findElement(By.xpath(String.format(tdText, header)));
    }

    public String getTextByHead(String header){
        return getTdTextByHeader(header).getText();
    }

    public String checkTicket(){
        return getTextByHead("Depart Station") + getTextByHead("Arrive Station")
                + getTextByHead("Seat Type") + getTextByHead("Depart Date")
                + getTextByHead("Book Date") + getTextByHead("Expired Date")
                + getTextByHead("Amount");
    }
}
