package inventory;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JsonRepository {
	private Item item;
	JSONObject jsonObject = new JSONObject();

	public JsonRepository(Item item) {
		itemNotNull(item);
		this.item = item;

	}

	private void itemNotNull(Item item) {
		if (item == null) {
			throw new RuntimeException("Item object cannot be null");
		}
	}

	public boolean isCreationOfJsonFileSucceed(Item item) {
		insertedValuesIntoJsonObject(item);
		jsonObjectNotEmpty();
		return tryToWriteTheJsonFile();


	}

	private void insertedValuesIntoJsonObject(Item item) {
		jsonObject.put("Name", item.getName());
		jsonObject.put("Serial Number", item.getSerialNumber());
		jsonObject.put("Value", item.getAmount());
	}

	private void jsonObjectNotEmpty() {
		if (jsonObject.size() == 0) {
			throw new RuntimeException("JsonOject cannot be null");
		}
	}

	private boolean tryToWriteTheJsonFile() {
		try {
			FileWriter file = new FileWriter("C:/output.json");
			file.write(jsonObject.toJSONString());
			file.close();
			System.out.println("JSON file created: " + jsonObject);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


}

