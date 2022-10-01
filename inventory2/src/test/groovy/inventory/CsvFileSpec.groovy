package inventory

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

class CsvFileSpec extends Specification {

	def "CSV file is indeed returned and then deleted"(){
		given: 'the list, the added item and CSV Class'
		Files.deleteIfExists(Paths.get("list.csv"))
		ArrayList<Item> items = new ArrayList<>()
		items.add(new Item("Xbox One", "AXB124AXY", BigDecimal.TEN))
		CsvFile csvFile = new CsvFile(items)

		when: 'file is being created'
		csvFile.createTheFile()

		then: 'check if csv file exists then delete it'
		Files.exists(Paths.get("list.csv"))
		Files.delete(Paths.get("list.csv"))
	}

    def "Item gets converted to Csv"(){
        given:
		ArrayList<Item> items = [
				new Item("Xbox One", "AXB124AXY", 100 as BigDecimal),
				new Item("Playstation", "APORFDGVD", 500 as BigDecimal),
				new Item("Sony Bravia", "SRTYHUHKO", 1000 as BigDecimal),
		]
		CsvFile csvFile = new CsvFile(items)

        when:
		String csvString = csvFile.toText()

        then:
		csvString == "Xbox One,AXB124AXY,100\nPlaystation,APORFDGVD,500\nSony Bravia,SRTYHUHKO,1000"
    }
}
