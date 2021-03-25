package project3_DevanshAgrawal_CS161;

public class Pickle extends SandwichDecorator {
	double Price = 1.0;

	public double calculatePrice() {
		return Price+ s.calculatePrice();
	}

	public Pickle(Sandwich s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Pickle " + s.toString();
	}

}
