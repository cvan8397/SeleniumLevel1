package tests;

import helper.Constant;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;


public class BookTicketTest extends TestBase {
    String departDate = DataHelper.getRandomDepartDate();
    String departFrom = "Đà Nẵng";
    String arriveAt = "Huế";
    String seatType = "Soft bed";
    String ticketAmount = "1";
    String bookDate = DataHelper.getDateFromToday(0);
    String expiredDate = DataHelper.getDateFromToday(3);

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
    }

    @Test(description = "User can book ticket successfully")
    public void TC01() {
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        String actualMsg = bookTicketPage.getSuccessfulMsgText();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Station"), departFrom, "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Arrive Station"), arriveAt, "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Seat Type"), seatType, "Seat type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Amount"), ticketAmount, "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Book Date"), bookDate, "Book date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Expired Date"), expiredDate, "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Date"), departDate, "Depart Date is not displayed as expected");
    }
}
