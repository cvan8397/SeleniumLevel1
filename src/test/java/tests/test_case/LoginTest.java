package tests.test_case;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Common;
import helper.models.Login;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class LoginTest extends TestBase {
    public static String validPath = "src/test/java/resources/data_driven/data-login/valid-login.json";
    public static String invalidPath = "src/test/java/resources/data_driven/data-login/invalid-data.json";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @DataProvider(name = "valid-login")
    public static Object[] getValidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile(validPath), new TypeReference<List<Login>>() {
        });
        return logins.toArray();
    }

    @Test(dataProvider = "valid-login", description = "Login successfully with valid account")
    public void TC01(Login login) {
        homePage.gotoLoginPage();
        loginPage.login(login.getUsername(), login.getPassword());
        String actualResult = homePage.getWelcomeMsgText();
        String expectedResult = login.getMessages();
        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, "Welcome message is not displayed as expected");
    }

    @DataProvider(name = "invalid-login")
    public static Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Login> logins = objectMapper.readValue(Common.readFile(invalidPath), new TypeReference<List<Login>>() {
        });
        return logins.toArray();
    }

    @Test(dataProvider = "invalid-login")
    public void TC02(Login login) {
        homePage.gotoLoginPage();
        loginPage.login(login.getUsername(), login.getPassword());
        String actualMsg = loginPage.getTextLblLoginErrorMsg();
        String expectedMsg = login.getMessages();

        Assert.assertEquals(actualMsg, expectedMsg, "Errors message is not displayed as expected");
    }


}
