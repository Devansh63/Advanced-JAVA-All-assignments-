package lab07_Devansh_Agrawal_CS161;

public class HourlyEmployee extends Employee {
	protected int hours;
	protected double wages;

	public HourlyEmployee(String fname, String lname, String comp, double wages, int hours) {
		super(fname, lname, comp);
		this.wages = wages;
		this.hours = hours;
	}

	public String toString() {
		return super.toString() + ". This worker's pay this week was " + df.format(getPay()) + ".";
	}

	public double getPay() {

		if (hours >= 40)
			return wages * hours + 3;
		else
			return wages * hours;

	}

	public String determineBenefits() {
		if (hours >= 40) {
			return fName + " " + lName + " : " + "This worker gets benefits!";
		} else
			return fName + " " + lName + " : " + "No Benefits!";
	}
}
