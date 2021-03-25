package project2_DevanshAgrawal_CS161;

import java.awt.Color;

public abstract class Player {
	protected int winnum = 0;
	protected int lossnum = 0;
	protected int tienum = 0;

	/**
	 * constructor
	 * 
	 * @param win
	 * @param loss
	 * @param tie
	 */
	Player(int win, int loss, int tie) {
		winnum = win;
		lossnum = loss;
		tienum = tie;
	}

	/**
	 * retunrs the string that has the values of wins loss and ties in a string
	 * 
	 * @return
	 */
	public abstract String Statsprinter();

}
