package page_objects;

import helper.Constant;
import helper.elements_helper.Label;
import org.openqa.selenium.By;
import page_objects.GeneralPage;

public class HomePage extends GeneralPage {
    private final Label lblWelcomeMessage = new Label(By.cssSelector("div[class='account']>strong"));

    public String getWelcomeMsgText(){
        return this.lblWelcomeMessage.getText();
    }
}
