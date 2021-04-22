package page_objects.railway;

import helper.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@title='Login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //elements

    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }


    public WebElement getTabLogout() {
        final By tabLogout = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Logout']");
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    //Methods
    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }
}
