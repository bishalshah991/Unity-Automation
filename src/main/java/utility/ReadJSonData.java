package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ReadJSonData {
    String path = System.getProperty("user.dir") + File.separator + "TestData" + File.separator + "EnvVariable.json";
    String n;
    String j;
    String k;

    public String Read_the_value_from_json(String path, String keyword) throws IOException, ParseException {

        Reader reader = new FileReader(path);
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            k = (String) jo.get(keyword);
        }
        return k;
    }

    public String ReadJSONURLData(String keyword) throws IOException, ParseException {
        Reader reader = new FileReader(path);
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {
            JSONObject jo = (JSONObject) obj;
            n = (String) jo.get(keyword);
        }
        return n;
    }
}


