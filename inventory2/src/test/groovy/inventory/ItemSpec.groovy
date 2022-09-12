package inventory

import spock.lang.Specification

class ItemSpec extends Specification{

	def "can create an Item"(){
		expect:
		new Item();
	}

	def "Item takes a name"(){
		given: "a name"
		String name = "name"

		and: "an item"
		Item item = new Item()

		expect:
		item.setName(name)
	}

	def "item take a serial number"(){
		given:
		String sn = "sn"

		and:
		Item item = new Item()

		expect:
		item.setSerialNumberSn(sn)
	}

	def "Item takes an amount"(){
		given:
		Item item = new Item()

		expect:
		item.setAmount(BigDecimal.valueOf(10))
	}
}
