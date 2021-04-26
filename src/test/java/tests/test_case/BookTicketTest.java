package tests.test_case;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Constant;
import helper.Common;
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

    @DataProvider(name = "valid-bookTicket")
    public static Object[] getValidBookTicket() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<BookTicket> bookTickets = objectMapper.readValue(Common.readFile("src/test/java/resources/data_driven/data-bookTicket/data-bookTicket.json"), new TypeReference<List<BookTicket>>() {
        });
        return bookTickets.toArray();

    }

    @Test(dataProvider = "valid-bookTicket", description = "User can book ticket successfully")
    public void TC01(BookTicket bookTicket) {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoBookTicketPage();
        Common.scrollPage();
        bookTicket.setDepartDate(Common.getDepartFromRandom());
        bookTicketPage.bookTicket(bookTicket.getDepartDate(), bookTicket.getDepartFrom(), bookTicket.getArriveAt(),
                bookTicket.getSeatType(), bookTicket.getTicketAmount());
        String actualMsg = bookTicketPage.getLblBookSuccessfully().getText();
        String expectedMsg = bookTicket.getMessages();

        Assert.assertEquals(actualMsg, expectedMsg, "BookTicket message is not displayed as expected");
    }
}
