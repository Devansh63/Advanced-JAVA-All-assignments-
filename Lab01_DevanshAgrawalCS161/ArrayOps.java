package Lab01_DevanshAgrawalCS161;

import java.util.Scanner;

public class ArrayOps {

	Scanner keyboard = new Scanner(System.in);

	// (a).a.
	public static int[] copyintArray(int[] arr) {
		int[] arrnew = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrnew[i] = arr[i];
		}
		return arrnew;
	}

	// (a).b.
	public static double[] copyDoubleArray(double[] arr) {
		double[] arrnew = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrnew[i] = arr[i];
		}
		return arrnew;
	}

	// (a).c.
	public static int sumArray(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum = sum + val;
		}
		return sum;
	}

	public static double sumArray(double[] arr) {
		double sum = 0;
		for (double val : arr) {
			sum = sum + val;
		}
		return sum;
	}

}
