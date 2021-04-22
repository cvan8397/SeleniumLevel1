package test_cases;

import helper.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.railway.BookTicketPage;
import page_objects.railway.HomePage;
import page_objects.railway.LoginPage;

public class BookTicketTest extends TestBase{
    @Test
    public void TC01() {
        System.out.println("TC01 - User can book ticket successfully");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookTicketPage bookTicketPage = new BookTicketPage();
        loginPage.gotoBookTicketPage();
        js.executeScript("window.scrollBy(0,500)");
        bookTicketPage.bookTicket(Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        String actualMsg = bookTicketPage.getLblBookSuccessfully().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");
    }
}
