package page_objects;

import helper.Constant;
import helper.elements_helper.Button;
import helper.elements_helper.Label;
import helper.elements_helper.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.GeneralPage;

import java.awt.event.TextEvent;

public class LoginPage extends GeneralPage {
    private final TextBox txtUsername = new TextBox(By.id("username"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final Button btnLogin = new Button(By.cssSelector("input[type='submit']"));
    private final Label lblLoginErrorMsg = new Label(By.xpath("//p[@class='message error LoginForm']"));

    //Methods
    public void login(String username, String password) {
        this.txtUsername.enterText(username);
        this.txtPassword.enterText(password);
        this.btnLogin.click();;
    }
    public String getTextLblLoginErrorMsg(){
        return this.lblLoginErrorMsg.getText();
    }
}
