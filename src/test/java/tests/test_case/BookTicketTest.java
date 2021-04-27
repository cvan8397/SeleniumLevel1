package tests.test_case;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.BrowserHelper;
import helper.Constant;
import helper.Common;
import helper.DataHelper;
import helper.models.BookTicket;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class BookTicketTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();


    @Test(description = "User can book ticket successfully")
    public void TC01() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket(DataHelper.getDepartDateRandom(),Constant.DEPART_FROM, Constant.ARRIVE_AT, Constant.SEAT_TYPE, Constant.TICKET_AMOUNT);
        String actualMsg = bookTicketPage.getLblBookSuccessfully().getText();
        String expectedMsg = "Ticket booked successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");
    }
}
