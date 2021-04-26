package tests.test_case;

import helper.Common;
import helper.ReadAndWriteCsv;
import helper.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.util.List;

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

    @Test (dataProvider = "login" , description = "Login successfully with valid account")
    public void TC02(String data) {
        String users[] = data.split(",");
        System.out.println("TC01 - User can log into Railway with valid username and password");
        homePage.gotoLoginPage();
        Common.scrollPage();
        loginPage.login(users[0],users[1]);
        String actualMsg = homePage.getWelcomeMsgText();
        String expectedMsg = "Welcome " + users[0];
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

//    @Test
//    public void TC02() {
//        System.out.println("TC02 - User can log into Railway with invalid username and password");
//        HomePage homePage = new HomePage();
//        homePage.gotoLoginPage();
//        LoginPage loginPage = new LoginPage();
//        List<String[]> list = ReadAndWriteCsv.readFile("src/test/java/resources/DataTestLogin.csv");
//        for (int i = 0; i < list.size(); i++) {
//            String username = list.get(i)[0];
//            String password = list.get(i)[1];
//            System.out.println("username: " + username + " , password: " + password);
//            Common.scrollPage();
//            loginPage.login(username, password);
//            if (loginPage.getLblLoginErrorMsg().isDisplayed()) {
//                String actualMsg = loginPage.getTextLblLoginErrorMsg();
//                String expectedMsg = "Invalid username or password. Please try again.";
//                System.out.println("actualMsg: " + actualMsg);
//                System.out.println("expectedMsg: " + expectedMsg);
//                Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
//            }
//        }
//    }
}
