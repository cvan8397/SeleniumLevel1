package tests;

import helper.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;


public class RegisterTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can create successfully with valid data")
    public void TC01() {
        String email = DataHelper.getRandomEmail();
        String randomPassword = DataHelper.getRandomPassword();
        String pid = DataHelper.getRandomPID();
        homePage.gotoRegisterPage();
        registerPage.createAccount(email, randomPassword, randomPassword, pid);
        String actualMsg = registerPage.getSuccessfullyMsgText();
        String expectedMsg = "You're here";

        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");
    }
}
