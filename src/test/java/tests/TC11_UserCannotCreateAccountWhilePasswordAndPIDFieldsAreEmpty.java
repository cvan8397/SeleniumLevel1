package tests;

import helper.DataHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class TC11_UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC011() {
        Account account = new Account(DataHelper.getRandomEmail(), "", "");
        homePage.gotoRegisterPage();
        registerPage.createAccount(account);

        String actualGeneralErrorMessage = registerPage.getGeneralErrorMessage();
        String expectedGeneralErrorMessage = "There're errors in the form. Please correct the errors and try again.";

        String actualPasswordMessage = registerPage.getPasswordErrorMessage();
        String expectedPasswordMessage = "Invalid password length";

        String actualPIDMessage = registerPage.getPIDErrorMessage();
        String expectedPIDMessage = "Invalid ID length";

        Assert.assertEquals(actualGeneralErrorMessage, expectedGeneralErrorMessage, "Error message is not displayed as expected");
        Assert.assertEquals(actualPasswordMessage, expectedPasswordMessage, "Password error message is not displayed as expected");
        Assert.assertEquals(actualPIDMessage, expectedPIDMessage, "Password error message is not displayed as expected");
    }
}
