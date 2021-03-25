package project2_DevanshAgrawal_CS161;

import javax.swing.JFrame;

public class MainMethod extends JFrame {

	/**
	 * Just makes the GUI visible. I think its just easier to manage if i keep the
	 * main in a separate class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		GUI run = new GUI();

		run.setVisible(true);

	}
}
