package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC02 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can login successfully with valid username and password")
    public void testCase01() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);

        String actualResult = homePage.getWelcomeMsgText();
        String expectedResult = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualResult, expectedResult, "Welcome message is not displayed as expected");
    }
}
