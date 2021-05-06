package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import models.Account;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    private final TextBox txtUsername = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector(".form-actions input"));
    private final Label lblGeneralErrorMsg = new Label(By.cssSelector(".message.error.LoginForm"));
    private final Label lblEmailErrorMsg = new Label(By.cssSelector("[for=username].validation-error"));
    private final Label lblPasswordErrorMsg = new Label(By.cssSelector("[for=password].validation-error"));

    public void login(Account account) {
        this.btnLogin.scrollToView();
        this.txtUsername.enterText(account.getUsername());
        this.txtPassword.enterText(account.getPassword());
        this.btnLogin.click();
    }

    public String getGeneralErrorMsgText() {
        return this.lblGeneralErrorMsg.getText();
    }
}
