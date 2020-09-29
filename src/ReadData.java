import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author chinsung
 */
public class ReadData {

	/**
	 * @param filePath config.json file path
	 * @return json object
	 */
	public static JSONObject readJsonFile(String filePath) {

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object object = parser.parse(new FileReader(filePath));
			jsonObject = (JSONObject) object;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return jsonObject;
	}
}
