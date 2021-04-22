package page_objects.railway;

import helper.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

public class BookTicketPage extends GeneralPage {
    private final By departDate = By.name("Date");
    private final By departFrom = By.name("DepartStation");
    private final By arriveAt = By.name("ArriveStation");
    private final By seatType = By.name("SeatType");
    private final By ticketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@type='submit']");
    private final By lblBookSuccessfully = By.cssSelector("div[id='content'] h1");

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

    public WebElement getLblBookSuccessfully() {
        return Constant.WEBDRIVER.findElement(lblBookSuccessfully);
    }

    //Methods
    public void bookTicket(String departFrom, String arriveAt, String seatType, String ticketAmount) {
        Calendar cal = Calendar.getInstance();
        int ranNum = ThreadLocalRandom.current().nextInt(3, 30);
        cal.add(Calendar.DATE, ranNum);
        String departDate = new SimpleDateFormat("M/dd/yyyy").format(cal.getTime());
        this.getDepartDate().sendKeys(departDate);
        this.getDepartFrom().sendKeys(departFrom);
        this.getArriveAt().sendKeys(arriveAt);
        this.getSeatType().sendKeys(seatType);
        this.getTicketAmount().sendKeys(ticketAmount);
        this.getBtnBookTicket().click();
    }
}
