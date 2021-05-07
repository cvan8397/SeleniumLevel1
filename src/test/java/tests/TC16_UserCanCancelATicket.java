package tests;

import helper.DataHelper;
import models.Account;
import models.Ticket;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TC16_UserCanCancelATicket extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "User can cancel a ticket")
    public void TC016() {
        Account account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPID());
        homePage.gotoRegisterPage();
        registerPage.createAccount(account);
        registerPage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoBookTicketPage();
        Ticket ticket = new Ticket(DataHelper.getRandomDepartDate(), "Nha Trang", "Sài Gòn", "Soft seat", "1");
        bookTicketPage.bookTicket(ticket);
        bookTicketPage.gotoMyTicketPage();
        int ticketsAmountBeforeDeleting = myTicketPage.countTickets();
        myTicketPage.cancelTicket();
        int actualTicketsAmount = myTicketPage.countTickets();
        int expectedTicketsAmount = ticketsAmountBeforeDeleting -1;

        Assert.assertEquals(actualTicketsAmount, expectedTicketsAmount, "Ticket deletes unsuccessfully");
    }
}
