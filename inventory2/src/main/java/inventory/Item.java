package inventory;

import java.math.BigDecimal;

public class Item {

	public String name;
	public String serialNumber;
	public BigDecimal amount;

	public Item(String name, String serialNumber, BigDecimal amount) {
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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	private void amountNumberNotNull(BigDecimal amount) {
		if (amount == null) {
			throw new RuntimeException("Amount cannot be null");
		}

	}

	private void amountNumberNotZero(BigDecimal amount) {
		if (amount.signum() == 0) {
			throw new RuntimeException("Amount cannot be zero");
		}

	}

	@Override
	public String toString() {
		return String.format("Item [name=%s, serialNumber=%s, amount=%s]", name, serialNumber, amount);
	}

}
