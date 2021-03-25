package Lab09_DevanshAgrawal_CS161;
/**
 * Adds Neapolitan scoope or displays that it was eaten 
 * @author devan
 *
 */
public class Neapolitan extends IceCreamDecoarator{
	public Neapolitan(IceCream IC) {
		super(IC);
	}
	
	public String toString() {
		return "Neapolitan " + IC.toString();
	}
	
	public IceCream eat() {
		System.out.println("Neapolitan scoope was eaten");
		return IC; 
	}
	
}
