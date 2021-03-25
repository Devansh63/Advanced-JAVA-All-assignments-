package Lab08_DevanshAgrawalCS161;

import java.util.Scanner;

public class RecursionToolkit {

	public static void main(String[] args) {
		int check = 0;
		do {
			System.out.println("Please choose the option number of you would like to perform (1,2, or 3)");
			System.out.println("(1) Harmonic Series");
			System.out.println("(2) Sum Digits");
			System.out.println("(3) String Cleaning");
			Scanner keyboard = new Scanner(System.in);
			int num = 0;
			double n = 0.0;
			String tem = "";
			num = keyboard.nextInt();

			if (num == 1) {
				System.out.println("Please enter the number till which you would like to run this series");
				n = keyboard.nextDouble();
				System.out.println("harmSer(" + n + ") == " + harmSer(n));
			} else if (num == 2) {
				System.out.println("Please enter that you would like to be summed");
				num = keyboard.nextInt();
				System.out.println("SumDigits(" + num + ") == " + sumDigits(num));
			} else if (num == 3) {
				System.out.println("Please enter the String that you want to be cleared of duplication");
				tem = keyboard.next();
				System.out.println("StrCleaner(" + tem + ") == " + StrCleaner(tem));
			} else
				System.out.println("Wrong Input");
			System.out.println("Do you want to reun a programe again (Y/N)");

			String checking;
			checking = keyboard.next();
			if (checking.equals("Y")) {
				check = 1;
			} else if (checking.equals("y")) {
				check = 1;
			} else if (checking.equals("N")) {
				check = 0;
			} else if (checking.equals("n")) {
				check = 0;
			}
		} while (check == 1);// System.out.println("test");
	}

	public static double harmSer(double n) {

		if (n >= 1) {
			return (1.0 / n) + harmSer(n - 1);
		} else if (n == 1) {
			return 1;
		} else if (n < 0) {
			return 1;
		} else
			return 0;
	}

	public static int sumDigits(int n) {
		if (n <= 0) {
			return 0;
		} else {
			return (n % 10) + sumDigits(n / 10);
		}
	}

	public static String StrCleaner(String S) {

		if (S.length() <= 1) {
			return S;
		}

		if (S.substring(1, 2).equals(S.substring(0, 1))) {
			return StrCleaner(S.substring(1));
		} else {
			return S.substring(0, 1) + StrCleaner(S.substring(1));
		}

	}
}
