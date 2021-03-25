package project3_DevanshAgrawal_CS161;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

/**
 * Used to create the main gui, adds sandwichs to the list, also calls the
 * factory class. 
 * 
 * check max fowler solution to the price erorr. Miss match in  calling a function and the loop logic .
 * 
 * 
 * @author devansh
 *
 */
public class SandwichShopView extends JFrame {
	SandwichFactory sandwichFacotry;
	JMenuBar menuBar;
	JMenu menu;
	JButton addaSandwich;
	JMenuItem menuItem;
	JRadioButton sub, wrap, deli;
	JCheckBox turkey, ham, kraken, tomato, cucumber, pepper, pickle;
	Order order;
	OrderView orderView;

	/**
	 * THe main class that holds the Looks and Feel code. I have used the build path
	 * method to add the external library that is required.
	 * 
	 * @author devansh
	 *
	 */
	public static void main(String[] sandwiches) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
			SandwichShopView sandwichShopView = new SandwichShopView();
			sandwichShopView.setVisible(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public SandwichShopView() {
		setSize(2000, 1200);
		setTitle("Max's Sandwich Shack");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("File");
		menuBar.add(menu);
		addaSandwich = new JButton("Add a Sandwich");
		menuBar.add(addaSandwich);
		menuItem = new JMenuItem("Exit");
		menu.add(menuItem);
		getContentPane().setLayout(new GridLayout(1, 3));
		JPanel subPanel = new JPanel();
		subPanel.setBorder(new TitledBorder(null, "Sandwich Type"));
		getContentPane().add(subPanel);
		JPanel toppingPanel = new JPanel();
		toppingPanel.setBorder(new TitledBorder(null, "Toppings"));
		subPanel.setLayout(new GridLayout(3, 0, 0, 0));
		sub = new JRadioButton("Sub Sandwich");
		subPanel.add(sub);
		wrap = new JRadioButton("Wrap");
		subPanel.add(wrap);
		deli = new JRadioButton("Deli Sandwich");
		subPanel.add(deli);
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(sub);
		buttongroup.add(wrap);
		buttongroup.add(deli);
		getContentPane().add(toppingPanel);
		toppingPanel.setLayout(new GridLayout(7, 1, 0, 0));
		turkey = new JCheckBox("Turkey ");
		ham = new JCheckBox("Ham ");
		kraken = new JCheckBox("Kraken ");
		tomato = new JCheckBox("Tomato ");
		cucumber = new JCheckBox("Cucumber ");
		pepper = new JCheckBox("Pepper ");
		pickle = new JCheckBox("Pickle ");
		toppingPanel.add(turkey);
		toppingPanel.add(ham);
		toppingPanel.add(kraken);
		toppingPanel.add(tomato);
		toppingPanel.add(cucumber);
		toppingPanel.add(pepper);
		toppingPanel.add(pickle);
		order = new Order();
		orderView = new OrderView(order);
		getContentPane().add(orderView);
		addaSandwich.addActionListener(new ActionHandler());
		menuItem.addActionListener(new ActionHandler());
		sandwichFacotry = new SandwichFactory();

	}
	

	private class ActionHandler implements ActionListener {
		private ActionHandler() {
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Add a Sandwich")) {
				callTheFactory();
			} else if (e.getActionCommand().equals("Exit")) {
				SandwichShopView.this.order.produceReport();
				System.exit(0);
			}
		}
	}

	private void callTheFactory() {

		String sub = "";
		if (this.wrap.isSelected()) {
			sub = "Wrap";
		} else if (this.deli.isSelected()) {
			sub = "Deli";
		} else if (this.sub.isSelected()) {
			sub = "Sub";
		}
		ArrayList<String> toppingList = new ArrayList();
		if (this.ham.isSelected()) {
			toppingList.add("Ham");
		}
		if (this.turkey.isSelected()) {
			toppingList.add("Turkey");
		}
		if (this.kraken.isSelected()) {
			toppingList.add("Kraken");
		}
		if (this.tomato.isSelected()) {
			toppingList.add("Tomato");
		}
		if (this.pepper.isSelected()) {
			toppingList.add("Pepper");
		}
		if (this.pickle.isSelected()) {
			toppingList.add("Pickle");
		}
		if (this.cucumber.isSelected()) {
			toppingList.add("Cucumber");
		}
		order.addSandwich(sandwichFacotry.makeASandwich(sub, toppingList));
	}

}