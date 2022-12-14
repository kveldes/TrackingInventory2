package inventory

import spock.lang.Specification

class MenuSpec  extends Specification {

	//Section for list
	def "When we put 1 Item in a empty App list the list could not be epty list"() {
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
}
