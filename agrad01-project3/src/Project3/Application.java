package Project3;

//import java.io.IOException;

import javax.swing.JOptionPane;

/*
 * Devansh Agrawal
 * CS 160 - 07,Fall Semester 2018
 * Project 3: At the ATM Machine                                 
 * 
 * Description: Acts like an ATM machine by giving the user options of creating an account and withdrawing and depositing in it repeatedly
 */
/*
 * This is the main interface of the program and helps the user navigate their actions 
 */
public class Application {
	
	public static void main(String[] args) {//throws IOException
		Account acc = null;
		ATM atm = null;
		
		boolean client = true;
		boolean transactionRequired;
		
		while(client) {
			
		    transactionRequired = true;
			int openAnAcc = JOptionPane.showConfirmDialog(null,
							"Would you like to open an account?\n"
						  + "The minimun deposit is 100 dollars.\n"
						  + "If you have an account please click Cancel",
						     "Client window", JOptionPane.YES_NO_CANCEL_OPTION);
			if(openAnAcc == JOptionPane.YES_OPTION) {
				String inputAmount;
				
				inputAmount = null;
				inputAmount =  JOptionPane.showInputDialog(
							"Please enter the amount for deposit at least $100.\n"
						  + "Please take note a PIN code will be issued for you. ");
				
				boolean inputValid = false;
				
				while(!inputValid)
				{
					if(Double.parseDouble(inputAmount)>=100) {
						inputValid=true;
					}else {
						inputAmount = null;
						inputAmount =  JOptionPane.showInputDialog(
								" Please enter the amount for deposit,\n"
								+"Please enter the amount for deposit at least $100.\n"
							  + "Please take note a PIN code will be issued for you. ");
					}
				}
				acc =new Account(Double.parseDouble(inputAmount));
				atm = new ATM(acc); 
			}
			else if(openAnAcc == JOptionPane.NO_OPTION){
				System.out.println("The program is terminated\n Thank you!");
				System.exit(0);
			} else if (acc == null)
			{
			
				transactionRequired = false;
				client = false;
		}else 
		{
			atm = new ATM(acc);
		}
			while(transactionRequired) {
				int yes_no = JOptionPane.showConfirmDialog(null,
						          "Please click Yes for a trasaction\n"
								+ "Click no to exit current process",
								 "Client Window ", JOptionPane.YES_NO_OPTION);
				if(yes_no == JOptionPane.NO_OPTION) {
					transactionRequired = false;
				} else {
					atm.transaction();
				}
			}
		
		
		
	}

}
}
