package page_objects.railway;

import helper.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final By tabLogin = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Login.cshtml']");
    private final By tabRegister = By.xpath("//div[@id= 'menu' ]//a[@href='/Account/Register.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblCreateSuccessfullyMsg = By.xpath("//div[@id='content']/p");
    private final By tabBookTicket = By.xpath("//div[@id= 'menu' ]//a[@href='/Page/BookTicketPage.cshtml']");
    private final By lblBookTicketSuccessfully = By.cssSelector("div[id='content']>h1");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }


    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getLblCreateSuccessfully() {
        return Constant.WEBDRIVER.findElement(lblCreateSuccessfullyMsg);
    }

    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getLblBookTicketSuccessfully(){
        return Constant.WEBDRIVER.findElement(lblBookTicketSuccessfully);
    }

    //Method
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoBookTicketPage(){
        this.getTabBookTicket();
    }
}
