package inventory

import spock.lang.Specification
import spock.lang.Unroll

class ItemSpec extends Specification{


	@Unroll
	def "item return a Name and a Serial number and a Amount"(){
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

	def "name  cannot be null"(){
		when:
		Item item = new Item(null,"sn1",10)

		then:
		Exception e = thrown(Exception)
		e.message == "Name cannot be null"
	}

	def "name cannot be Empty String"(){
		when:
		Item item = new Item("","sn1",10)

		then:
		Exception e = thrown(Exception)
		e.message == "Name cannot be empty"
	}

	def "serialNumber  cannot be null"(){
		when:
		Item item = new Item("name",null,10)

		then:
		Exception e = thrown(Exception)
		e.message == "SerialNumber cannot be null"
	}

	def "serialNumber cannot be empty String"(){
		when:
		Item item = new Item("name","",10)

		then:
		Exception e = thrown(Exception)
		e.message == "SerialNumber cannot be empty"
	}

	def "amount  cannot be null"(){
		when:
		Item item = new Item("name","sn1",null)

		then:
		Exception e = thrown(Exception)
		e.message == "Amount cannot be null"
	}

	def "amount  cannot be zero"(){
		when:
		Item item = new Item("name","sn1",0)

		then:
		Exception e = thrown(Exception)
		e.message == "Amount cannot be zero"
	}
}
