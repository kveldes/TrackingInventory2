package inventory

import org.json.simple.JSONObject

import spock.lang.Specification

class JsonRepositorySpec extends Specification{
	def "In JsonRepository class the Item object cannot be null"(){
		when:
		JsonRepository json = new JsonRepository(null)

		then:
		Exception e = thrown(Exception)
		e.message == "Item object cannot be null"
	}

	def "The jsonObject object cannot be empty"(){
		given:
		JSONObject jsonObject = new JSONObject();
		Item item = new Item(name, serialNumber, amount)

		when:
		jsonObject.put("Name" ,item.name)
		jsonObject.put("Serial Number", item.serialNumber)
		jsonObject.put("Value",item.amount)

		then:
		jsonObject.size() != 0
		Exception e = thrown(Exception)
		e.message == "JsonOject cannot be null"

		where:
		name = "Xbox One"
		serialNumber = "AXB12AXY"
		amount = 399
	}
}