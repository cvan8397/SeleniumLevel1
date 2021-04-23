package page_objects;

import helper.Constant;
import helper.elements_helper.Label;
import helper.elements_helper.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //locators
    private final Tab tabLogin = new Tab(By.cssSelector("a[href='/Account/Login.cshtml']"));
    private final Tab tabRegister = new Tab(By.cssSelector("a[href='/Account/Register.cshtml']"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("a[href='/Page/BookTicketPage.cshtml']>span"));
    private final Tab tabLogOut = new Tab(By.cssSelector("a[href='/Account/Logout']>span"));

    public void gotoRegisterPage() {
        this.tabRegister.click();
    }

    public void gotoLoginPage() {
        this.tabLogin.click();
    }

    public void gotoBookTicketPage(){
        this.tabBookTicket.click();
    }

    public void logout() {
        this.tabLogOut.click();
    }

}
