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

	def "Item gets converted to HTML"(){
		given:
		Item item = new Item("Xbox One", "AXB124AXY", 100 as BigDecimal)
		ArrayList<Item> items = new ArrayList<>()
		HtmlFile htmlFile = new HtmlFile(items)

		when:
		String htmlString = htmlFile.toText(item)

		then:
		htmlString == expectedContent()
	}

	private String expectedContent() {
		"<html><head></head><table><th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Name</th><th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Serial Number</th><th style = \"background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;\"> Value</th><tr><td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> Xbox One</td><td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> AXB124AXY</td><td style = \"padding: 6px; border: 1px solid #ccc; text-align: left;\"> 100</td></table></body></html>"
	}
}