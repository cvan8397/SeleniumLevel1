package tests;

import helper.DataHelper;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class TC14_UserCanBookManyTicketAtATime extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    String departDate = DataHelper.getRandomDepartDate();
    String bookDate = DataHelper.getDateFromToday(0);
    String expiredDate = DataHelper.getDateFromToday(3);

    @Test(description = "User can book many tickets at a time")
    public void TC014() {
        Account account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPID());
        homePage.gotoRegisterPage();
        registerPage.createAccount(account);
        registerPage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoBookTicketPage();
        Ticket ticket = new Ticket(departDate, "Nha Trang", "Sài Gòn", "Soft seat", "5");
        bookTicketPage.bookTicket(ticket);

        String actualSuccessfulMessage = bookTicketPage.getSuccessfulMessage();
        String expectedSuccessfulMessage = "Ticket Booked Successfully!";

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage, "BookTicket message is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Station"), "Nha Trang", "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Arrive Station"), "Sài Gòn", "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Seat Type"), "Soft seat", "Seat type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Amount"), "5", "Amount is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Book Date"), bookDate, "Book date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Expired Date"), expiredDate, "Expired Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Date"), departDate, "Depart Date is not displayed as expected");
    }
}
