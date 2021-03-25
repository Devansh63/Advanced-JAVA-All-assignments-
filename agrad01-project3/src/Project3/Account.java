package Project3;

import java.util.Random;

import javax.swing.JOptionPane;

/*
 *  The class handles the account and has all the methods required for any transaction 
 */
public class Account {

	double balance;
	int pin;
	//constructor to start balance and pin 
	public Account() {
		balance = 0.0;
		pin = 0000;
	}
	// constructor to create account 
	public Account(double FirstBalance) {
		balance = FirstBalance;
		createPin();

		javax.swing.JOptionPane.showMessageDialog(null, "Take note of your PIN:\n" + pin, "Client Window",
				javax.swing.JOptionPane.WARNING_MESSAGE);
	}
	// method to return pin
	public int getpin() {
		return pin;
	}
	//method to create pin between 1000 and 9999
	public void createPin() {
		Random r = new Random();

		pin = r.nextInt(9000) + 1000;

	}
	//to check balance
	public void setbalane(double bal) {
		if (bal > 0) {
			this.balance = bal;
		}
	}
	// to display balance
	public void showBalance() {
		String message = String.format("The current balance is \n$%.2f", balance);
		JOptionPane.showMessageDialog(null, message);
	}
	//to deposit into the account
	public void deposit(double amount) {
		balance += amount;
	}
	// check if the withdraw amount is OK and then withdraw money 
	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Required amount exceeds your balance\n" + "You receive your balance,");
			balance = balance - balance;
		} else {
			balance -= amount;
		}
	}

	public double getBalsnce() {
		return balance;
	}
}
