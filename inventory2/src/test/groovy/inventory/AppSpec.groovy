/*.
 * This Spock specification was generated by the Gradle 'init' task.
 */
package inventory

import spock.lang.Specification
import spock.lang.Unroll
import java.io.InputStream


class AppSpec extends Specification {

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
		Item item1 = new Item("Xbox One", "AXB124AXY",BigDecimal.valueOf(399.00))
		Item item2 = new Item("Samsung TV", "S40AZBDE4",BigDecimal.valueOf(599.99))

		when: "adding 2 item object in app list"
		items.add(item1)
		items.add(item2)

		then: "list ought to have 2 items in it"
		items.size() == 2
	}



	//https://stackoverflow.com/questions/31635698/junit-testing-for-user-input-using-scanner
	def "shouldTakeUserInput"() {
		given:
		Item item1 = new Item("Xbox One", "AXB124AXY",BigDecimal.valueOf(399))
		App    appInput= new App();
		String input1 = "Xbox One";
		String input2 = "AXB124AXY";
		String input3 = "BigInteger.valueOf(399)";

		InputStream stream1 = new ByteArrayInputStream(input1.getBytes());
		InputStream stream2 = new ByteArrayInputStream(input2.getBytes());
		InputStream stream3 = new ByteArrayInputStream(input3.getBytes());
		System.setIn(stream1);
		System.setIn(stream2);
		System.setIn(stream3);


		expect:
		appInput.addingItemsFromUserInput() == item1
	}
}

