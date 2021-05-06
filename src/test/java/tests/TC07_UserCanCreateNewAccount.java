package tests;

import helper.DataHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TC07_UserCanCreateNewAccount extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can create new account")
    public void TC07() {
        Account account = new Account(DataHelper.getRandomEmail(), DataHelper.getRandomPassword(), DataHelper.getRandomPID());
        homePage.gotoRegisterPage();
        registerPage.createAccount(account);

        String actualMessage = registerPage.getSuccessfulMessage();
        String expectedMessage = "Thank you for registering your account";

        Assert.assertEquals(actualMessage, expectedMessage, "Register message is not displayed as expected");
    }
}
