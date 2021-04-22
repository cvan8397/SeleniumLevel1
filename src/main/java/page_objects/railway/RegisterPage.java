package page_objects.railway;

import helper.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@title='Register']");
    private final By lblRegisterMsg = By.xpath("//div[@id='content']/p");

    //elements
    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    public WebElement getTxtPid() {
        return Constant.WEBDRIVER.findElement(txtPid);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getLblRegister() {
        return Constant.WEBDRIVER.findElement(lblRegisterMsg);
    }

    //Methods
    public void createAccount(String email, String password, String confirmPassword, String pid) {
        //submit register credentials
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPid().sendKeys(pid);
        this.getBtnRegister().click();
    }

    public String getCreateSuccessfullyMsg() {
        return this.getLblCreateSuccessfully().getText();
    }
}
