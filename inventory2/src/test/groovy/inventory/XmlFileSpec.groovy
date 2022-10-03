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
}
