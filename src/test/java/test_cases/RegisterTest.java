package test_cases;

import helper.constant.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.railway.HomePage;
import page_objects.railway.LoginPage;
import page_objects.railway.RegisterPage;

public class RegisterTest extends TestBase {
    @Test
    public void TC01() {
        System.out.println("TC02 - User can create new account with valid email and password");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = new RegisterPage();
        homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)");
        registerPage.createAccount(Constant.EMAIL, Constant.PASSWORD1, Constant.CONFIRM, Constant.PID);
        String actualMsg = registerPage.getCreateSuccessfullyMsg();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");

        LoginPage loginPage = new LoginPage();
        homePage.gotoLoginPage();
        String actualMsg1 = loginPage.login(Constant.EMAIL, Constant.PASSWORD1).getWelcomeMessage();
        String expectedMsg1 = "Welcome " + Constant.EMAIL;
        Assert.assertEquals(actualMsg1, expectedMsg1, "Welcome message is not displayed as expected");
    }
}
