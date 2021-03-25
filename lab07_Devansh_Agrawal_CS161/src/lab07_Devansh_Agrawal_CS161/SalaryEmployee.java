package lab07_Devansh_Agrawal_CS161;

public class SalaryEmployee extends Employee {
	double salary;

	public SalaryEmployee(String fname, String lname, String cName, double salary) {
		super(fname, lname, cName);
		this.salary = salary;
	}

	public String determineBenefits() {
		return fName + " " + lName + ": This employee has a standard company health insurance policy.";
	}

	public double getPay() {
		return salary;
	}

	public String toString() {
		return super.toString() + " This worker's salary is  " + df.format(salary);
	}

}
