package tests;

import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test(description = "User can login successfully with valid account")
    public void TC01() {
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualResult = homePage.getWelcomeMsgText();
        String expectedResult = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualResult, expectedResult, "Welcome message is not displayed as expected");
    }
}
