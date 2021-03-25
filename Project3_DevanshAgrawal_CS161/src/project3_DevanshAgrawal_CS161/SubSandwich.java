package project3_DevanshAgrawal_CS161;

public class SubSandwich implements Sandwich {
	double Price = 2.5;
	public SubSandwich() {
		
		// TODO Auto-generated constructor stub
	}

	public double calculatePrice() {
		return Price;
	}
	
	@Override
	public String toString() {
		return "sub";
	}
	

}
