package project3_DevanshAgrawal_CS161;

import java.util.ArrayList;

/**
 * the ckass that essentially makes the sandwich, checked what type of sandwich
 * was selected and then checks the toppings then accordingly calls their
 * methods.
 * 
 * @author devansh
 *
 */
public class SandwichFactory {

	public Sandwich makeASandwich(String sub, ArrayList<String> toppings) {
		Sandwich sandwich = null;
		;
		if (sub.equals("Deli")) {
			sandwich = new DeliSandwich();
		} else if (sub.equals("Sub")) {
			sandwich = new SubSandwich();
		} else if (sub.equals("Wrap")) {
			sandwich = new Wrap();
		}
		for (int i = 0; i < toppings.size(); i++) {
			if (toppings.get(i).equals("Pepper")) {
				sandwich = new Pepper(sandwich);
			} else if (toppings.get(i).equals("Cucumber")) {
				sandwich = new Cucumber(sandwich);
			} else if (toppings.get(i).equals("Pickle")) {
				sandwich = new Pickle(sandwich);
			} else if (toppings.get(i).equals("Tomato")) {
				sandwich = new Tomato(sandwich);
			} else if (toppings.get(i).equals("Ham")) {
				sandwich = new Ham(sandwich);
			} else if (toppings.get(i).equals("Turkey")) {
				sandwich = new Turkey(sandwich);
			} else if (toppings.get(i).equals("Kraken")) {
				sandwich = new Kraken(sandwich);
			}
		}

		return sandwich;
	}
}
