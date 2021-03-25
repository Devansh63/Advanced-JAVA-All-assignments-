package Lab01_DevanshAgrawalCS161;

import java.text.DecimalFormat;

public class Payroll {

	// (a)
	private static final int SIZE = 7;

	// (b)
	private String[] employeeID = new String[SIZE];
	private static int[] hours = new int[SIZE];
	private static double[] payRates = new double[SIZE];
	private static double[] wages;

	public Payroll() {

		wages = new double[SIZE];
		employeeID[0] = "7623A";
		employeeID[1] = "1182B";
		employeeID[2] = "1182C";
		employeeID[3] = "1337G";
		employeeID[4] = "8910Y";
		employeeID[5] = "2323X";
		employeeID[6] = "6921F";

	}

	public int[] hoursgetter() {
		return hours;
	}

	public double[] wagesgetter() {
		return wages;
	}

	public double[] payRatesgetter() {
		return payRates;
	}

	public String[] employeeIDgetter() {
		return employeeID;
	}

	public void hoursSet(int setter[]) {
		this.hours = ArrayOps.copyintArray(setter);
	}

	public void payRateSet(double setter[]) {
		this.payRates = ArrayOps.copyDoubleArray(setter);

	}
	
	public static void setWages() {
		double pay = 0;
		for (int i = 0; i < SIZE; i++) {
			pay = hours[i] * payRates[i];
			wages[i] = pay;
		}
	}

	public String toString() {
		DecimalFormat FormatSetter= new DecimalFormat("#0.00");
		String temp= "";
		for(int i= 0; i< SIZE; i++) {
		temp+= "EmployeeID: "+ employeeID[i]+ "\r\nGross pay: $"+ FormatSetter.format(wages[i])+ "\r\n\r\n";
		}
		int hourssum=0;
		double paySum=0;
		hourssum=ArrayOps.sumArray(hours);
		paySum = ArrayOps.sumArray(wages);
		String temp2 = "";
		temp2 = "\nSum Hours: " + hourssum +"\nSum Pay: $" + paySum ;
		return "PAYROLL DATA\r\n"
		+ "-----\r\n\n"
		+temp+temp2;
		}


}
