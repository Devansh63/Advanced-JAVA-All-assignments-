package project2_DevanshAgrawal_CS161;

public class Human extends Player {

	Human(int win, int loss, int tie) {
		super(win, loss, tie);
		// TODO Auto-generated constructor stub
	}

	/**
	 * This is the Method that i used to click and change the icon of the title for
	 * the first paper this also makes it the other players turn
	 * 
	 * @param gui
	 * @param i
	 * @param j
	 */
	public void humanplayer1(GUI gui, int i, int j) {

		if (gui.getBoxes()[i][j] == 0 && gui.isPlayercheck()) {
			if (gui.getPaintedTheme().isSelected()) {
				gui.getTiles()[i][j].setIcon(gui.getX1());
				gui.getBoxes()[i][j] = gui.getPLAYER1();
				gui.setFirstPlayer(false);
			} else if (gui.getColorfulTheme().isSelected()) {
				gui.getTiles()[i][j].setIcon(gui.getX2());
				gui.getBoxes()[i][j] = gui.getPLAYER1();
				gui.setFirstPlayer(false);
			}
		}

	}

	/**
	 * This is the Methos i use to do the same for the Second pLayer. This also
	 * changes the turn back to player one
	 * 
	 * @param gui
	 * @param i
	 * @param j
	 */
	public void humanplayer2(GUI gui, int i, int j) {
		if (gui.getBoxes()[i][j] == 0 && gui.isPlayercheck()) {
			if (gui.getPaintedTheme().isSelected()) {
				gui.getTiles()[i][j].setIcon(gui.getO1());
				gui.getBoxes()[i][j] = gui.getPLAYER2();
				gui.setFirstPlayer(true);
			} else if (gui.getColorfulTheme().isSelected()) {
				gui.getTiles()[i][j].setIcon(gui.getO2());
				gui.getBoxes()[i][j] = gui.getPLAYER2();
				gui.setFirstPlayer(true);
			}
		}
	}

	@Override
	/**
	 * Used it for creating the abstract method. It just return the number of wins
	 * loss and tie in the form of a displayable String Ik its a little redundant
	 * but could not see any other way of creating the abstract class
	 */
	public String Statsprinter() {
		String temp = "Number of win:  " + winnum + "\nNumber of losses:  " + lossnum + "\n Number of ties:  " + tienum;
		return temp;
	}

}
