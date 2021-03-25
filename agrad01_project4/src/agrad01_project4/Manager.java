package agrad01_project4;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 * Devansh Agrawal
 * CS 160 – 07, Fall Semester 2018
 * Project 4: Parking Management
 * Description. caculates amount and controls the entry and exists of the cars. 
 *
 */
public class Manager {
	Car[] auto;
	Garage garage;
	final double FEE_PER_HOUR = 1.50;
	double feeTotal;
	int manyCars;
	int parkingOperationNumber = 0;

	//Constructor used to initialize
	public Manager(Garage g, int num) {
		garage = g;
		manyCars = num;
	}

	//Used to set a car at a bay in the garage
	public void parkACar() {
		int index = garage.park(new Car());
		if (index != -1) {
			JOptionPane.showMessageDialog(null, "A car is arriving at bay #" + index + "\nGarage displayed on console",
					"Message", JOptionPane.INFORMATION_MESSAGE);
			manyCars++;
			garage.displayState();
		} else if (index == -1) {
			JOptionPane.showMessageDialog(null, "The garage is full.\nThe parking process terminates",
					"Parking Managment", JOptionPane.WARNING_MESSAGE);
			System.out.printf("\nTotal parking fee collected is $%.2f", feeTotal);
			System.exit(0);
		}
	}

	//Randomly makes a car leave
	public void chooseACarToLeave() {

		if (manyCars == 0) {
			JOptionPane.showMessageDialog(null, "The garage is empty.\nThe parking " + "process terminates");
			System.out.println("\nAfter " + parkingOperationNumber + " parking operations the process is terminated");
			System.exit(0);
		} else {
			Random r = new Random();
			int carsinBay = r.nextInt(manyCars) + 1;
			int index = garage.findBayOfCar(carsinBay);
			double elapsedTime = garage.remove(index);
			double fee = (elapsedTime * FEE_PER_HOUR) / 1000.00;
			feeTotal += fee;
			String feeFormated = String.format("%.2f", fee);
			JOptionPane.showMessageDialog(null,
					"The car from bay #" + index + " is leaving the garage\nParking fee paid: $" + feeFormated);
			garage.displayState();
			manyCars--;
		}
	}

	//Randomly decided between making a car enter or exit. also displays the start and end information
	public void processParking(int limit) {
		JOptionPane.showMessageDialog(null,
				"Welcome to the garage parking simulation!" + "\nSee the initial state of the garage on the console",
				"Parking Management", JOptionPane.WARNING_MESSAGE);
		garage.displayState();

		for (int i = 0; i < limit; i++) {
			if (Math.random() < 0.5) {
				parkACar();
			} else {
				chooseACarToLeave();
			}
			parkingOperationNumber++;

		}
		System.out.printf("\nTotal parking fee collected is $%.2f", feeTotal);
		System.out.println("\nAfter " + limit + " parking operations, the process terminates");
		System.exit(0);

	}

}
