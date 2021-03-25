package lab07_Devansh_Agrawal_CS161;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static void menu(ArrayList<Employee> list) {

		int number;

		System.out.println("Please select an option  :");
		System.out.println("1) Add employee");
		System.out.println("2) List Employees");
		System.out.println("3) List benefit Status");
		System.out.println("4) Quiit");

		Scanner keyboard = new Scanner(System.in);

		number = keyboard.nextInt();
		keyboard.nextLine();

		switch (number) {

		case 1: {
			System.out.println("Enter First Name : ");
			String fName = keyboard.nextLine();

			System.out.println("Enter Last Name : ");
			String lName = keyboard.nextLine();

			System.out.println("Employeed at : ");
			String cName = keyboard.nextLine();

			System.out.println("Please select an option  :");

			System.out.println("1) Hourly Employee");
			System.out.println("2) Contract employee");
			System.out.println("3) Salay Employee");

			int type = keyboard.nextInt();

			if (type == 1) {

				System.out.println("Enter the per hourly Wage : ");
				double wages = keyboard.nextDouble();

				System.out.println("Number of Hours worked : ");
				int hours = keyboard.nextInt();

				HourlyEmployee hourlyemployee = new HourlyEmployee(fName, lName, cName, wages, hours);

				list.add(hourlyemployee);
			}

			if (type == 2) {

				System.out.println("Contract Fee : ");
				double contract = keyboard.nextDouble();

				System.out.println("Enter the per hourly Wage : ");
				double wages = keyboard.nextDouble();

				System.out.println("Number of Hours worked : ");
				int hours = keyboard.nextInt();

				ContractEmployee contractemployee = new ContractEmployee(fName, lName, cName, contract, wages, hours);

				list.add(contractemployee);
			}
			if (type == 3) {

				System.out.println("Enter the Employees Salary : ");
				double salary = keyboard.nextDouble();

				SalaryEmployee salaryemployee = new SalaryEmployee(fName, lName, cName, salary);
				list.add(salaryemployee);
			}

		}
			break;

		case 2:

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
			break;

		case 3: {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).determineBenefits());
			}

		}
			break;
		case 4:
			System.exit(0);
			break;
		}
		menu(list);
	}

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		menu(list);

	}
}
