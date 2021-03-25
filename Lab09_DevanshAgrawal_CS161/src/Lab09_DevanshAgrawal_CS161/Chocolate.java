package Lab09_DevanshAgrawal_CS161;
/**
 * Adds chocolate scoope or displays that it was eaten 
 * @author devan
 *
 */
public class Chocolate extends IceCreamDecoarator{
	public Chocolate(IceCream IC) {
		super(IC);
	}
	
	public String toString() {
		return "Chocolate " + IC.toString();
	}
	
	public IceCream eat() {
		System.out.println("Chocolate scoope was eaten");
		
		return IC; 
	}
	
}
