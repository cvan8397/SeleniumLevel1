package tests;

import helper.Constant;
import helper.DataHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TC10_UserCannotCreateAccountWithAnAlreadyInuseEmail extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account with an already in-use email")
    public void testCase10() {
        Account account = new Account(Constant.USERNAME, DataHelper.getRandomPassword(), DataHelper.getRandomPID());
        homePage.gotoRegisterPage();
        registerPage.createAccount(account);

        String actualMessage = registerPage.getErrorMessage();
        String expectedMessage = "This email address is already in use.";

        Assert.assertEquals(actualMessage, expectedMessage, "Error message is not displayed as expected");
    }
}
