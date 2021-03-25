package agrad01_project4;

/*
 * Devansh Agrawal
 * CS 160 – 07, Fall Semester 2018
 * Project 4: Parking Management
 * Description.intializes the capacity and the limit. creates a garage object. 
 * randomly assigns the vacancies of each bay
 *creates a manager object and runns the processparking method till limit.
 */
public class Application {

	public static void main(String[] args) {
		int capacity = 15;
		int limit = 15;
		Garage garage = new Garage(capacity);
		int count = 0;
		for (int i = 0; i < capacity; i++) {
			if (Math.random() <= 0.5) {
				garage.setCars(new Car(), i);
				count++;
			}
		}

		Manager manager = new Manager(garage, count);
		manager.processParking(limit);

	}

}
