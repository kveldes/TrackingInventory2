package inventory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.opencsv.CSVWriter;

public class CsvFile extends TrackingFile {

	public CsvFile(ArrayList<Item> items) {
		super(items);

	}

	@Override
	void createTheFile() throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter("./list.csv"));
		csvWriter.writeNext(new String[] { "Name", "Serial_Number", "Value" });
		for (Item item : items) {
			csvWriter.writeNext(new String[] { item.getName(), item.getSerialNumber(), item.getAmount().toString() });
		}
		csvWriter.close();
		System.out.println("Success!The CSV file was written to the disk.");

	}

	public String toText(){
		if (items.isEmpty()){
			return "";
		}
		return itemsToCsv();
	}

	private String itemsToCsv() {
		return items
				.stream()
				.map(this::template)
				.collect(Collectors.joining("\n"));
	}

	private String template(Item item) {
		return item.getName() +
				"," +
				item.getSerialNumber() +
				"," +
				item.getAmount();
	}

	@Override
	void writingTheFile() {
		// Do not implement it theirs no need..

	}

}
