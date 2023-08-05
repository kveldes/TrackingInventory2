package inventory

import spock.lang.Specification

class MenuSpec extends Specification {

	Menu menu = new Menu()

	def setup() {
		menu.reset()
	}

	def "When we put 1 Item in a empty App list the list could not be empty list"() {
		given: "an empty list in app and a Item"
		ArrayList<Item> items = new ArrayList<>()
		Item item1 = new Item("Xbox One", "AXB124AXY",BigDecimal.valueOf(399))

		when: "an item put in app list"
		items.add(item1)

		then: "the app list is not empty"
		items.size() != 0
	}

	def "When we put 2 Items in a empty App list the list ought to have 2 items in it"() {
		given: "an empty list in app and 2 Items"
		ArrayList<Item> items = new ArrayList<>()
		Item item1 = new Item("Xbox One", "AXB124AXY",BigDecimal.valueOf(399))
		Item item2 = new Item("Samsung TV", "S40AZBDE4",BigDecimal.valueOf(599.99))

		when: "adding 2 item object in app list"
		items.add(item1)
		items.add(item2)

		then: "list ought to have 2 items in it"
		items.size() == 2
	}

	def "can add an Item to the List"(){
		setup:
		Menu menu = new Menu()
		Item item = new Item("Xbox One", "AXB124AXY",BigDecimal.valueOf(399))

		when:
		menu.addingAnItem(item)

		then:
		menu.getItems().size() == 1
	}

	def "cannot add item to the list if null values are present"(){
		given:
		Menu menu = new Menu()
		menu.items.add(null)

		when:
		menu.getItems()

		then:
		RuntimeException e = thrown()
		e.message == "Null values are not accepted"
	}

	def "cannot add item to the list if empty values are present"(){
		given:
		Menu menu = new Menu()
		menu.items.add("")

		when:
		menu.getItems()

		then:
		RuntimeException e = thrown()
		e.message == "Empty values are not accepted"
	}
}
