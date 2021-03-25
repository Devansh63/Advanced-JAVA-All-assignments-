package Project3;

import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 * This class handles the withdraw and deposits of an account if the account exists or is created.
 * it also checks if the deposit amount and bills r acceptable.
 */
public class ATM {

	Account acc;
	Scanner keyboard = new Scanner(System.in);

	public ATM(Account x) {
		acc = x;
	}

	public void transaction() {
		String input = null;

		input = JOptionPane.showInputDialog(null, "Please enter W or w to withdraw\n" + "Enter D or d for deposit",
				"Input", JOptionPane.QUESTION_MESSAGE);

		if (input == null) {
			System.out.println("Ends the withdraw and deposit process.");
			return;
		}

		if (input.equals("W") || input.equals("w")) {
			System.out.println("Please enter the PIN code here");
			int pinCode = keyboard.nextInt();

			if (pinCode == acc.getpin()) {

				String withdrawAmountStr;
				withdrawAmountStr = null;
				String messageCancellation = "The process of openning account is ended,"
						+ "\n If you wish, restarting the program. Thank you!";

				String currentBalanceBeforeW = String.format(
						"The account Balance is " + "%.2f. \nPlease enter the amount\nyou want to withdraw",
						acc.getBalsnce());
				withdrawAmountStr = JOptionPane.showInputDialog(null, currentBalanceBeforeW, "Input",
						JOptionPane.QUESTION_MESSAGE);

				if (withdrawAmountStr == null) {
					System.out.println(messageCancellation);
					System.exit(0);
				}
				int withdrawAmount = Integer.parseInt(withdrawAmountStr);

				acc.withdraw(withdrawAmount);

				acc.showBalance();
			} else {
				System.out.println("Wrong PIN, trancsaction is aborted");
			}
		}

		if (input.equals("D") || input.equals("d")) {
			JOptionPane.showMessageDialog(null, "We accept the following dollar bills:" + "\n 1, 5, 10, 20, 50, 100\n"
					+ "Please insert the bills on the console\n" + "Enter any other number to stop depositing");

			System.out.println("Enter bills 1, 5, 10, 20, 50, 100 here: " + "\n(To end depositing enter any digit"
					+ "other than dollar bills' number.)");

			boolean validAmount = true;
			int sumTheBills = 0;

			while (validAmount) {
				int billValue = keyboard.nextInt();

				if ((billValue == 1) || (billValue == 5) || (billValue == 10) || (billValue == 20) || (billValue == 50)
						|| (billValue == 100)) {
					sumTheBills += billValue;
				} else {
					validAmount = false;
				}
			}
			acc.deposit(sumTheBills);

			acc.showBalance();
		}
	}
}
