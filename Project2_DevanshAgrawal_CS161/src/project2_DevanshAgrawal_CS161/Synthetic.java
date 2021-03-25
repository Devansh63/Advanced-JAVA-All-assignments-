package project2_DevanshAgrawal_CS161;

import java.util.Random;

public class Synthetic extends Player {

	Synthetic(int win, int loss, int tie) {
		super(win, loss, tie);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is the code for the randomly tile selecting ai This also turns it back
	 * to player ones turn
	 * 
	 * @param gui
	 */
	public void dumbAI(GUI gui) {

		Random number;

		int number2 = 0;
		int number3 = 0;
		boolean check = true;
		for (int i = 0; i < gui.getTiles().length; i++) {
			for (int k = 0; k < gui.getTiles().length; k++) {
				if (gui.getBoxes()[i][k] == 0) {
					while (check) {
						number = new Random();
						number2 = number.nextInt(3);
						number3 = number.nextInt(3);
						if (gui.getBoxes()[number2][number3] == 0) {
							check = false;
						}
					}
				}
			}
		}
		if (gui.getColorfulTheme().isSelected()) {
			gui.getTiles()[number2][number3].setIcon(gui.getO2());
			gui.getBoxes()[number2][number3] = gui.getPLAYER2();
			gui.setFirstPlayer(true);
		} else if (gui.getPaintedTheme().isSelected()) {
			gui.getTiles()[number2][number3].setIcon(gui.getO1());
			gui.getBoxes()[number2][number3] = gui.getPLAYER2();
			gui.setFirstPlayer(true);
		}
	}

	@Override
	public String Statsprinter() {
		return null;
	}

}
