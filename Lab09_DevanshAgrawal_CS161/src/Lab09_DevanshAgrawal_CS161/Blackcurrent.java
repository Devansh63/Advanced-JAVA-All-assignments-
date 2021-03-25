package Lab09_DevanshAgrawal_CS161;
/**
 * Adds Blackcurrent scoope or displays that it was eaten 
 * @author devan
 *
 */
public class Blackcurrent extends IceCreamDecoarator{
	public Blackcurrent(IceCream IC) {
		super(IC);
	}
	
	public String toString() {
		return "Blackcurrent " + IC.toString();
	}
	
	public IceCream eat() {
		System.out.println("Blackcurrent scoope was eaten");
		return IC; 
	}
	
}
