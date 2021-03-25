package lab07_Devansh_Agrawal_CS161;

public class ContractEmployee extends HourlyEmployee {
	double contract;

	public double getPay() {
		double pay;
		pay = hours * wages + contract;
		return pay;
	}

	public String determineBenefits() {
		return fName + " " + lName + ": Contract workers get no benefits.";
	}

	public ContractEmployee(String fName, String lName, String cName, double contract, double wages, int hours) {
		super(fName, lName, cName, wages, hours);
		this.contract = contract;
	}

}
