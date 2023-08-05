package inventory

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification {

	@Unroll
	def "Item return a Name and a Serial number and a Amount"(){
		given:
		Item item = new Item(name, serialNumber, amount)

		expect:
		item.name == name
		item.serialNumber == serialNumber
		item.amount == amount

		where:
		name << ["name", "name 2"]
		serialNumber << ["sn1", "sn2"]
		amount = BigDecimal.valueOf(10)
	}

	def "Name cannot be null"(){
		when:
		new Item(null,"sn1",BigDecimal.TEN)

		then:
		Exception e = thrown(Exception)
		e.message == "Name cannot be null"
	}

	def "Name cannot be empty string"(){
		when:
		new Item("","sn1",BigDecimal.TEN)

		then:
		Exception e = thrown(Exception)
		e.message == "Name cannot be empty"
	}

	def "Serial number cannot be null"(){
		when:
		new Item("name",null, BigDecimal.TEN)

		then:
		Exception e = thrown(Exception)
		e.message == "SerialNumber cannot be null"
	}

	def "Serial number cannot be empty string"(){
		when:
		new Item("name","",BigDecimal.TEN)

		then:
		Exception e = thrown(Exception)
		e.message == "SerialNumber cannot be empty"
	}

	def "Amount cannot be null"(){
		when:
		new Item("name","sn1",null)

		then:
		Exception e = thrown(Exception)
		e.message == "Amount cannot be null"
	}

	def "Amount cannot be zero"(){
		when:
		new Item("name","sn1",BigDecimal.ZERO)

		then:
		Exception e = thrown(Exception)
		e.message == "Amount cannot be zero"
	}
}
