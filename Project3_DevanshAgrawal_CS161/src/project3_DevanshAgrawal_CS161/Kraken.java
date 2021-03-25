package project3_DevanshAgrawal_CS161;

public class Kraken extends SandwichDecorator{
	double Price = 1.0;
	public double calculatePrice() {
		return Price+ s.calculatePrice();
	}

	public Kraken(Sandwich s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Kraken " + s.toString();
	}

}


