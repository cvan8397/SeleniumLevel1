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
    private final Label lblSuccessfullyMsg = new Label(By.id("content"));

    public void createAccount(Account account) {
        this.btnRegister.scrollToView();
        this.txtEmail.enterText(account.getUsername());
        this.txtPassword.enterText(account.getPassword());
        this.txtConfirmPassword.enterText(account.getPassword());
        this.txtPid.enterText(account.getPid());
        this.btnRegister.click();
    }

    public String getSuccessfullyMsgText() {
        return lblSuccessfullyMsg.getText();
    }
}
