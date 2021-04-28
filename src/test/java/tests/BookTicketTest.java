package tests;

import helper.Constant;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;


public class BookTicketTest extends TestBase {
    String departFrom = "Đà Nẵng";
    String arriveAt = "Huế";
    String seatType = "Soft bed";
    String ticketAmount = "1";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    String bookDate = DataHelper.getDate(0);
    String expiredDate = DataHelper.getDate(2);

    @Test(description = "User can book ticket successfully")
    public void TC01() {
        String departDate = DataHelper.getDepartDateRandom();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);
        System.out.println(departDate);
        String actualMsg = bookTicketPage.getLblBookSuccessfully();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");

        String actualInfoTicket = bookTicketPage.checkTicket();
        String expectedInfoTicket = departFrom + arriveAt + seatType + departDate + bookDate + expiredDate + ticketAmount;

        Assert.assertEquals(actualInfoTicket, expectedInfoTicket, "Information of tickets are not displayed as expected");
    }
}
