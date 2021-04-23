package page_objects;

import helper.Constant;
import helper.elements_helper.Button;
import helper.elements_helper.Label;
import helper.elements_helper.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.GeneralPage;

public class RegisterPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.id("email"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final TextBox txtPid = new TextBox(By.id("pid"));
    private final Button btnRegister = new Button(By.xpath("//input[@title='Register']"));
    private final Label lblCreateSuccessfullyMsg = new Label(By.cssSelector("div[id='content']>p"));
    private final Button lblRegisterMsg = new Button(By.xpath("//div[@id='content']/p"));

    //Methods
    public void createAccount(String email, String password, String confirmPassword, String pid) {
        //submit register credentials
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.txtPid.enterText(pid);
        this.btnRegister.click();
    }

    public String getCreateSuccessfullyMsg() {
        return lblCreateSuccessfullyMsg.getText();
    }
}