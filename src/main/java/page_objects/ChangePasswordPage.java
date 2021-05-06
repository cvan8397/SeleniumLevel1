package page_objects;

import elements.Button;
import elements.Label;
import elements.TextBox;
import org.openqa.selenium.By;

public class ChangePasswordPage extends GeneralPage {
    private final TextBox txtCurrentPassword = new TextBox(By.id("currentPassword"));
    private final TextBox txtNewPassword = new TextBox(By.id("newPassword"));
    private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
    private final Button btnChangePassword = new Button(By.cssSelector(".form-actions input"));
    private final Label lblErrorMsg = new Label(By.cssSelector("[class='message error']"));

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.btnChangePassword.scrollToView();
        this.txtCurrentPassword.enterText(currentPassword);
        this.txtNewPassword.enterText(newPassword);
        this.txtConfirmPassword.enterText(confirmPassword);
        this.btnChangePassword.click();
    }

    public String getErrorMsgText() {
        return this.lblErrorMsg.getText();
    }
}
