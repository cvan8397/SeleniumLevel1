package tests.test_case;

import helper.Common;
import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class RegisterTest extends TestBase {
    @Test
    public void TC01() {
        System.out.println("TC01 - User can create new account with valid email and password");
        HomePage homePage = new HomePage();

        RegisterPage registerPage = new RegisterPage();
        homePage.gotoRegisterPage();
        Common.scrollPage();
        registerPage.createAccount(Constant.EMAIL, Constant.PASSWORD1, Constant.CONFIRM, Constant.PID);
        String actualMsg = registerPage.getCreateSuccessfullyMsg();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");

        LoginPage loginPage = new LoginPage();
        homePage.gotoLoginPage();
        loginPage.login(Constant.EMAIL, Constant.PASSWORD1);
        String actualMsg1 = homePage.getWelcomeMsgText();
        String expectedMsg1 = "Welcome " + Constant.EMAIL;
        Assert.assertEquals(actualMsg1, expectedMsg1, "Welcome message is not displayed as expected");
    }
}
