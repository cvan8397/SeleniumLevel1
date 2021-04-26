package helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataProviderHelper {
    @DataProvider(name="login")
    public Object[] dataLogin () throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/resources/data_driven/data-login/invalid-data.json");
        Object obj = jsonParser.parse(reader);
        JSONObject userLonginJsonObj = (JSONObject) obj;
        JSONArray userLoginArray = (JSONArray) userLonginJsonObj.get("invalid-login");
        String arr[] = new String[userLoginArray.size()];
        for (int i=0; i<userLoginArray.size(); i++){
            JSONObject users = (JSONObject) userLoginArray.get(i);
            String user = (String) users.get("username");
            String pwd = (String) users.get("password");
            arr[i] = user+","+pwd;
        }
        return arr;
    }

}
