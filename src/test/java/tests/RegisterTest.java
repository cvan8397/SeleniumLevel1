package tests;

import helper.BrowserHelper;
import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;


public class RegisterTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test( description = "User can create successfully with valid data")
    public void TC01() {
        homePage.gotoRegisterPage();
        BrowserHelper.scrollPage();
        String randomPassword = DataHelper.getRandomPassword();
        registerPage.createAccount(DataHelper.getRandomEmail(), randomPassword, randomPassword, DataHelper.getRandomPID());
        String actualMsg = registerPage.getSuccessfullyMsg();
        String expectedMsg = "You're here" ;

        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");
    }
}
