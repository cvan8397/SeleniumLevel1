package page_objects;

import elements.Button;
import elements.Label;
import helper.BrowserHelper;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {
    private final Button btnCancel = new Button(By.cssSelector(".MyTable input"));
    private final Label lblNoteMessage = new Label(By.cssSelector("#content li"));

    public void cancelTicket() {
        this.btnCancel.scrollToView();
        this.btnCancel.click();
        BrowserHelper.acceptAlert();
    }

    public String getNoteMessage() {
        return this.lblNoteMessage.getText();
    }

    public boolean isTicketDisplayed() {
        return this.btnCancel.isDisplayed();
    }
}
