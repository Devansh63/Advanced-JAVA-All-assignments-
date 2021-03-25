package lab06_DevanshAgrawal_CS161;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.regex.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DataParser extends JFrame {

	private TokenDisplayPanel fivePanels;
	private ParsingPanel parseingVariable;
	private JMenuBar optionsBar;
	private JMenu fileMenu, parseMenu;
	private JRadioButtonMenuItem ipTab, emailTab, numberTab, ccTab;
	private JMenuItem clearTab, exitTab;
	private String display = " ";

	public static void main(String[] args) {
		DataParser runningvariable = new DataParser();
		runningvariable.setVisible(true);
	}

	public DataParser() {

		setLayout(new BorderLayout());

		optionsBar = new JMenuBar();
		setJMenuBar(optionsBar);
		fileMenu = new JMenu("File");
		parseMenu = new JMenu("Parse Type");

		optionsBar.add(fileMenu);
		optionsBar.add(parseMenu);

		clearTab = new JMenuItem("Clear");
		exitTab = new JMenuItem("Exit");
		fileMenu.add(clearTab);
		fileMenu.add(exitTab);

		FileMenuHandler fileMenuHandler = new FileMenuHandler();
		exitTab.addActionListener(fileMenuHandler);
		clearTab.addActionListener(fileMenuHandler);

		ipTab = new JRadioButtonMenuItem("IP Address");
		emailTab = new JRadioButtonMenuItem("Email");
		numberTab = new JRadioButtonMenuItem("Phone Number");
		ccTab = new JRadioButtonMenuItem("Credit Card");
		parseMenu.add(ipTab);
		parseMenu.add(emailTab);
		parseMenu.add(numberTab);
		parseMenu.add(ccTab);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(ipTab);
		buttonGroup.add(emailTab);
		buttonGroup.add(numberTab);
		buttonGroup.add(ccTab);
		ipTab.setSelected(true);

		parseingVariable = new ParsingPanel();
		fivePanels = new TokenDisplayPanel();
		add(parseingVariable, BorderLayout.CENTER);
		add(fivePanels, BorderLayout.EAST);

		ButtonHandler bh = new ButtonHandler();
		parseingVariable.getTokenParserPanel().getParseTokens().addActionListener(bh);

		setSize(800, 950);
		setTitle("Data Parser");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Parse Tokens") {
				if (ipTab.isSelected()) {
					String input = parseingVariable.getTokenParserPanel().getTextField().getText();
					Pattern iptemplate = Pattern.compile("\\d\\d\\d\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}");
					Matcher ipTemplateMatcher = iptemplate.matcher(input);
					parseingVariable.getTokenParserPanel().getTextField().setText("");

					if (ipTemplateMatcher.matches()) {
						String seperatedTokens[] = input.split("[.]");
						fivePanels.firstPanel().setText("Properly Parsed!");
						fivePanels.secondPanel().setText(seperatedTokens[0]);
						fivePanels.thirdPanel().setText(seperatedTokens[1]);
						fivePanels.fourthPanel().setText(seperatedTokens[2]);
						fivePanels.fifthPanel().setText(seperatedTokens[3]);

						display += input + ": " + "[" + seperatedTokens[0] + ", " + seperatedTokens[1] + ", "
								+ seperatedTokens[2] + ", " + seperatedTokens[3] + "]\n";
						parseingVariable.getResultPanel().getResultArea().setText(display);
					}

					else {
						fivePanels.firstPanel().setText("Improper Data Format");
						fivePanels.secondPanel().setText("---");
						fivePanels.thirdPanel().setText("---");
						fivePanels.fourthPanel().setText("---");
						fivePanels.fifthPanel().setText("---");
					}
				}

				else if (numberTab.isSelected()) {
					String input = parseingVariable.getTokenParserPanel().getTextField().getText();
					Pattern numbertemplate = Pattern.compile("\\(\\d{3}\\)\\d{3}\\-\\d{4}");
					Matcher numberTemplateMatcher = numbertemplate.matcher(input);
					parseingVariable.getTokenParserPanel().getTextField().setText("");

					if (numberTemplateMatcher.matches()) {
						String seperatedTokens[] = input.split("[()-]");
						fivePanels.firstPanel().setText("Properly Parsed!");
						fivePanels.secondPanel().setText(seperatedTokens[1]);
						fivePanels.thirdPanel().setText(seperatedTokens[2]);
						fivePanels.fourthPanel().setText(seperatedTokens[3]);
						fivePanels.fifthPanel().setText("---");

						display += input + ": " + "[" + seperatedTokens[1] + ", " + seperatedTokens[2] + ", "
								+ seperatedTokens[3] + ", ---]\n";
						parseingVariable.getResultPanel().getResultArea().setText(display);
					}

					else {
						fivePanels.firstPanel().setText("Improper Data Format");
						fivePanels.secondPanel().setText("---");
						fivePanels.thirdPanel().setText("---");
						fivePanels.fourthPanel().setText("---");
						fivePanels.fifthPanel().setText("---");
					}
				}

				else if (emailTab.isSelected()) {
					String input = parseingVariable.getTokenParserPanel().getTextField().getText();
					Pattern emailtemplate = Pattern.compile("\\w+\\@\\w+\\.\\w+");
					Matcher emailTemplateMatcher = emailtemplate.matcher(input);
					parseingVariable.getTokenParserPanel().getTextField().setText("");

					if (emailTemplateMatcher.matches()) {
						String seperatedTokens[] = input.split("[@.]");
						fivePanels.firstPanel().setText("Properly Parsed!");
						fivePanels.secondPanel().setText(seperatedTokens[0]);
						fivePanels.thirdPanel().setText(seperatedTokens[1]);
						fivePanels.fourthPanel().setText(seperatedTokens[2]);
						fivePanels.fifthPanel().setText("---");

						display += input + ": " + "[" + seperatedTokens[0] + ", " + seperatedTokens[1] + ", "
								+ seperatedTokens[2] + ", ---]\n";
						parseingVariable.getResultPanel().getResultArea().setText(display);
					}

					else {
						fivePanels.firstPanel().setText("Improper Data Format");
						fivePanels.secondPanel().setText("---");
						fivePanels.thirdPanel().setText("---");
						fivePanels.fourthPanel().setText("---");
						fivePanels.fifthPanel().setText("---");
					}
				}

				else if (ccTab.isSelected()) {
					String input = parseingVariable.getTokenParserPanel().getTextField().getText();
					Pattern ccTemplate = Pattern.compile("\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}");
					Matcher ccTemplateMatcher = ccTemplate.matcher(input);
					parseingVariable.getTokenParserPanel().getTextField().setText("");

					if (ccTemplateMatcher.matches()) {
						String seperatedTokens[] = input.split(" ");
						fivePanels.firstPanel().setText("Properly Parsed!");
						fivePanels.secondPanel().setText(seperatedTokens[0]);
						fivePanels.thirdPanel().setText(seperatedTokens[1]);
						fivePanels.fourthPanel().setText(seperatedTokens[2]);
						fivePanels.fifthPanel().setText(seperatedTokens[3]);

						display += input + ": " + "[" + seperatedTokens[0] + ", " + seperatedTokens[1] + ", "
								+ seperatedTokens[2] + ", " + seperatedTokens[3] + "]\n";
						parseingVariable.getResultPanel().getResultArea().setText(display);
					}

					else {
						fivePanels.firstPanel().setText("Improper Data Format");
						fivePanels.secondPanel().setText("---");
						fivePanels.thirdPanel().setText("---");
						fivePanels.fourthPanel().setText("---");
						fivePanels.fifthPanel().setText("---");
					}
				}
			}
		}
	}

	private class FileMenuHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == clearTab) {
				parseingVariable.getResultPanel().reset();
				parseingVariable.getTokenParserPanel().reset();
				fivePanels.reset();
				ipTab.setSelected(true);
				display = "";
			}

			else if (e.getSource() == exitTab) {
				System.exit(0);
			}
		}
	}

	public class TokenDisplayPanel extends JPanel {
		private JLabel firstPanel, secondPanel, thirdPanel, fourthPanel, fifthPanel;

		public TokenDisplayPanel() {
			setLayout(new GridLayout(5, 1));
			setPreferredSize(new Dimension(200, 500));

			firstPanel = new JLabel();
			secondPanel = new JLabel();
			thirdPanel = new JLabel();
			fourthPanel = new JLabel();
			fifthPanel = new JLabel();

			secondPanel.setText("---");
			thirdPanel.setText("---");
			fourthPanel.setText("---");
			fifthPanel.setText("---");

			firstPanel.setBorder(new LineBorder(Color.BLACK));
			secondPanel.setBorder(new LineBorder(Color.BLACK));
			thirdPanel.setBorder(new LineBorder(Color.BLACK));
			fourthPanel.setBorder(new LineBorder(Color.BLACK));
			fifthPanel.setBorder(new LineBorder(Color.BLACK));

			add(firstPanel);
			add(secondPanel);
			add(thirdPanel);
			add(fourthPanel);
			add(fifthPanel);
		}

		public void reset() {
			firstPanel.setText("");
			secondPanel.setText("---");
			thirdPanel.setText("---");
			fourthPanel.setText("---");
			fifthPanel.setText("---");
		}

		public JLabel firstPanel() {
			return firstPanel;
		}

		public void setInfoPanel1(JLabel infoPanel1) {
			this.firstPanel = infoPanel1;
		}

		public JLabel secondPanel() {
			return secondPanel;
		}

		public void setInfoPanel2(JLabel infoPanel2) {
			this.secondPanel = infoPanel2;
		}

		public JLabel thirdPanel() {
			return thirdPanel;
		}

		public void setInfoPanel3(JLabel infoPanel3) {
			this.thirdPanel = infoPanel3;
		}

		public JLabel fourthPanel() {
			return fourthPanel;
		}

		public void setInfoPanel4(JLabel infoPanel4) {
			this.fourthPanel = infoPanel4;
		}

		public JLabel fifthPanel() {
			return fifthPanel;
		}

		public void setInfoPanel5(JLabel infoPanel5) {
			this.fifthPanel = infoPanel5;
		}
	}

	public class TokenParserPanel extends JPanel {
		private JTextField inputArea;
		private JButton parsingButtons;

		public TokenParserPanel() {
			setBorder(new TitledBorder(null, "Token Parser"));

			inputArea = new JTextField();
			parsingButtons = new JButton("Parse Tokens");

			inputArea.setPreferredSize(new Dimension(400, 50));
			parsingButtons.setPreferredSize(new Dimension(200, 20));

			add(inputArea, BorderLayout.NORTH);
			add(parsingButtons, BorderLayout.NORTH);
		}

		public void reset() {
			inputArea.setText("");
		}

		public JTextField getTextField() {
			return inputArea;
		}

		public void setTextField(JTextField textField) {
			this.inputArea = textField;
		}

		public JButton getParseTokens() {
			return parsingButtons;
		}

		public void setParseTokens(JButton parseTokens) {
			this.parsingButtons = parseTokens;
		}
	}

	public class ResultPanel extends JPanel {
		private JTextArea resultArea;

		public ResultPanel() {
			setBorder(new TitledBorder(null, "Result Panel"));
			setLayout(new GridLayout(1, 1));

			resultArea = new JTextArea();
			resultArea.setEditable(false);
			add(resultArea);
		}

		public void reset() {
			resultArea.setText("");
		}

		public JTextArea getResultArea() {
			return resultArea;
		}

		public void setResultArea(JTextArea resultArea) {
			this.resultArea = resultArea;
		}
	}

	public class ParsingPanel extends JPanel {
		private TokenParserPanel tokenParserPanel;
		private ResultPanel resultPanel;

		public ParsingPanel() {
			setLayout(new GridLayout(2, 1));

			tokenParserPanel = new TokenParserPanel();
			add(tokenParserPanel);

			resultPanel = new ResultPanel();
			add(resultPanel);
		}

		public TokenParserPanel getTokenParserPanel() {
			return tokenParserPanel;
		}

		public void setTokenParserPanel(TokenParserPanel tokenParserPanel) {
			this.tokenParserPanel = tokenParserPanel;
		}

		public ResultPanel getResultPanel() {
			return resultPanel;
		}

		public void setResultPanel(ResultPanel resultPanel) {
			this.resultPanel = resultPanel;
		}
	}

}
