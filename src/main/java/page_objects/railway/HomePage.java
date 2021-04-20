package page_objects.railway;

import helper.constant.Constant;

public class HomePage extends GeneralPage {
    public void open(){
        Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
    }
}
