package project3_DevanshAgrawal_CS161;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * This is the Observer class. Used to Create the Last Panel. Holds the
 * actionhandelers for 2 buttons in this panel. Also used to keep the Orders
 * values updated. I believe i have an error in that method.
 * 
 * @author devansh
 *
 */
public class OrderView extends JPanel implements Observer {
	private JTextField orderPriceField;
	private JList<Sandwich> sandwichList;
	private DecimalFormat df;
	private Order order;
	private JLabel orderLabel;
	private JButton placeOrder, deletesandwich;
	JScrollPane sandwichlist;

	public OrderView(Order o) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		order = o;
		sandwichList = new JList<Sandwich>(order.getModel());
		sandwichlist = new JScrollPane(sandwichList);
		;
		add(sandwichlist, BorderLayout.CENTER);
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(2, 2));
		add(buttonpanel, BorderLayout.SOUTH);
		orderLabel = new JLabel(" Total Order Price:");
		buttonpanel.add(orderLabel);
		placeOrder = new JButton("Place Order");
		placeOrder.setMnemonic(KeyEvent.VK_P);
		buttonpanel.add(placeOrder);
		orderPriceField = new JTextField();
		orderPriceField.setEditable(false);
		buttonpanel.add(orderPriceField);
		deletesandwich = new JButton("Delete Sandwich");
		deletesandwich.setMnemonic(KeyEvent.VK_D);
		buttonpanel.add(deletesandwich);

		placeOrder.addActionListener(new OrderViewController());
		deletesandwich.addActionListener(new OrderViewController());

	}

	private class OrderViewController implements ActionListener {
		private OrderViewController() {
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Place Order")) {
				OrderView.this.order.submitOrder();
			} else if (e.getActionCommand().equals("Delete Sandwich")) {
				OrderView.this.order.removeSandwich((Sandwich) OrderView.this.sandwichList.getSelectedValue());
			}
		}
	}

	public void update(Observable observable, Object object) {
		df = new DecimalFormat("$##.00");
		;
		double sum = 0.0;

		for (int i = 0; i < order.getModel().getSize(); i++) {
			sum += order.getModel().getElementAt(i).calculatePrice();
		}

		if (sum == 0.0) {
			orderPriceField.setText("");
		} else {
			orderPriceField.setText(df.format(sum));
		}

		;
	}

}
