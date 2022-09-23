package inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HtmlFile extends TrackingFile {
	static StringBuilder sb = new StringBuilder();

	public HtmlFile(ArrayList<Item> items) {
		super(items);
		// TODO Auto-generated constructor stub
	}

	@Override
	void createTheFile() {

		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table>");
		sb.append(
				"<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Name");
		sb.append("</th>");
		sb.append(
				"<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Serial Number");
		sb.append("</th>");
		sb.append(
				"<th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Value");
		sb.append("</th>");

		for (Item item : items) {
			sb.append("<tr>");
			sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> " + item.getName());
			sb.append("</td>");
			sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> "
					+ item.getSerialNumber());
			sb.append("</td>");
			sb.append("<td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> " + item.getAmount());
			sb.append("</td>");

		}
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");

		System.out.println(sb.toString());

	}

	@Override
	void writingTheFile() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("./items.html"));
		writer.write(sb.toString());
		writer.close();

	}

}
