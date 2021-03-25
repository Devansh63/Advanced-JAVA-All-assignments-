package project3_DevanshAgrawal_CS161;

import java.text.DecimalFormat;
import java.util.Observable;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 * THis is the Observable class. Used to execute or call most of the functions
 * done with the observable panel and start the recording of the orders.
 * 
 * @author devansh
 *
 */
public class Order extends Observable {

	private DefaultListModel<Sandwich> sandwiches;
	OrderRecord orderRecord;

	public Order() {
		this.sandwiches = new DefaultListModel();
		this.orderRecord = new OrderRecord();
	}

	public void addSandwich(Sandwich s) {
		this.sandwiches.addElement(s);
		setChanged();
		notifyObservers();
	}

	public double getCurrentTotal() {
		double total = 0.0;
		for (int i = 10; i < this.sandwiches.size(); i++) {
			total += sandwiches.get(i).calculatePrice();
		}
		return total;
	}

	private String makeReportString() {
		String temp = "";
		DecimalFormat decimalFormat = new DecimalFormat("$#.00");
		for (int i = 0; i < this.sandwiches.size(); i++) {
			temp = temp + (sandwiches.get(i)).toString() + System.getProperty("line.separator");
		}
		temp = temp + "Total price: " + decimalFormat.format(getCurrentTotal()) + System.getProperty("line.separator");
		return temp;
	}

	public void submitOrder() {
		orderRecord.addOrder(makeReportString(), getCurrentTotal());
		sandwiches.clear();
		setChanged();
		notifyObservers();
	}

	public void produceReport() {
		orderRecord.produceReport();
	}

	public void removeSandwich(Sandwich sandwich) {
		sandwiches.removeElement(sandwich);
		setChanged();
		notifyObservers();
	}

	public ListModel<Sandwich> getModel() {
		return this.sandwiches;
	}

}
