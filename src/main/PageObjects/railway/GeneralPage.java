package railway;

import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Logout']");
    private final By tabRegister = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Register.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblCreateSuccessfullyMsg = By.xpath("//div[@id='content']/p");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getLblCreateSuccessfully(){
        return Constant.WEBDRIVER.findElement(lblCreateSuccessfullyMsg);
    }
    //Method
    public String getWelcomeMessage(){
        return this.getLblWelcomeMessage().getText();
    }

    public LoginPage gotoLoginPage(){
        this.getTabLogin().click();
        return new LoginPage();
    }

    public String getCreateSuccessfullyMsg(){
        return this.getLblCreateSuccessfully().getText();
    }

    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }
}
