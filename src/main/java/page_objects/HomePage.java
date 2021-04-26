package page_objects;

import helper.elements.Label;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    private final Label lblWelcomeMessage = new Label(By.cssSelector("div[class='account']>strong"));

    public String getWelcomeMsgText(){
        return this.lblWelcomeMessage.getText();
    }
}
