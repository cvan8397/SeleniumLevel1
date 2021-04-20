package test_cases;

import helper.constant.Constant;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.railway.HomePage;
import page_objects.railway.LoginPage;

import java.io.*;
import java.text.ParseException;

public class LoginTest extends TestBase {

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        js.executeScript("window.scrollBy(0,500)");
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @SuppressWarnings("unchecked")
    public void readWriteJSON() throws InterruptedException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();

        try {
            FileReader reader = new FileReader("src/test/resources/datatest.json");
            Object obj = jsonParser.parse();
            JSONArray usersList = (JSONArray) obj;
            System.out.println("Users List-> " + usersList); //This prints the entire json file
            for (int i = 0; i < usersList.size(); i++) {
                JSONObject users = (JSONObject) usersList.get(i);
                System.out.println("Users -> " + users);//This prints every block - one json object
                String username = (String) users.get("username");
                String password = (String) users.get("password");
                String result = loginPage.loginData(username, password);
                users.put("result", result);
//Write JSON file
                try (FileWriter file = new FileWriter("src/test/resources/Testdata1.json")) {

                    file.append(usersList.toJSONString());
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(users);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
