import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TextBoxGUI extends JFrame {
	private ColorListPanel color_panel;
	private TextAreaPanel text_panel;
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem saving_item, loading_item, exit_item;

	public TextBoxGUI() {
		setTitle("Simple Wordpad");
		setSize(850, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		color_panel = new ColorListPanel();
		add(color_panel, BorderLayout.EAST);
		text_panel = new TextAreaPanel();
		add(text_panel, BorderLayout.CENTER);
		menu = new JMenuBar();
		setJMenuBar(menu);
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		saving_item = new JMenuItem("Save");
		saving_item.setToolTipText("Save the current text");
		saving_item.setMnemonic(KeyEvent.VK_S);
		file.add(saving_item);
		loading_item = new JMenuItem("Load");
		loading_item.setToolTipText("Load existing text");
		loading_item.setMnemonic(KeyEvent.VK_L);
		file.add(loading_item);
		exit_item = new JMenuItem("Exit");
		exit_item.setToolTipText("Exit the application");
		exit_item.setMnemonic(KeyEvent.VK_X);
		file.add(exit_item);
		menu.add(file);
		Load_Menu_Item menu_lister = new Load_Menu_Item();
		Button_click button_Listener = new Button_click();
		Color_Chooser Color_list_Listener = new Color_Chooser();
		color_panel.getDeleteColor().addActionListener(button_Listener);
		color_panel.getAddColor().addActionListener(button_Listener);
		color_panel.getList().addListSelectionListener(Color_list_Listener);
		loading_item.addActionListener(menu_lister);
		saving_item.addActionListener(menu_lister);
		exit_item.addActionListener(menu_lister);
	}

	private class Button_click implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == color_panel.getAddColor()) {
				Color Choosen_color = JColorChooser.showDialog(null, "Select the Desired color", Color.RED);

				color_panel.getDim().addElement(Choosen_color);
			}

			else if (e.getSource() == color_panel.getDeleteColor()) {
				int index = color_panel.getList().getSelectedIndex();

				if (index != -1) {
					color_panel.getDim().remove(index);
				}
			}
		}
	}

	private class Load_Menu_Item implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == saving_item) {
				try {
					JFileChooser Choosen_file = new JFileChooser();
					int save = Choosen_file.showSaveDialog(null);

					if (save == JFileChooser.APPROVE_OPTION) {
						String fileName = Choosen_file.getSelectedFile().getPath();
						PrintWriter file = new PrintWriter(fileName);

						String stringToSave = text_panel.getTextField().getText();
						stringToSave = stringToSave.replaceAll("\n", "\n\r");

						file.print(stringToSave);

						file.close();
					}
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			else if (e.getSource() == loading_item) {
				try {
					JFileChooser Choosen_file = new JFileChooser();
					int load = Choosen_file.showOpenDialog(null);

					if (load == JFileChooser.APPROVE_OPTION) {
						File file = Choosen_file.getSelectedFile();
						Scanner keyboard = new Scanner(file);
						String textFromFile = "";

						while (keyboard.hasNext()) {
							textFromFile += keyboard.nextLine() + "\n";
						}

						text_panel.getTextField().setText(textFromFile);

						keyboard.close();
					}
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

			else if (e.getSource() == exit_item) {
				System.exit(0);
			}
		}
	}

	private class Color_Chooser implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int index = color_panel.getList().getSelectedIndex();

			if (index != -1) {
				text_panel.setBackground(color_panel.getList().getSelectedValue());
			}
		}
	}

	public static void main(String[] args) {
		TextBoxGUI Driver = new TextBoxGUI();
		Driver.setVisible(true);
	}
}
