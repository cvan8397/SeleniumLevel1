package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC03 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    String invalidPassword = "1234";

    @Test(description = "User cannot log into Railway with invalid password ")
    public void testCase02() {
        Account account = new Account(Constant.USERNAME, invalidPassword);
        homePage.gotoLoginPage();
        loginPage.login(account);

        String actualResult = loginPage.getGeneralErrorMSg();
        String expectedResult = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualResult, expectedResult, "Error message is not displayed as expected");
    }
}
