package inventory

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

class HtmlFileSpec extends Specification {

	def "HTML file is indeed returned and then deleted"(){
		given: 'the list, the added item and HTML Class'
		Files.deleteIfExists(Paths.get("items.html"))
		ArrayList<Item> items = new ArrayList<>()
		items.add(new Item("Xbox One", "AXB124AXY", BigDecimal.TEN))
		HtmlFile htmlFile = new HtmlFile(items)

		when: 'file is being created'
		htmlFile.createTheFile()
		htmlFile.writingTheFile()

		then: 'check if HTML file exists then delete it'
		Files.exists(Paths.get("items.html"))
		Files.delete(Paths.get("items.html"))
	}
}
