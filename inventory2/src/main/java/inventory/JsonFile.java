package inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFile extends TrackingFile {

	private static final String NAME_PROPERTY = "name";
	private static final String SERIAL_NUMBER_PROPERTY = "sn";
	private static final String VALUE_PROPERTY = "value";

	public JsonFile(ArrayList<Item> items) {
		super(items);
	}

	static String json = "";
	static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().setPrettyPrinting()
			.setVersion(1.0).create();

	@Override
	void createTheFile() {
		json = gson.toJson(super.items);
		System.out.println(json);

	}

	public String toText(Item item){
		return String.format(template(), item.getName(), item.getSerialNumber(),item.getAmount());
	}

	@Override
	void writingTheFile() throws IOException {
		String str = json;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./items.json"));
		writer.write(str);
		writer.close();

	}

	private String template() {
		return String.format(
				"{ \"%s\": \"%%s\", \"%s\": \"%%s\", \"%s\": %%s }",
				NAME_PROPERTY,
				SERIAL_NUMBER_PROPERTY,
				VALUE_PROPERTY
		);
	}
}
