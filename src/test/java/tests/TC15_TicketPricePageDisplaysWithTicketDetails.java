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

    @Test(description = "User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
    public void testCase15() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoTimetablePage();
        timetablePage.getInformationPrice();

        String actualPageHeader = ticketPricePage.getPageHeader();
        String expectedPageHeader = "Ticket Price";

        String actualTableHeader = ticketPricePage.getTableHeader();
        String expectedTableHeader = "Ticket price from Sài Gòn to Phan Thiết";

        Assert.assertEquals(actualPageHeader, expectedPageHeader, "Ticket Price page is not displayed as expected");
        Assert.assertEquals(actualTableHeader, expectedTableHeader, "Ticket table is not shown as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("HS"), "310000", "HS is not displayed as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("SS"), "335000", "SS is not displayed as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("SSC"), "360000", "SSC is not displayed as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("HB"), "410000", "HB is not displayed as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("SB"), "460000", "SB is not displayed as expected");
        Assert.assertEquals(ticketPricePage.getTableCellValue("SBC"), "510000", "SBC is not displayed as expected");
    }
}
