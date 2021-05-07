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

        String actualPasswordErrorMessage = registerPage.getPasswordErrorMessage();
        String expectedPasswordErrorMessage = "Invalid password length";

        String actualPIDErrorMessage = registerPage.getPIDErrorMessage();
        String expectedPIDErrorMessage = "Invalid ID length";

        Assert.assertEquals(actualGeneralErrorMessage, expectedGeneralErrorMessage, "Error message is not displayed as expected");
        Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage, "Password error message is not displayed as expected");
        Assert.assertEquals(actualPIDErrorMessage, expectedPIDErrorMessage, "Password error message is not displayed as expected");
    }
}
