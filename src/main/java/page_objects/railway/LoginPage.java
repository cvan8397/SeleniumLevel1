package page_objects.railway;

import helper.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@title='Login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //elements

    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    public WebElement getTabLogout() {
        final By tabLogout = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Logout']");
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    //Methods
    public HomePage login(String username, String password) {
        //submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        //Land on Homepage
        return new HomePage();
    }

    public String loginData(String username, String password){
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        if (this.getWelcomeMessage()!="Welcome guest!") {
            this.getTabLogout().click();
            return "valid user";
        }

        return "invalid user";
    }
}
