import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class COlorSelectionGUI extends JFrame {

	JPanel main, checking, button;
	JLabel E, N, S, W;
	JRadioButton C1, C2, C3, C4;
	JCheckBox ifn, ife, ifs, ifw;

	public COlorSelectionGUI() {
		setTitle("Color Selection GUI");
		setSize(900, 550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		E = new JLabel("East", SwingConstants.CENTER);
		E.setFont(new Font("Region", Font.BOLD, 18));

		E.setOpaque(true);
		E.setBackground(Color.CYAN);
		getContentPane().add(E, BorderLayout.EAST);

		N = new JLabel("North", SwingConstants.CENTER);
		N.setFont(new Font("Region", Font.BOLD, 18));
		N.setOpaque(true);
		N.setBackground(Color.CYAN);
		getContentPane().add(N, BorderLayout.NORTH);

		S = new JLabel("South", SwingConstants.CENTER);
		S.setFont(new Font("Region", Font.BOLD, 18));
		S.setOpaque(true);
		S.setBackground(Color.CYAN);
		getContentPane().add(S, BorderLayout.SOUTH);

		W = new JLabel("West", SwingConstants.CENTER);
		W.setFont(new Font("Region", Font.BOLD, 18));
		W.setOpaque(true);
		W.setBackground(Color.CYAN);
		getContentPane().add(W, BorderLayout.WEST);

		main = new JPanel();
		main.setLayout(new GridLayout(1, 2, 0, 0));
		main.setBackground(Color.GRAY);
		getContentPane().add(main, BorderLayout.CENTER);
		checking = new JPanel();
		checking.setBorder(new TitledBorder(UIManager.getBorder("Titled.border"), "Locations", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		checking.setLayout(new GridLayout(0, 1, 1, 1));

		ifn = new JCheckBox("North");
		ifn.setFont(new Font("if box", Font.BOLD, 18));
		ife = new JCheckBox("East");
		ife.setFont(new Font("if box", Font.BOLD, 18));
		ifs = new JCheckBox("South");
		ifs.setFont(new Font("if box", Font.BOLD, 18));
		ifw = new JCheckBox("West");
		ifw.setFont(new Font("if box", Font.BOLD, 18));

		ifn.setSelected(true);
		ife.setSelected(true);
		ifs.setSelected(true);
		ifw.setSelected(true);

		checking.add(ifn);
		checking.add(ife);
		checking.add(ifs);
		checking.add(ifw);

		main.add(checking);

		button = new JPanel();
		button.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bg Color", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		button.setLayout(new GridLayout(0, 1, 1, 1));

		C1 = new JRadioButton("RED");
		C1.setForeground(Color.RED);
		C2 = new JRadioButton("GREEN");
		C2.setForeground(Color.GREEN);
		C3 = new JRadioButton("BLUE");
		C3.setForeground(Color.BLUE);
		C4 = new JRadioButton("CYAN");
		C4.setForeground(Color.CYAN);

		C4.setSelected(true);

		ButtonGroup bg = new ButtonGroup();
		bg.add(C1);
		bg.add(C2);
		bg.add(C3);
		bg.add(C4);

		button.add(C1);
		button.add(C2);
		button.add(C3);
		button.add(C4);

		main.add(button);

		RadioButtonListener button = new RadioButtonListener();
		C1.addActionListener(button);
		C2.addActionListener(button);
		C3.addActionListener(button);
		C4.addActionListener(button);
	}

	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == C1) {
				if (ifn.isSelected()) {
					N.setBackground(Color.MAGENTA);
				}
				if (ife.isSelected()) {
					E.setBackground(Color.MAGENTA);
				}
				if (ifs.isSelected()) {
					S.setBackground(Color.MAGENTA);
				}
				if (ifw.isSelected()) {
					W.setBackground(Color.MAGENTA);
				}
			}

			else if (e.getSource() == C2) {
				if (ifn.isSelected()) {
					N.setBackground(Color.YELLOW);
				}
				if (ife.isSelected()) {
					E.setBackground(Color.YELLOW);
				}
				if (ifs.isSelected()) {
					S.setBackground(Color.YELLOW);
				}
				if (ifw.isSelected()) {
					W.setBackground(Color.YELLOW);
				}
			}

			else if (e.getSource() == C3) {
				if (ifn.isSelected()) {
					N.setBackground(Color.ORANGE);
				}
				if (ife.isSelected()) {
					E.setBackground(Color.ORANGE);
				}
				if (ifs.isSelected()) {
					S.setBackground(Color.ORANGE);
				}
				if (ifw.isSelected()) {
					W.setBackground(Color.ORANGE);
				}
			}

			else if (e.getSource() == C4) {
				if (ifn.isSelected()) {
					N.setBackground(Color.CYAN);
				}
				if (ife.isSelected()) {
					E.setBackground(Color.CYAN);
				}
				if (ifs.isSelected()) {
					S.setBackground(Color.CYAN);
				}
				if (ifw.isSelected()) {
					W.setBackground(Color.CYAN);
				}
			}
		}
	}

	public static void main(String[] args) {
		new COlorSelectionGUI().setVisible(true);
	}
}
