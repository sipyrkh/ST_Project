package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonReader {

    private static final String BROWSER_SETTINGS_FILE_NAME = "browser.json";

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(getPathToFile(BROWSER_SETTINGS_FILE_NAME))) {
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            parseEmployeeObject((JSONObject) employeeList.get(0));
        }
    }

    private static void parseEmployeeObject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject) employee.get("test_data");
        String firstName = (String) employeeObject.get("phoneNumber");
        System.out.println(firstName);
        String lastName = (String) employeeObject.get("email");
        System.out.println(lastName);
    }

    private static String getPathToFile(String filename) {
        Path resourceDirectory = Paths.get("src", "test", "resources", filename);
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
