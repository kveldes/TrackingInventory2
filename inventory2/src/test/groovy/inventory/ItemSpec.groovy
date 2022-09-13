package inventory

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification{

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
