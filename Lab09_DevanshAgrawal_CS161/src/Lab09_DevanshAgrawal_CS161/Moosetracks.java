package Lab09_DevanshAgrawal_CS161;
/**
 * Adds Moosetracks scoope or displays that it was eaten 
 * @author devan
 *
 */
public class Moosetracks extends IceCreamDecoarator{
	public Moosetracks(IceCream IC) {
		super(IC);
	}
	
	public String toString() {
		return "Moose tracks " + IC.toString();
	}
	
	public IceCream eat() {
		System.out.println("Moose tracks scoope was eaten");
		return IC; 
	}
	
}