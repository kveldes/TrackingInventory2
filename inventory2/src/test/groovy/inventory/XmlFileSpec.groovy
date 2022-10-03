package inventory

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

class XmlFileSpec extends Specification {

	def "XML file is indeed returned and then deleted"(){
		given: 'the list, the added item and XML Class'
		Files.deleteIfExists(Paths.get("items.xml"))
		ArrayList<Item> items = new ArrayList<>()
		items.add(new Item("Xbox One", "AXB124AXY", BigDecimal.TEN))
		XmlFile xmlFile = new XmlFile(items)

		when: 'file is being created'
		xmlFile.createTheFile()
		xmlFile.writingTheFile()

		then: 'check if XML file exists then delete it'
		Files.exists(Paths.get("items.xml"))
		Files.delete(Paths.get("items.xml"))
	}

	def "Item gets converted to XML"(){
		given:
		Item item = new Item("Xbox One", "AXB124AXY", 100 as BigDecimal)
		ArrayList<Item> items = new ArrayList<>()
		XmlFile xmlFile = new XmlFile(items)

		when:
		String xmlString = xmlFile.toText(item)

		then:
		xmlString == expectedContent()
	}

	private String expectedContent() {
		"""<?xml version="1.0" encoding="utf-8"?>
<root>
	<Item id='1'>
		<Name>Xbox One</Name>
		<Serial_Number>AXB124AXY</Serial_Number>
		<Value>100</Value>
	</Item>
</root>
"""
	}
}
