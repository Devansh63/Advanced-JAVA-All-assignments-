package Lab09_DevanshAgrawal_CS161;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * useD to make the menu i use. THe Driver. gIVES THE USER DIFFERENT OPTIONS ON WHAT TO DO.  
 * @author devan
 *
 */
public class Menu {

	public static void main(String[] args) {
		Menu m = new Menu();
	}
	ArrayList<IceCream> list;
	IceCreamFactory factory;
	public Menu() {
		list = new ArrayList<>();
		factory = new IceCreamFactory();
		boolean controller = true;
		do {
			int entry = 0;
			System.out.println("---Menu---");
			System.out.println("(1) Eat an icecream cone");
			System.out.println("(2) List the icecream cones");
			System.out.println("(3) Add an icecream cone");
			System.out.println("(4) Leave the store");

			Scanner keyboard = new Scanner(System.in);
			entry = keyboard.nextInt();
			switch (entry) {
			case 1:
				System.out.println("Enter the index of the ice cream cone you wish to devour");
				int index = keyboard.nextInt();
				if (index < 0 || index > list.size() || 0 == list.size()) {
					System.out.println("No such cone exists");
					break;
				} else {
					list.set(index, list.get(index).eat());
				}
				break;
			case 2:
				if (list.size() == 0) {
					System.out.println("You have no icecream!");
					break;
				}
				for (int i = 0; i < list.size(); i++) {
					String temp;
					temp = list.get(i).toString();
					System.out.println(temp);
				}
				break;
			case 3:
				ArrayList<String> list2 = new ArrayList<>();
				System.out.println(
						"Enter whatever flavors you like from the supported choices: Chocolate, Blackcurrent, Moosetracks, and Neapolitan");
				System.out.println("Enter q to stop entering flavors");
				String temp;
				boolean a = true;
				do {
					temp = keyboard.nextLine();
					if (temp.toLowerCase().equals("q") && a == true) {
						a = false;
						break;

					} else {
						list2.add(temp.toLowerCase());

					}
				} while (a = true);
				list.add(factory.makeIceCream(list2));
				break;
			case 4:
				System.out.println("Are you sure you want to exit the icecream heaven that you are in(y/n) ");
				String tempp = keyboard.next();
				if (tempp.equals("y") || tempp.equals("Y")) {
					controller = false;
					System.out.println("that's sad :(");
				} else if (tempp.equals("n") || tempp.equals("N")) {
					System.out.println("Good Choice :)");
				}
				break;
			}
		} while (controller == true);

	}
}
