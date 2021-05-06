package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    private final Label lblBookTicket = new Label(By.cssSelector("#content>h1"));
    private final Label lblBookTicketForm = new Label(By.cssSelector("fieldset>legend"));

    public String getBookTicketTitle() {
        return this.lblBookTicket.getText();
    }

    public String getBookTicketFormTitle() {
        return this.lblBookTicketForm.getText();
    }
}
