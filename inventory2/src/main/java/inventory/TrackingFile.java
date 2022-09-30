package inventory;

import java.io.IOException;
import java.util.ArrayList;

public abstract class TrackingFile {

	protected ArrayList<Item> items;

	public TrackingFile(ArrayList<Item> items) {
		this.items = items;
	}

	abstract void createTheFile() throws IOException;

	abstract void writingTheFile() throws IOException;

}
