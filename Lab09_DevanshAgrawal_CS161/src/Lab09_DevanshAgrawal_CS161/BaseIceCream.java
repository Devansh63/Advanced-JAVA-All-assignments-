package Lab09_DevanshAgrawal_CS161;
/**
 * This is the class I use to display when my index has been emptied.
 * @author devan
 *
 */
public class BaseIceCream implements IceCream{
	
	public IceCream eat() {
		System.out.println("the icecream is gone ");
		return null; 
	}
	public String toString() {
		return "IceCream";
	}
}
