package project3_DevanshAgrawal_CS161;
/**
 * This is the Decorator. 
 * @author devansh
 *
 */
public abstract class SandwichDecorator implements Sandwich{
	protected Sandwich s;
	
	public SandwichDecorator(Sandwich sandwich) {
		this.s=sandwich;
	}

	@Override
	public String toString() {
		return s.toString();
	}
	
	public double calculatePrice() {
		return s.calculatePrice();
	}
}
