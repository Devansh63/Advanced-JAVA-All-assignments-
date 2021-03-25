package project2_DevanshAgrawal_CS161;

import java.awt.Color;

import javax.swing.JButton;

public class JTile extends JButton {
	/**
	 * It makes the Title visible
	 */

	public JTile() {

		setVisible(true);

	}

	/**
	 * This is the class that changes the color of the winning 3 titles to green, I
	 * first had it repeated in the GUI class but then brought it here so that i can
	 * just pass it the values and use it again.
	 * 
	 * @param gui
	 * @param player
	 */
	public void winline(GUI gui, int player) {
		if ((gui.getBoxes()[0][0] == player && gui.getBoxes()[0][1] == player && gui.getBoxes()[0][2] == player)) {
			gui.getTiles()[0][0].setBackground(Color.GREEN);
			gui.getTiles()[0][1].setBackground(Color.GREEN);
			gui.getTiles()[0][2].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[1][0] == player && gui.getBoxes()[1][1] == player
				&& gui.getBoxes()[1][2] == player)) {
			gui.getTiles()[1][0].setBackground(Color.GREEN);
			gui.getTiles()[1][1].setBackground(Color.GREEN);
			gui.getTiles()[1][2].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[2][0] == player && gui.getBoxes()[2][1] == player
				&& gui.getBoxes()[2][2] == player)) {
			gui.getTiles()[2][0].setBackground(Color.GREEN);
			gui.getTiles()[2][1].setBackground(Color.GREEN);
			gui.getTiles()[2][2].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[0][1] == player && gui.getBoxes()[1][1] == player
				&& gui.getBoxes()[2][1] == player)) {
			gui.getTiles()[0][1].setBackground(Color.GREEN);
			gui.getTiles()[1][1].setBackground(Color.GREEN);
			gui.getTiles()[2][1].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[0][0] == player && gui.getBoxes()[1][0] == player
				&& gui.getBoxes()[2][0] == player)) {
			gui.getTiles()[0][0].setBackground(Color.GREEN);
			gui.getTiles()[1][0].setBackground(Color.GREEN);
			gui.getTiles()[2][0].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[0][2] == player && gui.getBoxes()[1][2] == player
				&& gui.getBoxes()[2][2] == player)) {
			gui.getTiles()[0][2].setBackground(Color.GREEN);
			gui.getTiles()[1][2].setBackground(Color.GREEN);
			gui.getTiles()[2][2].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[0][0] == player && gui.getBoxes()[1][1] == player
				&& gui.getBoxes()[2][2] == player)) {
			gui.getTiles()[0][0].setBackground(Color.GREEN);
			gui.getTiles()[1][1].setBackground(Color.GREEN);
			gui.getTiles()[2][2].setBackground(Color.GREEN);
		} else if ((gui.getBoxes()[0][2] == player && gui.getBoxes()[1][1] == player
				&& gui.getBoxes()[2][0] == player)) {
			gui.getTiles()[0][2].setBackground(Color.GREEN);
			gui.getTiles()[1][1].setBackground(Color.GREEN);
			gui.getTiles()[2][0].setBackground(Color.GREEN);
		}
	}
}
