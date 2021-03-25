import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConversionCalculator extends JFrame {
	private JLabel inchlable, meterlable, centimeterlable, yardlable;
	private JButton clear, calculate, exit;
	private JTextField inchtextfield, centimetertextfield, meterstextfield, yardstextfield;

	public ConversionCalculator() {

		ButtonHandler buttonhandler = new ButtonHandler();

		setTitle("Conversion Calculator");
		setSize(700, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(new GridLayout(1, 3));

		inchlable = new JLabel("Inches",SwingConstants.RIGHT);
		yardlable = new JLabel("Yards",SwingConstants.RIGHT);
		centimeterlable = new JLabel("Centimeters",SwingConstants.RIGHT);
		meterlable = new JLabel("Meters",SwingConstants.RIGHT);

		clear = new JButton("Clear");
		calculate = new JButton("Calculate");
		exit = new JButton("Exit");

		inchtextfield = new JTextField("0.00");
		yardstextfield = new JTextField("0.00");
		centimetertextfield = new JTextField("0.00");
		meterstextfield = new JTextField("0.00");


		JPanel firstpanel = new JPanel();
		firstpanel.setLayout(new GridLayout(2, 2));
		firstpanel.add(centimeterlable);
		firstpanel.add(centimetertextfield);
		firstpanel.add(meterlable);
		firstpanel.add(meterstextfield);

		JPanel secondpanel = new JPanel();
		secondpanel.setLayout(new GridLayout(2, 2));
		secondpanel.add(inchlable);
		secondpanel.add(inchtextfield);
		secondpanel.add(yardlable);
		secondpanel.add(yardstextfield);

		JPanel thirdpanel = new JPanel();
		thirdpanel.setLayout(new GridLayout(3, 1));
		thirdpanel.add(clear);
		thirdpanel.add(calculate);
		thirdpanel.add(exit);

		add(firstpanel);
		add(secondpanel);
		add(thirdpanel);

		
		exit.addActionListener(buttonhandler);
		clear.addActionListener(buttonhandler);
		calculate.addActionListener(buttonhandler);

		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == exit) {
				System.exit(0);
			} else if (e.getSource() == clear) {
				inchtextfield.setText("0.00");
				meterstextfield.setText("0.00");
				yardstextfield.setText("0.00");
				centimetertextfield.setText("0.00");
			} else if (e.getSource() == calculate) {
				try {

					double inches, yards, meters, cms;
					DecimalFormat df = new DecimalFormat("0.00");

					inches = Double.parseDouble(inchtextfield.getText());
					yards = Double.parseDouble(yardstextfield.getText());
					meters = Double.parseDouble(meterstextfield.getText());
					cms = Double.parseDouble(centimetertextfield.getText());

					if (inches != 0.00) {
						cms = inches * 2.54;
						meters = cms / 100;
						yards = inches / 36;

						centimetertextfield.setText(df.format(cms));
						meterstextfield.setText(df.format(meters));
						yardstextfield.setText(df.format(yards));

					} else if (yards != 0.00) {
						inches = yards / 36;
						cms = inches * 2.54;
						meters = cms / 100;

						centimetertextfield.setText(df.format(cms));
						meterstextfield.setText(df.format(meters));
						inchtextfield.setText(df.format(inches));
					} else if (meters != 0.00) {
						cms = meters * 100;
						inches = cms / 2.54;
						yards = inches / 36;

						centimetertextfield.setText(df.format(cms));
						inchtextfield.setText(df.format(inches));
						yardstextfield.setText(df.format(yards));
					} else if (cms != 0.00) {
						inches = cms / 2.54;
						yards = inches / 36;
						meters = cms / 100;

						meterstextfield.setText(df.format(meters));
						inchtextfield.setText(df.format(inches));
						yardstextfield.setText(df.format(yards));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "The entry was not a number.");
				}
			}
		}
	}
}
