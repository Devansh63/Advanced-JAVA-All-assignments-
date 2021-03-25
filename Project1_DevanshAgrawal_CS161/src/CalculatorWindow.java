/* Devansh Agrawal
 * CS 161 Project 1
 */
// Class holds all the Calculations that occur.
//Recieves values from all the classes and sets the calculated values in the desiered areas.
public class CalculatorWindow {
    double totalLoanAmount, monthlyPayment, totalPayment, intRate,sales_Tax_Rate=0.07;
    int loan_Term=24;
     
    /**REcieving the values*/
    public CalculatorWindow(double base_Price,double down_Payment, double option_Costs,int time,double tax,double iRate){
        double sales_Tax_Amount;
        loan_Term=time;
        sales_Tax_Rate=tax;
        intRate=iRate;
        sales_Tax_Amount=(base_Price-down_Payment+option_Costs)*sales_Tax_Rate;							//required calculations
        totalLoanAmount=base_Price-down_Payment+option_Costs+sales_Tax_Amount;
        double rate=intRate/12;
        monthlyPayment=totalLoanAmount*rate/(1-(Math.pow(1/(1+rate), loan_Term)));
        totalPayment=monthlyPayment*loan_Term+down_Payment;
    }
 
    /**setters and getters*/
    public double getTotalLoanAmount() {
        return totalLoanAmount;
    }
 
    public void setTotalLoanAmount(double totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }
 
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
 
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
 
    public double getTotalPayment() {
        return totalPayment;
    }
 
    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
 
    public double getInterest() {
        return intRate;
    }
 
    public void setInterest(double interest) {
        this.intRate = interest;
    }
 
    public double getSalesTax() {
        return sales_Tax_Rate;
    }
 
    public void setSalesTax(double salesTax) {
        this.sales_Tax_Rate = salesTax;
    }
 
    public int getLoanTerm() {
        return loan_Term;
    }
 
    public void setLoanTerm(int loanTerm) {
        this.loan_Term = loanTerm;
    }
     
}