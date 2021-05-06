package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC02_UserCanNotLoginWithBlankUsername extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();;

    @Test(description = "User can't login with blank 'Username' textbox")
    public void testCase02() {
        Account account = new Account("", Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);

        String actualResult = loginPage.getGeneralErrorMsg();
        String expectedResult = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualResult, expectedResult, "Error message is not displayed as expected");
    }
}
