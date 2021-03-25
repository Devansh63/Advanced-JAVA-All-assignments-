package project3_DevanshAgrawal_CS161;

public class DeliSandwich implements Sandwich {
	double Price = 2.5;
	
	public DeliSandwich() {
		
		// TODO Auto-generated constructor stub
	}

	public double calculatePrice() {
		return Price;
	}
	
	@Override
	public String toString() {
		return "deli sandwich";
	}
	

}
