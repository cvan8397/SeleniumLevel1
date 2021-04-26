package page_objects;

import helper.Common;
import helper.elements.Button;
import helper.elements.Label;
import helper.elements.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    private final TextBox txtUsername = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector("input[type='submit']"));
    private final Label lblGeneralErrorMsg = new Label(By.cssSelector(".message.error.LoginForm"));
    private final Label lblEmailErrorMsg = new Label(By.cssSelector("[for=username].validation-error"));
    private final Label lblPasswordErrorMsg= new Label(By.cssSelector("[for=password].validation-error"));


    //Methods
    public void login(String username, String password) {
        Common.scrollPage();
        this.txtUsername.enterText(username);
        this.txtPassword.enterText(password);
        this.btnLogin.click();;
    }
    public String getTextLblLoginErrorMsg(){
        return this.lblGeneralErrorMsg.getText() + this.lblEmailErrorMsg.getText() + this.lblPasswordErrorMsg.getText();
    }
}
