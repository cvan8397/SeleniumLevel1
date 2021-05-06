package page_objects;

import elements.Label;
import org.openqa.selenium.By;

public class HomePage extends GeneralPage {
    private final Label lblWelcomeRailWay = new Label(By.cssSelector("#content>h1"));

    public String getWelcomeRailWayHeader() {
        return this.lblWelcomeRailWay.getText();
    }
}
