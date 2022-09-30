package inventory

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.file.Files
import java.nio.file.Paths

class JsonFileSpec extends Specification {

	def "Json file is indeed returned and then deleted"(){
		given:
		Files.deleteIfExists(Paths.get("items.json"))
		ArrayList<Item> items = new ArrayList<>()
		items.add(new Item("Xbox One", "AXB124AXY", BigDecimal.TEN))
		JsonFile jsonFile = new JsonFile(items)

		when:
		jsonFile.createTheFile()
		jsonFile.writingTheFile()

		then:
		Files.exists(Paths.get("items.json"))
		Files.delete(Paths.get("items.json"))
	}

    @Unroll
    def "Item gets converted to Json"(){
        given:
		Item item = new Item(name, serialNumber, value as BigDecimal)
        ArrayList<Item> items = new ArrayList<>()
        JsonFile jsonFile = new JsonFile(items)


        when:
		String jsonString = jsonFile.toText(item)

        then:
		jsonString == result

        where:
        name 			| serialNumber 			| value 	|| result
        "Xbox One"		| "AXB124AXY"			| 500		|| '{ "name": "Xbox One", "sn": "AXB124AXY", "value": 500 }'
        "Playstation"	| "APORFDGVD"			| 550		|| '{ "name": "Playstation", "sn": "APORFDGVD", "value": 550 }'
    }
}
