package lab02_DevanshAgrawalCS161;

import java.io.IOException;
import java.util.Scanner;

public class Mainmethod {

	public static void main(String[] args) throws IOException {
		ProgressReport pr = new ProgressReport();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter file name to save the report: (Report.txt)");
		String fileName = keyboard.nextLine();
		pr.readInputFile();
		for (int i = 1; i <= pr.getStudent().length; i++) {
			pr.sortSection(i);
		}
		pr.saveReport(fileName);
		pr.generatetReport(fileName);
		System.out.println(" ");
		System.out.print("Enter the section number ");
		int section = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println(" ");
		System.out.print("Enter a name for this section: ");
		String name = keyboard.nextLine();
		if (pr.binarySearh(section, name) == null) {
			System.out.println("There is no information of this student");
		} else {
			System.out.println(pr.binarySearh(section, name).toString());
		}
		keyboard.close();
		System.exit(0);
	}

}
