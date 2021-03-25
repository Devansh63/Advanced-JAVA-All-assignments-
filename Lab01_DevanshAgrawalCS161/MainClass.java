package Lab01_DevanshAgrawalCS161;

import java.util.*;
import java.io.*;


public class MainClass {

	public static void main(String[] args) throws IOException {
	
		int[] array1 = new int[7];
		double[] array2 = new double[7];
		
		Payroll classinstance = new Payroll();
		String[] EID = classinstance.employeeIDgetter();
		Scanner keyboard = new Scanner(System.in);
		int time;
		double Rate;
		int SIZE = 7;
		for(int i=0;i<SIZE;i++) {
			System.out.print("Enter the hours worked by employee ID " + EID[i] + ":");
			time=keyboard.nextInt();
			System.out.print("\n");
			array1[i]=time;
			System.out.print("Enter the hourly pay rate for employee ID " + EID[i] + ":");
			Rate = keyboard.nextDouble();
			System.out.print("\n");
			array2[i]= Rate;
		}
		classinstance.hoursSet(array1);
		classinstance.payRateSet(array2);
		Payroll.setWages();
		PrintWriter outputFile = new PrintWriter("payrollResults.txt");
		outputFile.write(classinstance.toString());
		outputFile.close();
		keyboard.close();
		
		
		
		
	}

}
