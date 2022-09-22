package inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVWriter;


public class Menu {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Item> items = new ArrayList<>();
	static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls().setPrettyPrinting()
			.setVersion(1.0).create();
	static String json = "";
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();
	private static final String ITEMS_LIST_FILE = "./items-list.csv";

	public static void printMenu(String[] options) {
		for (String option : options) {
			System.out.println(option);
		}
		System.out.print("Choose your option : ");
	}

	private static String[] options = { "1- Adding an Item ", "2- Create and Print the Json file of Items",
			"3- Create and Print the Html file of Items", "4- Create and Print the Xml file of Items",
			"5- Create and Print the Csv file of Items", "6- Exit", };

	public static void addingItemsFromUserInput() {

		int option = 1;
		while (option != 7) {
			printMenu(options);
			try {
				option = scanner.nextInt();
				switch (option) {
				case 1:
					System.out.print("Please enter the Name of the Item: ");
					String name = scanner.next();
					System.out.print("Please enter the Serial Number of the Item: ");
					String serialNumber = scanner.next();
					System.out.println("Please enter the Item Value");
					String stringAmount = scanner.next();
					BigDecimal amount = new BigDecimal(stringAmount);
					addingAnItem(name, serialNumber, amount);
					break;
				case 2:
					createTheJsonfile();
					writingJsonStringIntoFile();
					break;
				case 3:
					createTheHtmlfile();
					writingHtmlIntoFile();
					break;
				case 4:
					createTheXmlfile();
					writingXmlIntoFile();
					break;
				case 5:
					createTheCsvfile();
					// writingCsvIntoFile();
					break;
				case 6:
					scanner.close();
					System.out.println("Have A Nice Day!");
					return;
				}
			} catch (Exception ex) {
				System.out.println("Please enter an integer value between 1 and " + options.length);
				scanner.next();
			}
		}
	}

	// Options
	private static void addingAnItem(String name, String serialNumber, BigDecimal amount) {
		items.add(new Item(name, serialNumber, amount));
	}

	private static void createTheJsonfile() {
		json = gson.toJson(items);
		System.out.println(json);
	}

	// we write the json file to the disk: ./items.json
	private static void writingJsonStringIntoFile() throws IOException {
		String str = json;
		BufferedWriter writer = new BufferedWriter(new FileWriter("./items.json"));
		writer.write(str);
		writer.close();
	}


	// https://codereview.stackexchange.com/questions/63331/efficiently-generating-html-css-table-using-java
	private static void createTheHtmlfile() {

		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table>");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Name");
		sb.append("</th>");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Serial Number");
		sb.append("</th>");
		sb.append("<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Value");
		sb.append("</th>");


		for (Item item : items) {
		    sb.append("<tr>");
		    sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> " + item.getName());
		    sb.append("</td>");
		    sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> " + item.getSerialNumber());
		    sb.append("</td>");
		    sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> " + item.getAmount());
		    sb.append("</td>");
		    
		}
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");

		System.out.println(sb.toString());

}

// we write the Html file to the disk: ./items.html
private static void writingHtmlIntoFile() throws IOException {
	BufferedWriter writer = new BufferedWriter(new FileWriter("./items.html"));
	writer.write(sb.toString());
	writer.close();
}

//https://stackoverflow.com/questions/9825810/generation-of-xml-from-list-of-arrays-of-string-in-java
private static void createTheXmlfile() {
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

//we write the Html file to the disk: ./items.xml
private static void writingXmlIntoFile() throws IOException {
	BufferedWriter writer = new BufferedWriter(new FileWriter("./items.xml"));
	writer.write(sb2.toString());
	writer.close();
}


//https://springhow.com/opencsv/
private static void createTheCsvfile() throws IOException {
	CSVWriter csvWriter = new CSVWriter(new FileWriter("./list.csv"));
	csvWriter.writeNext(new String[] { "Name", "Serial_Number", "Value" });
	for (Item item : items) {
		csvWriter.writeNext(new String[] { item.getName(), item.getSerialNumber(), item.getAmount().toString() });
	}
	csvWriter.close();



}




}
