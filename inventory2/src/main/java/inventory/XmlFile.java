package inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XmlFile extends TrackingFile {
	static StringBuilder sb2 = new StringBuilder();

	public XmlFile(ArrayList<Item> items) {
		super(items);
	}

	@Override
	void createTheFile() {
		sb2.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb2.append("<root>\n");
		int entryId = 1;
		for (Item item : items) {
			sb2.append("\t<Item id='" + entryId++ + "'>\n");
			sb2.append("\t\t<Name>" + item.getName() + "</Name>\n");
			sb2.append("\t\t<Serial_Number>" + item.getSerialNumber() + "</Serial_Number>\n");
			sb2.append("\t\t<Value>" + item.getAmount() + "</Value>\n");
			sb2.append("\t</Item>\n");
		}

		sb2.append("</root>\n");
		System.out.println(sb2.toString());

	}

	@Override
	void writingTheFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./items.xml"));
		writer.write(sb2.toString());
		writer.close();
	}

	public String toText(Item item){
		int entryId = 1;
		return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<root>\n"
				+ "\t<Item id='" + entryId + "'>\n"
				+ "\t\t<Name>" + item.getName() + "</Name>\n"
				+ "\t\t<Serial_Number>" + item.getSerialNumber() + "</Serial_Number>\n"
				+ "\t\t<Value>" + item.getAmount() + "</Value>\n"
				+ "\t</Item>\n"
				+ "</root>\n";
	}
}
