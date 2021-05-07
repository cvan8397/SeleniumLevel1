package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.TicketPricePage;
import page_objects.TimetablePage;

public class TC15_TicketPricePageDisplaysWithTicketDetails extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimetablePage timetablePage = new TimetablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "User can login successfully with valid username and password")
    public void testCase15() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoTimetablePage();
        timetablePage.getInformationPrice();

        String actualPageHeader = ticketPricePage.getPageHeader();
        String expectedPageHeader = "Ticket Price";

        String actualTableHeader = ticketPricePage.getTableHeader();
        String expectedTableHeader = "Ticket price from Đà Nẵng to Sài Gòn";

        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Ticket Price page is not displayed as expected");
        Assert.assertEquals(actualTableHeader, expectedTableHeader, "Ticket table is not shown as expected");
    }
}
