package tests;

import helper.BrowserHelper;
import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ContactPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC06_UserIsRedirectedToHomePageAfterLoggingOut extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ContactPage contactPage = new ContactPage();

    @Test(description = "User is redirected to Home page after logging out")
    public void testCase06() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoContactPage();
        contactPage.logout();

        String actualResult = BrowserHelper.getTitle();
        String expectedResult = "Safe Railway - Selenium Automation";

        Assert.assertEquals(actualResult, expectedResult, "Home page is not displayed as expected");
        Assert.assertFalse(homePage.checkLogoutTabExits(), "Logout tab is not disappeared");
    }
}
