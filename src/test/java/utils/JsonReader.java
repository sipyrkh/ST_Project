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

    private static final String BROWSER_SETTINGS_FILE_NAME = "config.json";
    private static final String BROWSER_SETTINGS_BLOCK_NAME = "browser";
    private static final String TEST_DATA_BLOCK_NAME = "test_data";
    private static final Integer BROWSER_SETTINGS_BLOCK_INDEX = 0;
    private static final Integer TEST_DATA_BLOCK_INDEX = 1;

    public static String getTestDataParameter(String parameter) {
        JSONArray jsonArray = parseJson();
        JSONObject jsonObject = (JSONObject) jsonArray.get(TEST_DATA_BLOCK_INDEX);
        JSONObject remoteParameter = (JSONObject) jsonObject.get(TEST_DATA_BLOCK_NAME);
        return (String) remoteParameter.get(parameter);
    }

    public static String getBrowserParameter(String parameter) {
        JSONArray jsonArray = parseJson();
        JSONObject jsonObject = (JSONObject) jsonArray.get(BROWSER_SETTINGS_BLOCK_INDEX);
        JSONObject remoteParameter = (JSONObject) jsonObject.get(BROWSER_SETTINGS_BLOCK_NAME);
        return (String) remoteParameter.get(parameter);
    }

    private static JSONArray parseJson() {
        JSONArray jsonArray = null;
        try (FileReader reader = new FileReader(getPathToFile(BROWSER_SETTINGS_FILE_NAME))) {
            Object obj = new JSONParser().parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    private static String getPathToFile(String filename) {
        Path resourceDirectory = Paths.get("src", "test", "resources", filename);
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
