package lab02_DevanshAgrawalCS161;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class ProgressReport {

	
	Student student[][];
	//Constructor
	ProgressReport() {
	}

	//Return Students
	public Student[][] getStudent() {
		return student;
	}

	//Sets the Elements of Students.
	public void setStudent(Student[][] student) {
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				this.student[i][j] = student[i][j];
			}
		}
	}

	//Reads the elements of input from the input file
	public void readInputFile() throws IOException {
		File input = new File("DATA.txt");
		Scanner keyboard = new Scanner(input);

		int NumberOfSections;
		int NumberOfStudents;
		int scores[] = new int[5];
		NumberOfSections = keyboard.nextInt();
		student = new Student[NumberOfSections][];

		for (int i = 0; i < NumberOfSections; i++) {
			NumberOfStudents = keyboard.nextInt();
			student[i] = new Student[NumberOfStudents];

			for (int j = 0; j < NumberOfStudents; j++) {
				student[i][j] = new Student();
				student[i][j].setname(keyboard.next());

				for (int k = 0; k < 5; k++) {
					scores[k] = keyboard.nextInt();
				}

				student[i][j].setscores(scores);
			}
		}

		keyboard.close();

	}

	//Selection sort
	public void sortSection(int section) {
		int n = student[section - 1].length;

		for (int i = 0; i < n - 1; i++) {
			int smallesti = i;
			for (int j = i ; j < n; j++) {
				if (student[section - 1][j].compareTo(student[section - 1][smallesti]) < 0) 
					smallesti = j;
			}
					Student temp = student[section - 1][smallesti];
					student[section - 1][smallesti] = student[section - 1][i];
					student[section - 1][i] = temp;
				
			
		}
	
	}

	//saves the data to the report file
	public void saveReport(String filename) throws IOException {
		File file = new File(filename);
		Scanner keyboard = new Scanner(file);

		while (keyboard.hasNext()) {
			System.out.println(keyboard.nextLine());
		}

		keyboard.close();
	}

	//Displays the results on the console
	public void generatetReport(String filename) throws IOException {
		PrintWriter file = new PrintWriter(filename);

		file.print("Progress Report");
		
		for (int i = 0; i < student.length; i++) {
			
	
			file.printf("\r\n\r\n%s %d\t%s\t%s\r\n", "Section", i + 1, "Avg", "Grade");

			for (int j = 0; j < student[i].length; j++) {
				file.printf("%s\t\t%.1f\t%c\r\n", student[i][j].getname(), student[i][j].getAverage(),
						student[i][j].getGrade());
			}
		}
		file.close();

	}

	//Binary search 
	public Student binarySearh(int section, String searchName) {
		if (section < 1 || section > student.length) {
			return null;
		}

		int lowerlimit = 0;
		int upperlimit = student[section - 1].length - 1;

		while (upperlimit >= lowerlimit) {
			int middle = (lowerlimit + upperlimit) / 2;

			if (student[section - 1][middle].getname().equals(searchName)) {
				return student[section - 1][middle];
			}

			else if (student[section - 1][middle].getname().compareTo(searchName) > 1) {
				upperlimit = middle - 1;
			}

			else
				lowerlimit = middle + 1;
		}

		return null;
	}

}
