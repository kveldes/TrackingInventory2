package inventory;

import java.math.BigDecimal;

public class Item {

	private String name;

	public Item(String name) {
		nameNotNull(name);
		nameNotEmptyString(name);
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;

	}



	public String getName() {
		return name;
	}

	private void nameNotEmptyString(String name) {
		if ("".equals(name)) {
			throw new RuntimeException("Name cannot be empty");
		}
	}

	private void nameNotNull(String name) {
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
	}

}
