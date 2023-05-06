package src.com.TestStructure.Utils;


import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class testDataReader {
    public static JSONObject testData() {

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/com/TestStructure/Objects/testApi.json")));
            return new JSONObject(jsonData);
        } catch (Exception e) {
            System.out.println("Exception testData "+ e);
            e.printStackTrace();
        }
        return null;
    }


}




