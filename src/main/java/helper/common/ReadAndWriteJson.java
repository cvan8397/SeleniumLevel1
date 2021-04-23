package helper.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadAndWriteJson {
    public static JSONArray readFile(String PATH) {
        JSONParser jsonParser = new JSONParser();
        JSONArray listJson = new JSONArray();
        try {
            FileReader reader = new FileReader(PATH);
            Object object = jsonParser.parse(reader);
            listJson = (JSONArray) object;
            //JSONObject listJsonObj = (JSONObject) listJson.get
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return listJson ;
    }

}
