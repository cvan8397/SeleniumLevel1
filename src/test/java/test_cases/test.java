package test_cases;

import helper.common.ReadAndWriteJson;
import org.json.simple.JSONArray;

public class test {
    public static void main(String[] args) {
        JSONArray list = ReadAndWriteJson.readFile("src/test/java/resources/DataTestLogin.json");
        System.out.println(list);
    }
}
