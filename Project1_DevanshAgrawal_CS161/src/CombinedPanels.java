/* Devansh Agrawal
 * CS 161 Project 1
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CombinedPanels extends JFrame {

	//INITIALIZATIONS
	private PaymentInfoPanel paymentPlan;
	private LoanTermPanel loanTerm;
	private FinancingInfoPanel financeingInfomation;
	private OptionsPanel bunkerOptions;
	private ActionButtonPanel actionButtonPanel;
	private TitleBarPanel titlePanel;
	private int loanPeriod;
	private double baseprice;
	private double downpayment;
	private double sales_Tax;
	private double ALDsum = 0;
	private double SSUCsum = 0;
	private double GRsum = 0;
	private double GRSPsum = 0;
	private double MAsum = 0;
	private double BOsum = 0;
	private double monthlyRate;
	private JCheckBox ALD, SSUC, GR, GRSP, MA;
	private JPanel paymentPanel, loanPanel, financingPanel, bunkerPanel;

	/**Combined Panels is class that holds almost all the sub classes for the panels */ 
	public CombinedPanels() {

		/**Creating the panels and adding the title and locations to them.*/
		titlePanel = new TitleBarPanel();
		titlePanel.setPreferredSize(new Dimension(800,10));
		actionButtonPanel = new ActionButtonPanel();
		paymentPlan = new PaymentInfoPanel();
		paymentPanel = new JPanel();
		paymentPanel.setLayout(new GridLayout(1, 1));
		paymentPanel.add(titlePanel);

		loanTerm = new LoanTermPanel();
		loanPanel = new JPanel();
		loanPanel.setLayout(new GridLayout(1, 2));
		loanPanel.add(paymentPlan);
		loanPanel.add(loanTerm);

		financeingInfomation = new FinancingInfoPanel();

		bunkerOptions = new OptionsPanel();
		bunkerPanel = new JPanel();
		bunkerPanel.setLayout(new GridLayout(1, 1));
		bunkerPanel.add(actionButtonPanel);

		getContentPane().add(paymentPanel);
		getContentPane().add(loanPanel);
		financingPanel = new JPanel();
		financingPanel.setLayout(new GridLayout(1, 2));
		
				financingPanel.add(financeingInfomation);
				financingPanel.add(bunkerOptions);
				getContentPane().add(financingPanel);
		getContentPane().add(bunkerPanel);

		setTitle("Bunkertech LLC - Your Safety, is Secured in Concrete");
		setVisible(true);
		setSize(800, 750);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(4, 2));

	}

	/**Creating the title panel with a backgroundcolor and centered title*/
	private class TitleBarPanel extends JPanel {
		JLabel titleLable;

		public TitleBarPanel() {
			titleLable = new JLabel(" BUNKER LOAN CALCULATOR",SwingConstants.CENTER);
			titleLable.setForeground(Color.WHITE);
			titleLable.setFont(new Font("Title", Font.BOLD, 24));
			add(titleLable);
			setBackground(Color.RED);
		}
	}

	/**Creating the First panel(Top right) that will display the results from the calculations */
	private class PaymentInfoPanel extends JPanel {
		JLabel loanAmountLable, perMonthLable, totalLable;
		JLabel loanAmountValue, perMonthValue, totalDue;

		public PaymentInfoPanel() {

			setLayout(new GridLayout(3, 2));

			loanAmountLable = new JLabel("Total Loan Amount");
			loanAmountValue = new JLabel("$0.0");
			loanAmountValue.setHorizontalAlignment(JLabel.CENTER);
			add(loanAmountLable);
			add(loanAmountValue);

			perMonthLable = new JLabel("Monthly Payment ");
			perMonthValue = new JLabel("$0.0");
			perMonthValue.setHorizontalAlignment(JLabel.CENTER);
			add(perMonthLable);
			add(perMonthValue);

			totalLable = new JLabel("Total Payment");
			totalDue = new JLabel("$0.0");
			totalDue.setHorizontalAlignment(JLabel.CENTER);
			add(totalLable);
			add(totalDue);

			TitledBorder title;
			title = BorderFactory.createTitledBorder("PAYMENT PLAN");
			title.setTitleJustification(TitledBorder.LEFT);
			setBorder(title);

		}

		public JLabel getAmount() {
			return loanAmountValue;
		}

		public void setAmount(String totalAmount) {
			this.loanAmountValue.setText(totalAmount);
		}

		public JLabel getPerMonth() {
			return perMonthValue;
		}

		public void setPerMonth(String monthly) {
			this.perMonthValue.setText(monthly);
		}

		public JLabel getFinalTotal() {
			return totalDue;
		}

		public void setFinalTotal(String total) {
			this.totalDue.setText(total);
		}

	}

	/**Creating the Loan panel that selects the enables the user to select the time period of the loan.
	only one item can be selected at a time. */
	private class LoanTermPanel extends JPanel {
		JRadioButton m_24, m_36, m_48, m_60;

		public LoanTermPanel() {

			m_24 = new JRadioButton("24 months has an interest rate of 4.5%");
			add(m_24);
			m_24.addActionListener(new ButtonListener());
			m_24.setSelected(true);
			
			m_36 = new JRadioButton("36 months has an interest rate of 5.5%");
			add(m_36);
			m_36.addActionListener(new ButtonListener());

			m_48 = new JRadioButton("48 months has an interest rate of 6.5%");
			add(m_48);
			m_48.addActionListener(new ButtonListener());

			m_60 = new JRadioButton("60 months has an interest rate of 7.0%");
			add(m_60);
			m_60.addActionListener(new ButtonListener());

			ButtonGroup bg = new ButtonGroup();
			bg.add(m_36);
			bg.add(m_24);
			bg.add(m_48);
			bg.add(m_60);
			
			setLayout(new GridLayout(4, 1));

			TitledBorder title;
			title = BorderFactory.createTitledBorder("LOAN TERM");
			title.setTitleJustification(TitledBorder.LEFT);
			setBorder(title);
		}

		private class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == m_24) {
					loanPeriod = 24;
					monthlyRate = 0.045;

				} else if (e.getSource() == m_36) {
					monthlyRate = 0.055;
					loanPeriod = 36;
				} else if (e.getSource() == m_48) {
					loanPeriod = 48;
					monthlyRate = 0.065;
				} else if (e.getSource() == m_60) {
					loanPeriod = 60;
					monthlyRate = 0.070;
				} else {
					loanPeriod = 24;
					monthlyRate = 0.045;
				}
			}

		}
	}

	/**creating the panel that helps the user enter all the values for the desired loan. Has text fields.*/
	private class FinancingInfoPanel extends JPanel {
		JLabel baseCLable, downpaymentLable, salesTaxPerctLable;
		JTextField baseCValue, downpaymentValue, salesTaxPerctValue;

		public FinancingInfoPanel() {

			setLayout(new GridLayout(4, 2));

			baseCLable = new JLabel("Base Contract Price");
			baseCValue = new JTextField("0.0");
			add(baseCLable);
			add(baseCValue);

			downpaymentLable = new JLabel("Down Payment");
			downpaymentValue = new JTextField("0.0");
			add(downpaymentLable);
			add(downpaymentValue);

			salesTaxPerctLable = new JLabel("Sales Tax");
			salesTaxPerctValue = new JTextField("7.0");
			add(salesTaxPerctLable);
			add(salesTaxPerctValue);

			TitledBorder title;
			title = BorderFactory.createTitledBorder("FINANCING INFORMATION");
			title.setTitleJustification(TitledBorder.LEFT);
			setBorder(title);
		}

		
		public String getBaseCPrice() {
			return baseCValue.getText();
		}

		public void setBaseCPrice(String basePrice) {
			this.baseCValue.setText(basePrice);
		}

		public String getDownpayment() {
			return downpaymentValue.getText();
		}

		public void setDownpayment(String downPayment) {
			this.downpaymentValue.setText(downPayment);
		}

		public String getSalesTaxPercent() {
			return salesTaxPerctValue.getText();
		}

		public void setSalesTaxPercent(String salesTax) {
			this.salesTaxPerctValue.setText(salesTax);
		}

	}

	//Creating the check box selection panel. Help the user to add certain set numbers automatically to the loan. Can select multiple values.  
	private class OptionsPanel extends JPanel {
		

		// JPanel pricePanel;
		public OptionsPanel() {
			// initialize all

			setLayout(new GridLayout(5, 1));

			ALD = new JCheckBox("Auto Lock Door-$21,000");
			add(ALD);
			ALD.addItemListener(new CheckBoxListener());

			SSUC = new JCheckBox("SecuriSafe Ultra Concrete-$30,000", true);
			add(SSUC);
			SSUC.addItemListener(new CheckBoxListener());

			GR = new JCheckBox("Guard Robot-$150,000");
			add(GR);
			GR.addItemListener(new CheckBoxListener());

			GRSP = new JCheckBox("Gaurd Robot Safety Protocols-$30,000");
			add(GRSP);
			GRSP.addItemListener(new CheckBoxListener());

			MA = new JCheckBox("Medical Addons-$200,000");
			add(MA);
			MA.addItemListener(new CheckBoxListener());

			TitledBorder title;
			title = BorderFactory.createTitledBorder("BUNKER OPTIONS");
			title.setTitleJustification(TitledBorder.LEFT);
			setBorder(title);
		}

		private class CheckBoxListener implements ItemListener {
			public void itemStateChanged(ItemEvent e) {
				SSUCsum = 1200;
				// antiLock.doClick();
				if (ALD.isSelected())
					ALDsum = 21000;
				if (SSUC.isSelected())
					SSUCsum = 30000;
				if (GR.isSelected())
					GRsum = 150000;
				if (GRSP.isSelected())
					GRSPsum = 30000;
				if (MA.isSelected())
					MAsum = 200000;
				if (SSUC.isSelected() == false)
					SSUCsum = 0;
				if (ALD.isSelected() == false)
					ALDsum = 0;
				if (GR.isSelected() == false)
					GRsum = 0;
				if (MA.isSelected() == false)
					MAsum = 0;
				if (GRSP.isSelected() == false)
					GRSPsum = 0;
				BOsum = ALDsum + SSUCsum + GRsum + GRSPsum + MAsum;
			}

		}
	}

	//The ACtion Button Panel that holds all the button and allows actions when the buttons are clicked.
	//Calculations are processed when the Calculation Button is pressed.
	//All the values are reset to reset when the reset button is clicked
	//The window exits when the exit button is clicked
	private class ActionButtonPanel extends JPanel {
		// JPanel actionPanel;
		JButton calc, reset, exit;

		public ActionButtonPanel() {
			
			setLayout(new GridLayout(1, 3, 120 , 30));
			
			calc = new JButton("Calculate");
			calc.setPreferredSize(new Dimension(5,10));
			add(calc);
			calc.addActionListener(new calcButton());

			reset = new JButton("Reset");
			add(reset);
			reset.addActionListener(new resetButton());

			exit = new JButton("exit");
			add(exit);
			exit.addActionListener(new exitButton());
			// add to panel

		}

		private class calcButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				double bunkerOptSum = BOsum;
				
				baseprice = Double.parseDouble(financeingInfomation.getBaseCPrice());
				downpayment = Double.parseDouble(financeingInfomation.getDownpayment());
				sales_Tax = Double.parseDouble(financeingInfomation.getSalesTaxPercent()) * 0.01;

				DecimalFormat format = new DecimalFormat("0.00");
				CalculatorWindow tloan = new CalculatorWindow(baseprice, downpayment, bunkerOptSum, loanPeriod,
						sales_Tax, monthlyRate);

				paymentPlan.setPerMonth(String.valueOf(format.format(tloan.getMonthlyPayment())));
				paymentPlan.setAmount(String.valueOf(format.format(tloan.getTotalLoanAmount())));
				paymentPlan.setFinalTotal(String.valueOf(format.format(tloan.getTotalPayment())));
			}
		}

		private class exitButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}

		private class resetButton implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				
				paymentPlan.setAmount("0.0");
				paymentPlan.setPerMonth("0.0");
				paymentPlan.setFinalTotal("0.0");

				financeingInfomation.setBaseCPrice("0.0");
				financeingInfomation.setDownpayment("0.0");
				financeingInfomation.setSalesTaxPercent("7.0");

				loanTerm.m_24.setSelected(true);
				
				ALD.setSelected(false);
				SSUC.setSelected(true);
				GR.setSelected(false);
			    GRSP.setSelected(false);
			    MA.setSelected(false);
					
				
			}
		}
	}

}