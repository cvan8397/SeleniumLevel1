package tests.test_case;

import helper.Common;
import helper.DataProviderHelper;
import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTest extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.gotoLoginPage();
        Common.scrollPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMsgText();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test (dataProvider = "login" , dataProviderClass = DataProviderHelper.class, description = "Login successfully with valid account")
    public void TC02(String data) {
        String users[] = data.split(",");
        homePage.gotoLoginPage();
        Common.scrollPage();
        loginPage.login(users[0],users[1]);
        String actualMsg = loginPage.getTextLblLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
