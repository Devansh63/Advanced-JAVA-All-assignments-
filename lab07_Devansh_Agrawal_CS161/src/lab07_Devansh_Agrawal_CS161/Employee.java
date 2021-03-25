package lab07_Devansh_Agrawal_CS161;

import java.text.DecimalFormat;

public abstract class Employee {
	protected String cName, fName, lName;
	protected DecimalFormat df = new DecimalFormat("$##.##");
	String display;

	public abstract double getPay();

	public abstract String determineBenefits();

	public String toString() {
		display = fName + " " + lName + " from " + cName;
		return display;
	}

	public Employee(String fname, String lname, String cName) {
		this.fName = fname;
		this.lName = lname;
		this.cName = cName;
	}

}
