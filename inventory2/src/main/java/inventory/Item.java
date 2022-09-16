package inventory;

import java.math.BigInteger;

public class Item {

	private String name;
	private String serialNumber;
	private BigInteger amount;

	public Item(String name, String serialNumber, BigInteger amount) {
		nameNotNull(name);
		nameNotEmptyString(name);
		serialNumberNotNull(serialNumber);
		serialNumberNotEmptyString(serialNumber);
		amountNumberNotNull(amount);
		amountNumberNotZero(amount);
		this.name = name;
		this.serialNumber = serialNumber;
		this.amount = amount;
	}


	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;

	}

	public String getSerialNumber() {
		return serialNumber;
	}

	private void nameNotNull(String name) {
		if (name == null) {
			throw new RuntimeException("Name cannot be null");
		}
	}

	private void nameNotEmptyString(String name) {
		if ("".equals(name)) {
			throw new RuntimeException("Name cannot be empty");
		}
	}

	private void serialNumberNotNull(String serialNumber) {
		if (serialNumber == null) {
			throw new RuntimeException("SerialNumber cannot be null");
		}
	}

	private void serialNumberNotEmptyString(String serialNumber) {
		if ("".equals(serialNumber)) {
			throw new RuntimeException("SerialNumber cannot be empty");
		}

	}

	private void amountNumberNotNull(BigInteger amount) {
		if (amount == null) {
			throw new RuntimeException("Amount cannot be null");
		}

	}

	private void amountNumberNotZero(BigInteger amount) {
		if (amount.signum() == 0) {
			throw new RuntimeException("Amount cannot be zero");
		}

	}

}
