package page_objects;

import elements.Button;
import elements.Label;
import helper.BrowserHelper;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {
    private final Button btnCancel = new Button(By.cssSelector(".MyTable input"));

    public void cancelTicket() {
        this.btnCancel.scrollToView();
        this.btnCancel.click();
        BrowserHelper.acceptAlert();
    }

    public int countTickets(){
        return this.btnCancel.findElements().size();
    }
}
