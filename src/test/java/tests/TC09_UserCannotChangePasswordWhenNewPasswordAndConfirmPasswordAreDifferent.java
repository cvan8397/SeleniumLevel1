package tests;

import helper.Constant;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TC09_UserCannotChangePasswordWhenNewPasswordAndConfirmPasswordAreDifferent extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "User can't change password when 'New Password' and 'Confirm Password' are different")
    public void testCase09() {
        Account account = new Account(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoLoginPage();
        loginPage.login(account);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, "a123:\"/{}!@$\\", "b456:\"/{}!@$\\");

        String actualMessage = changePasswordPage.getErrorMessage();
        String expectedMessage = "Password change failed. Please correct the errors and try again.";

        Assert.assertEquals(actualMessage, expectedMessage, "Error message is not displayed as expected");
    }
}
