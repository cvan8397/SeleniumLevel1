package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC04_UserIsRedirectedToBookTicketPageAfterLoggingIn extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User is redirected to Book ticket page after logging in")
    public void testCase04() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        loginPage.login(account);

        String actualResult = bookTicketPage.getBookTicketTitle();
        String expectedResult = "Book ticket";

        Assert.assertEquals(actualResult, expectedResult, "Book ticket page is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getLbLBookTicketFormTitle(), "Book ticket form", "Book ticket form is not displayed as expected");
    }
}
