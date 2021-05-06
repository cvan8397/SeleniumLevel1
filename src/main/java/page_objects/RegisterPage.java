package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import models.Account;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.id("email"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final TextBox txtPid = new TextBox(By.id("pid"));
    private final Button btnRegister = new Button(By.cssSelector("input[title='Register']"));
    private final Label lblSuccessfulMessage = new Label(By.id("content"));
    private final Label lblErrorMessage = new Label(By.cssSelector("[class='message error']"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector("[for=password].validation-error"));
    private final Label lblPidErrorMessage = new Label(By.cssSelector("[for=pid].validation-error"));

    public void createAccount(Account account) {
        this.btnRegister.scrollToView();
        this.txtEmail.enterText(account.getUsername());
        this.txtPassword.enterText(account.getPassword());
        this.txtConfirmPassword.enterText(account.getPassword());
        this.txtPid.enterText(account.getPid());
        this.btnRegister.click();
    }

    public String getSuccessfulMessage() {
        return lblSuccessfulMessage.getText();
    }

    public String getGeneralErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblPasswordErrorMessage.getText();
    }

    public String getPIDErrorMessage() {
        return this.lblPidErrorMessage.getText();
    }
}
