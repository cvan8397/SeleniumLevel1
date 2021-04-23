package test_cases;

import helper.common.ReadAndWriteCsv;
import helper.common.ReadAndWriteJson;
import helper.constant.Constant;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.railway.HomePage;
import page_objects.railway.LoginPage;

import java.util.List;

public class LoginTest extends TestBase {

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        js.executeScript("window.scrollBy(0,500)");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        loginPage.getTabLogout().click();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can log into Railway with invalid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        List<String[]> list = ReadAndWriteCsv.readFile("src/test/java/resources/DataTestLogin.csv");
        for (int i = 0; i < list.size(); i++) {
            String username = list.get(i)[0];
            String password = list.get(i)[1];
            System.out.println("username: " + username + " , password: " + password);
            js.executeScript("window.scrollBy(0,500)");
            loginPage.login(username, password);
            if (loginPage.getLblLoginErrorMsg().isDisplayed()) {
                String actualMsg = loginPage.getLblLoginErrorMsg().getText();
                String expectedMsg = "Invalid username or password. Please try again.";
                System.out.println("actualMsg: " + actualMsg);
                System.out.println("expectedMsg: " + expectedMsg);
                Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
            }
        }
    }

    @Test
    public void TC03() {
        System.out.println("TC02 - User can log into Railway with invalid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        JSONArray list = ReadAndWriteJson.readFile("src/test/java/resources/DataTestLogin.json");
//        for (int i = 0; i < list.size(); i++) {
//            String username = list.get(i)[0];
//            String password = list.get(i)[1];
//            System.out.println("username: " + username + " , password: " + password);
//            js.executeScript("window.scrollBy(0,500)");
//            loginPage.login(username, password);
//            if (loginPage.getLblLoginErrorMsg().isDisplayed()) {
//                String actualMsg = loginPage.getLblLoginErrorMsg().getText();
//                String expectedMsg = "Invalid username or password. Please try again.";
//                System.out.println("actualMsg: " + actualMsg);
//                System.out.println("expectedMsg: " + expectedMsg);
//                Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
//            }
//        }
    }
}
