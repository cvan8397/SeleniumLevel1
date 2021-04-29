package page_objects;

import helper.elements.Button;
import helper.elements.Label;
import helper.elements.TextBox;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.id("email"));
    private final TextBox txtPassword = new TextBox(By.id("password"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final TextBox txtPid = new TextBox(By.id("pid"));
    private final Button btnRegister = new Button(By.xpath("//input[@title='Register']"));
    private final Label lblSuccessfullyMsg = new Label(By.cssSelector("div[id='content']>p"));

    public void createAccount(String email, String password, String confirmPassword, String pid) {
        this.txtEmail.enterText(email);
        this.txtPassword.enterText(password);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.txtPid.enterText(pid);
        this.btnRegister.submit();
    }

    public String getSuccessfullyMsgText() {
        return lblSuccessfullyMsg.getText();
    }
}
