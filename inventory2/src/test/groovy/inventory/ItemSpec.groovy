package inventory

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification{

	def "new item"(){
		given:
		Item item = new Item()

		expect:
		item.name != null
	}

	@Unroll
	def "item return a name"(){
		given:
		Item item = new Item()

		when:
		item.name = name

		then:
		item.name == name

		where:
		name << ["name", "name 2"]
	}

	def "name cannot be null"(){
		given:
		Item item = new Item()

		when:
		item.name = null

		then:
		Exception e = thrown(Exception)
		e.getMessage() == "Name cannot be null"
	}

	def "name cannot be Empty String"(){
		given:
		Item item = new Item()

		when:
		item.name = ""

		then:
		Exception e = thrown(Exception)
		e.message == "Name cannot be empty"
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
