package railway;

import common.Utilities;
import constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    JavascriptExecutor js;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");

        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()
                + "\\src\\main\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        js = (JavascriptExecutor) Constant.WEBDRIVER;

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can create new account with valid email and password");
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = homePage.gotoRegisterPage();
        js.executeScript("window.scrollBy(0,500)");
        String actualMsg = registerPage.createAccount(Constant.EMAIL, Constant.PASSWORD1, Constant.CONFIRM,
                Constant.PID).getCreateSuccessfullyMsg();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg1 = loginPage.login(Constant.EMAIL, Constant.PASSWORD1).getWelcomeMessage();
        String expectedMsg1 = "Welcome " + Constant.EMAIL;
        Assert.assertEquals(actualMsg1, expectedMsg1, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User can book ticket successfully");

    }
}
