package project2_DevanshAgrawal_CS161;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GUI extends JFrame {

//INtializing most of the variable 
	private boolean firstPlayer = true;
	private JMenuBar menuBar;
	private boolean playercheck;
	private GUI gui = this;
	private JMenu color;
	private JMenu file;
	private JMenuItem close;
	private JMenuItem records;
	private JMenuItem statistics;
	private JMenuItem loadrecords;
	private JMenuItem restart;
	private JMenuItem deleterecords;
	private JRadioButton colorxo;
	private JRadioButton blackxo;
	private JRadioButton BackgroundColor1;
	private JRadioButton BackgroundColor2;
	private JRadioButton BackgroundColor3;
	private JRadioButton secondplayer;
	private JRadioButton aisecondplayer;
	private ImageIcon x1;
	private ImageIcon o1;
	private ImageIcon x2;
	private ImageIcon o2;
	private final int PLAYER1 = 3;
	private final int PLAYER2 = 6;
	private JTile[][] tiles;
	private int[][] boxes;
	private int winnum = 0;
	private int lossnum = 0;
	private int tienum = 0;

	GUI() {

		setSize(1000, 1000);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("tic tac toe");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(3, 3));
		tiles = new JTile[3][3];
		boxes = new int[3][3];

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				boxes[i][j] = 0;

			}
		}
		for (int i = 0; i < tiles.length; i++) {
			for (int k = 0; k < tiles.length; k++) {
				tiles[i][k] = new JTile();
				add(tiles[i][k]);
				tiles[i][k].setBackground(Color.CYAN);

			}

		}

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		file = new JMenu("Menu");
		file.setMnemonic(KeyEvent.VK_M);
		menuBar.add(file);
		restart = new JMenuItem("New Game");
		restart.setMnemonic(KeyEvent.VK_N);
		file.add(restart);
		statistics = new JMenuItem("Stats");
		statistics.setMnemonic(KeyEvent.VK_S);
		file.add(statistics);
		records = new JMenuItem("Records");
		records.setMnemonic(KeyEvent.VK_R);
		file.add(records);
		loadrecords = new JMenuItem("Load Records");
		loadrecords.setMnemonic(KeyEvent.VK_L);
		file.add(loadrecords);
		deleterecords = new JMenuItem("Delete Records");
		deleterecords.setMnemonic(KeyEvent.VK_D);
		file.add(deleterecords);
		close = new JMenuItem("Exit");
		close.setMnemonic(KeyEvent.VK_E);
		file.add(close);

		color = new JMenu("Aesthetic");
		color.setMnemonic(KeyEvent.VK_A);
		aisecondplayer = new JRadioButton("VS Dumb AI");
		secondplayer = new JRadioButton("VS Dumb Friend");
		file.add(aisecondplayer);
		file.add(secondplayer);
		menuBar.add(color);

		colorxo = new JRadioButton("Black X & O");
		blackxo = new JRadioButton("Colored X & O");
		BackgroundColor1 = new JRadioButton("Lght BLue Background ");
		BackgroundColor2 = new JRadioButton("Yellow Background ");
		BackgroundColor3 = new JRadioButton("White Background ");
		color.add(colorxo);
		color.add(blackxo);
		color.add(BackgroundColor1);
		color.add(BackgroundColor2);
		color.add(BackgroundColor3);
		blackxo.setSelected(true);
		BackgroundColor1.setSelected(true);
		aisecondplayer.setSelected(true);
		JTileListener jtl = new JTileListener();

		for (int i = 0; i < tiles.length; i++) {
			for (int k = 0; k < tiles.length; k++) {
				tiles[i][k].addActionListener(jtl);

			}

		}

		RadioButtonListener buttonListener = new RadioButtonListener();
		colorxo.addActionListener(buttonListener);
		blackxo.addActionListener(buttonListener);
		BackgroundColor1.addActionListener(buttonListener);
		BackgroundColor2.addActionListener(buttonListener);
		BackgroundColor3.addActionListener(buttonListener);
		aisecondplayer.addActionListener(buttonListener);
		secondplayer.addActionListener(buttonListener);

		MenuItemListener fileListener = new MenuItemListener();
		restart.addActionListener(fileListener);
		statistics.addActionListener(fileListener);
		close.addActionListener(fileListener);
		records.addActionListener(fileListener);
		loadrecords.addActionListener(fileListener);
		deleterecords.addActionListener(fileListener);

		ButtonGroup xogroup = new ButtonGroup();
		xogroup.add(colorxo);
		xogroup.add(blackxo);
		ButtonGroup BGgroup = new ButtonGroup();
		BGgroup.add(BackgroundColor1);
		BGgroup.add(BackgroundColor2);
		BGgroup.add(BackgroundColor3);
		ButtonGroup VSgroup = new ButtonGroup();
		VSgroup.add(secondplayer);
		VSgroup.add(aisecondplayer);
		x1 = makeIcon("newx2.png", 300, 300);
		o1 = makeIcon("o1.png", 300, 300);
		x2 = makeIcon("newx.png", 300, 300);
		o2 = makeIcon("o2.png", 300, 300);

	}

	// Getters and setters
	public JTile[][] getTiles() {
		return tiles;
	}

	public void setTiles(JTile[][] tiles) {
		this.tiles = tiles;
	}

	public int[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(int[][] boxes) {
		this.boxes = boxes;
	}

	public JRadioButton getColorfulTheme() {
		return colorxo;
	}

	public void setColorfulTheme(JRadioButton colorfulTheme) {
		this.colorxo = colorfulTheme;
	}

	public JRadioButton getPaintedTheme() {
		return blackxo;
	}

	public void setPaintedTheme(JRadioButton paintedTheme) {
		this.blackxo = paintedTheme;
	}

	public ImageIcon getO1() {
		return o1;
	}

	public void setO1(ImageIcon o1) {
		this.o1 = o1;
	}

	public ImageIcon getX1() {
		return x1;
	}

	public void setX1(ImageIcon x1) {
		this.x1 = x1;
	}

	public ImageIcon getO2() {
		return o2;
	}

	public void setO2(ImageIcon o2) {
		this.o2 = o2;
	}

	public ImageIcon getX2() {
		return x2;
	}

	public void setX2(ImageIcon x2) {
		this.x2 = x2;
	}

	public int getPLAYER1() {
		return PLAYER1;
	}

	public int getPLAYER2() {
		return PLAYER2;
	}

	public boolean isFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(boolean firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public boolean isPlayercheck() {
		return playercheck;
	}

	public void setPlayercheck(boolean playercheck) {
		this.playercheck = playercheck;
	}

	// Method to take stats from Human and give it to the printer in GUI
	private String winlossnum(int win, int loss, int tie) {
		Human temp = new Human(win, loss, tie);
		String output = temp.Statsprinter();
		return output;

	}

	// Method to set image icon and scale it to its tile
	private ImageIcon makeIcon(String img, int i, int j) {

		ImageIcon ico = new ImageIcon(img);
		Image image = ico.getImage();
		Image newimg = image.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);

	}

// Method to count the number of tie in the game
	public void tiechecking() {
		int zero = 0;
		int check = 0;
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes[i].length; j++) {

				if (boxes[i][j] != zero) {
					check++;
				}
			}
		}
		if (check == 9) {
			tienum++;

		}
	}

	// Method to determine the winner of the game.
	public boolean Winner(int num) {
		if ((boxes[0][0] == num && boxes[0][1] == num && boxes[0][2] == num)
				|| (boxes[1][0] == num && boxes[1][1] == num && boxes[1][2] == num)
				|| (boxes[2][0] == num && boxes[2][1] == num && boxes[2][2] == num)
				|| (boxes[0][1] == num && boxes[1][1] == num && boxes[2][1] == num)
				|| (boxes[0][0] == num && boxes[1][0] == num && boxes[2][0] == num)
				|| (boxes[0][2] == num && boxes[1][2] == num && boxes[2][2] == num)
				|| (boxes[0][0] == num && boxes[1][1] == num && boxes[2][2] == num)
				|| (boxes[0][2] == num && boxes[1][1] == num && boxes[2][0] == num))
			return true;
		else
			return false;

	}

	// The listener for all the radio buttons
	private class RadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// to set the X and O to the Colored X O
			if (e.getSource() == colorxo) {
				for (int i = 0; i < tiles.length; i++) {
					for (int j = 0; j < tiles[i].length; j++) {
						if (boxes[i][j] == PLAYER1) {
							tiles[i][j].setIcon(x2);
						} else if (boxes[i][j] == PLAYER2) {
							tiles[i][j].setIcon(o2);
						}

					}
				}

			}
			// to set the X and O to the Black X O
			if (e.getSource() == blackxo) {
				for (int i = 0; i < tiles.length; i++) {
					for (int j = 0; j < tiles[i].length; j++) {
						if (boxes[i][j] == PLAYER1) {
							tiles[i][j].setIcon(x1);
						} else if (boxes[i][j] == PLAYER2) {
							tiles[i][j].setIcon(o1);
						}

					}
				}

			}
			// TO change the Background color to CYAN
			if (e.getSource() == BackgroundColor1) {

				for (int i = 0; i < tiles.length; i++) {
					for (int k = 0; k < tiles.length; k++) {

						tiles[i][k].setBackground(Color.CYAN);

					}

				}
			}
			// TO change the Background color to Yellow
			if (e.getSource() == BackgroundColor2) {

				for (int i = 0; i < tiles.length; i++) {
					for (int k = 0; k < tiles.length; k++) {

						tiles[i][k].setBackground(Color.YELLOW);

					}

				}
			}
			// TO change the Background color to WHITE
			if (e.getSource() == BackgroundColor3) {

				for (int i = 0; i < tiles.length; i++) {
					for (int k = 0; k < tiles.length; k++) {

						tiles[i][k].setBackground(Color.WHITE);

					}

				}
			}

		}

	}

	private class JTileListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			/**
			 * If statement for two human players. checks if its the first players turn
			 * executes the click and then changes the turn to player2. then a loop runs
			 * till some one wins or we have a tie
			 */
			if (Winner(PLAYER1) == false && Winner(PLAYER2) == false && secondplayer.isSelected()) {
				// player one
				if (firstPlayer == true) {

					for (int i = 0; i < tiles.length; i++) {
						for (int j = 0; j < tiles[i].length; j++) {
							if (e.getSource() == tiles[i][j]) {
								playercheck = true;
							} else {
								playercheck = false;
							}
							Human temp = new Human(winnum, lossnum, tienum);
							temp.humanplayer1(gui, i, j);

						}
					}
				}
				// Player two
				else {
					for (int i = 0; i < tiles.length; i++) {
						for (int j = 0; j < tiles[i].length; j++) {
							if (e.getSource() == tiles[i][j]) {
								playercheck = true;
							} else {
								playercheck = false;
							}
							Human temp = new Human(winnum, lossnum, tienum);
							temp.humanplayer2(gui, i, j);

						}
					}
				}
			}
			/**
			 * If statement for ai vs human player. Checks if its the human players turn
			 * executes the click and then changes the turn to ai. then a loop runs till
			 * some one wins or we have a tie
			 */
			if (Winner(PLAYER1) == false && Winner(PLAYER2) == false && aisecondplayer.isSelected()
					&& firstPlayer == true) {
				if (firstPlayer == true) {
					for (int i = 0; i < tiles.length; i++) {
						for (int j = 0; j < tiles[i].length; j++) {
							if (e.getSource() == tiles[i][j]) {
								playercheck = true;
							} else {
								playercheck = false;
							}
							Human temp = new Human(winnum, lossnum, tienum);
							temp.humanplayer1(gui, i, j);

						}
					}
				}
			}
			if (Winner(PLAYER1) == false && Winner(PLAYER2) == false && aisecondplayer.isSelected()
					&& firstPlayer == false) {
				if (firstPlayer == false) {
					Synthetic temp = new Synthetic(winnum, lossnum, tienum);
					temp.dumbAI(gui);

				}
			}

			/**
			 * To Change the 3 boxes of the winners mark to green to show that they won.
			 */
			if (Winner(PLAYER1)) {
				JTile temp = new JTile();
				temp.winline(gui, PLAYER1);
				winnum++;
			}
			if (Winner(PLAYER2)) {
				JTile temp = new JTile();
				temp.winline(gui, PLAYER2);
				lossnum++;
			}

			/**
			 * runs the code to add to the run of ties
			 */
			if (Winner(PLAYER1) == false && Winner(PLAYER2) == false) {
				tiechecking();
			}

		}

	}

	/**
	 * Action Listers for the different Menu file menu items
	 * 
	 * @author devansh
	 *
	 */
	private class MenuItemListener implements ActionListener {

		@Override

		public void actionPerformed(ActionEvent e) {

			/**
			 * To close the Window when exit is selected
			 * 
			 * @author devansh
			 */
			if (e.getSource() == close) {
				System.exit(0);
			}
			/**
			 * To reset the background and title to their default values. This also makes
			 * the boxes=0 that makes the compiler think the tiles are empty
			 * 
			 * @author devansh
			 */
			else if (e.getSource() == restart) {

				for (int i = 0; i < tiles.length; i++) {
					firstPlayer = true;
					for (int k = 0; k < tiles.length; k++) {
						boxes[i][k] = 0;
						tiles[i][k].setBackground(Color.CYAN);
						tiles[i][k].setIcon(null);
					}
				}

			}
			/**
			 * This one displays all stats of the game
			 * 
			 * @author devansh
			 */
			else if (e.getSource() == statistics) {
				JOptionPane.showMessageDialog(null, winlossnum(winnum, lossnum, tienum), "Stats",
						JOptionPane.INFORMATION_MESSAGE);
			}
			/**
			 * to record the stats of a username
			 * 
			 * @author devansh
			 * 
			 */
			else if (e.getSource() == records) {
				String name = JOptionPane.showInputDialog("Please enter your name");

				try {
					PrintWriter record = new PrintWriter("users.con");
					record.println(name);
					String username = name + ".con";
					PrintWriter record1 = new PrintWriter(username);
					record1.println(winnum);
					record1.println(lossnum);
					record1.println(tienum);
					record.close();
					record1.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}

			}
			/**
			 * Loads a users data from the saved files
			 * 
			 * @author devansh
			 */
			else if (e.getSource() == loadrecords) {
				String name = JOptionPane.showInputDialog("Please enter your name");
				String username = name + ".con";
				File f = new File(username);
				try {
					Scanner keyboard = new Scanner(f);
					winnum = keyboard.nextInt();
					keyboard.nextLine();
					lossnum = keyboard.nextInt();
					keyboard.nextLine();
					tienum = keyboard.nextInt();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			/**
			 * clears stats
			 * 
			 * @author devansh
			 */
			else if (e.getSource() == deleterecords) {
				winnum = 0;
				lossnum = 0;
				tienum = 0;
			}

		}

	}
}
