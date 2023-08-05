package inventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Item> items = new ArrayList<>();

	public static void printMenu(String[] options) {
		for (String option : options) {
			System.out.println(option);
		}
		System.out.print("Choose your option : ");
	}

	private static final String[] options = {
			"1- Adding an Item ",
			"2- Create and Print the Json file of Items",
			"3- Create and Print the Html file of Items",
			"4- Create and Print the Xml file of Items",
			"5- Create and Print the Csv file of Items",
			"6- Exit"
	};

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
					BigDecimal amount = scanner.nextBigDecimal();
					Item item = new Item(name, serialNumber, amount);
					addingAnItem(item);
					break;
				case 2:
					TrackingFile tFileJson = new JsonFile(items);
					tFileJson.createTheFile();
					tFileJson.writingTheFile();
					break;
				case 3:
					TrackingFile tFileHtml = new HtmlFile(items);
					tFileHtml.createTheFile();
					tFileHtml.writingTheFile();
					break;
				case 4:
					TrackingFile tFileXml = new XmlFile(items);
					tFileXml.createTheFile();
					tFileXml.writingTheFile();
					break;
				case 5:
					TrackingFile tFileCsv = new CsvFile(items);
					tFileCsv.createTheFile();
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
	public static void addingAnItem(Item item) {
		items.add(item);
	}

	public List<Item> getItems() throws RuntimeException {
		nullValuesProhibited();
		emptyValuesProhibited();
		return items;
	}

	private static void emptyValuesProhibited() {
		if (items.contains("")){
			throw new RuntimeException("Empty values are not accepted");
		}
	}

	private static void nullValuesProhibited() {
		if (items.contains(null)){
			throw new RuntimeException("Null values are not accepted");
		}
	}

	public void reset() {
		items.clear();
	}
}
