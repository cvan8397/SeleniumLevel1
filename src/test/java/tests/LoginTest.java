package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Common;
import helper.Constant;
import helper.Log;
import helper.models.Account;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class LoginTest extends TestBase {
    public static String invalidPath = "src/test/resources/data_driven/invalidLogin.json";
    String invalidUsername = "cloud";
    String invalidPwd = "1234";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can login successfully with valid account")
    public void TC01() {
        Log.startTestCase("TC01 - User can login successfully with valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualResult = homePage.getWelcomeMsgText();
        String expectedResult = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualResult, expectedResult, "Welcome message is not displayed as expected");
    }

    @Test(description = "User can not login unsuccessfully with invalid account")
    public void TC02() {
        homePage.gotoLoginPage();
        loginPage.login(invalidUsername, invalidPwd);
        String actualMsg = loginPage.getLoginErrorMsgText();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Errors message is not displayed as expected");
    }

    @DataProvider(name = "invalidLogin")
    public static Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Account> logins = objectMapper.readValue(Common.readFile(invalidPath), new TypeReference<List<Account>>() {
        });
        return logins.toArray();
    }

    @Test(dataProvider = "invalidLogin", description = "User can not login unsuccessfully with blank fields")
    public void TC03(Account account) {
        homePage.gotoLoginPage();
        loginPage.login(account.getUsername(), account.getPassword());
        String actualMsg = loginPage.getLoginErrorMsgText();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Errors message is not displayed as expected");
    }
}
