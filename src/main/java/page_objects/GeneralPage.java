package page_objects;

import elements.Label;
import elements.Tab;
import org.openqa.selenium.By;

public class GeneralPage {
    private final Tab loginTab = new Tab(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Tab registerTab = new Tab(By.cssSelector("a[href='/Account/Register.cshtml']"));
    private final Tab bookTicketTab = new Tab(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']>span"));
    private final Tab logOutTab = new Tab(By.cssSelector("a[href='/Account/Logout']>span"));
    private final Tab changePwdTab = new Tab(By.cssSelector("a[href='/Account/ChangePassword.cshtml']"));
    private final Tab MyTicketTab = new Tab(By.cssSelector("a[href='/Page/ManageTicket.cshtml']"));
    private final Label lblWelcomeMessage = new Label(By.cssSelector("div[class='account']>strong"));

    public void gotoRegisterPage() {
        this.registerTab.click();
    }

    public void gotoLoginPage() {
        this.loginTab.click();
    }

    public void gotoBookTicketPage() {
        this.bookTicketTab.click();
    }

    public void gotoChangePasswordPage() {
        this.changePwdTab.click();
    }

    public void gotoMyTicketPage() {
        this.MyTicketTab.click();
    }

    public void logout() {
        this.logOutTab.click();
    }

    public String getWelcomeMsgText() {
        return this.lblWelcomeMessage.getText();
    }
}
