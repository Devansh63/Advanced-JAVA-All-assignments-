package Lab09_DevanshAgrawal_CS161;

import java.util.ArrayList;
/**
 *the icecream factory class is used by me to check if the entered flavor is repeated or available.  
 * @author devan
 *
 */
public class IceCreamFactory {

	public IceCream makeIceCream(ArrayList<String> List) {
		String[] flavourcheck = new String[] { "chocolate", "blackcurrent", "moosetracks", "neapolitan" }; // website i got the weird flavors from https://www.frozendessertsupplies.com/p-1014-americas-top-10-favorite-ice-cream-flavors-and-the-best-toppings-to-go-with-them.aspx

		for (int i = 0; i < List.size(); i++) {  // loop to check if the entered flavors are repeated 
			boolean controller = false;

			for (int j = 0; j < flavourcheck.length; j++) {
				if (List.get(i).equals(flavourcheck[j]) && controller == false) {
					controller = true;
				}
			}
			if (controller == false) {
				List.remove(i);
				i--;
			}

		}

		IceCream IC = new BaseIceCream();    //  To check is the entered flavor is valid. THis how to do this if a hundread flavors were asked 
		boolean c = false, b = false, m = false, n = false;
		for (int i = List.size() - 1; i >= 0; i--) {
			if (List.get(i).equals("chocolate") && c == false) {  
				IC = new Chocolate(IC);
				c = true;
			}
			if (List.get(i).equals("blackcurrent") && b == false) {
				IC = new Blackcurrent(IC);
				b = true;
			}
			if (List.get(i).equals("moosetracks") && m == false) {
				IC = new Moosetracks(IC);
				m = true;
			}
			if (List.get(i).equals("neapolitan") && n == false) {
				IC = new Neapolitan(IC);
				n = true;
			}
		}
		return IC;
	}
}
