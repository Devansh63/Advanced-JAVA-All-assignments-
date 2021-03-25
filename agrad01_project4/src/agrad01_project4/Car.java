package agrad01_project4;
/*
 * Devansh Agrawal
 * CS 160 – 07, Fall Semester 2018
 * Project 4: Parking Management
 * Description. 
 *
 */

public class Car {
	long timein;

	//Return time of entry.
	public long getTime() {
		return timein;
	}
	
	//Marks time of entry 
	public Car() {
		timein = System.currentTimeMillis();
	}
}
