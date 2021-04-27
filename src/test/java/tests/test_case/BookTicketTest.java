package tests.test_case;

import helper.Constant;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;


public class BookTicketTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    String bookDate = DataHelper.getDate(0);
    String expiredDate = DataHelper.getDate(3);

    @Test(description = "User can book ticket successfully")
    public void TC01() {
        String departDate = DataHelper.getDepartDateRandom();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate, Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        System.out.println(departDate);
        String actualMsg = bookTicketPage.getLblBookSuccessfully();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");

        String actualInfoTicket = bookTicketPage.checkInfoTicket();
        String expectedInfoTicket = Constant.DEPART_FROM + Constant.ARRIVE_AT + Constant.SEAT_TYPE  + departDate +
                bookDate + expiredDate + Constant.TICKET_AMOUNT;

        Assert.assertEquals(actualInfoTicket, expectedInfoTicket, "Information of tickets are not displayed as expected");
    }
}
