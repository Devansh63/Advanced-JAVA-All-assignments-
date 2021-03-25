package project3_DevanshAgrawal_CS161;

public class Cucumber extends SandwichDecorator{
	double Price = 1.0;
	public double calculatePrice() {
		return Price+ s.calculatePrice();
	}

	public Cucumber(Sandwich sandwich) {
		super(sandwich);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Cucumber " + s.toString();
	}

}