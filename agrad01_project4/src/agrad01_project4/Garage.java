package agrad01_project4;
/*
 * Devansh Agrawal
 * CS 160 – 07, Fall Semester 2018
 * Project 4: Parking Management
 * Description. 
 *
 */

public class Garage {

	private Car[] cars;

	//initialize cars	
	public Garage(int capacity) {
		cars = new Car[capacity];
	}
	
	//return Cars
	public Car[] getcars() {
		return cars;
	}
	
	//Set the value of Cars at index to auto
	public void setCars(Car auto, int index) {
		cars[index] = auto;
	}
	
	//Checking if the bay is empty
	public boolean isEmpty(int k) {
		return cars[k] == null;
	}

	//Dsiplaying the current situation of all the bays
	public void displayState() {
		System.out.print("\n\n");
		int index = cars.length;
		for (int i = 0; i < index; i++) {
			System.out.print(i + "\t");
		}
		System.out.println(" ");
		for (int i = 0; i < index; i++) {
			if (isEmpty(i)) {
				System.out.print("E\t");
			} else {
				System.out.print("C\t");
			}
		}
	}

	//Counts number of cars, checks if the garage is full and assings auto to the empry lots.  
	public int park(Car auto) {
		int count = 0;
		int index = 0;
		for (int i = 0; i < cars.length; i++) {
			if (!isEmpty(i)) {
				count++;
			}
		}
		if (count == cars.length) {
			return -1;
		} else {
			// return count;
			for (int i = 0; i < cars.length; i++) {
				if (isEmpty(i)) {
					cars[i] = auto;
					index = i;
					break;
				}
			}

		}
		return index;

	}

	//Removes cars and calculates the time of usage of the bay
	public double remove(int index) {
		double elapsedTime = 0;

		long entryTime = cars[index].getTime();
		long exitTime = System.currentTimeMillis();
		elapsedTime = exitTime - entryTime;
		cars[index] = null;

		return elapsedTime;
	}
	
	//Finds and returns the index of the bay
	public int findBayOfCar(int carNumber) {
		int index = -1;
		int carCount = 0;
		for (int i = 0; i < carNumber; i++) {
			if (!isEmpty(i)) {
				carCount++;
				index = i;
				if (carCount == carNumber)
					return index;
			}
		}
		return index;
	}

}
