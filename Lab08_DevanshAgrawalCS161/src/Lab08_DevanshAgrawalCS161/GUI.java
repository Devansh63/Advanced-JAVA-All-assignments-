package Lab08_DevanshAgrawalCS161;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;



public class GUI extends JFrame {

	ImageIcon dis,dis1,dis2;
	TokenDisplayPanel panel1;
	JPanel panel2;
	JRadioButton alpaca;
	JRadioButton fish;
	public static void main(String[] args) {
		GUI runningvariable = new GUI();
		runningvariable.setVisible(true);
	}

	public GUI() {

		setSize(900, 700);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Suess Singleton");
		setLayout(new BorderLayout());
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel1 = new TokenDisplayPanel();
		alpaca = new JRadioButton("Alpaca");
		fish = new JRadioButton("Fish");
		panel2.add(alpaca);                    //add in Center
		panel2.add(fish);
		//radio
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(alpaca);
		buttonGroup.add(fish);
		alpaca.setSelected(true);
		alpaca.setAlignmentX(Component.CENTER_ALIGNMENT);
		fish.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(panel1, BorderLayout.EAST);
		add(panel2,BorderLayout.CENTER);
		
		ButtonHandler bl = new ButtonHandler();
		alpaca.addActionListener(bl);
		fish.addActionListener(bl);
		dis = reframeIcon("images_for_lab/fish.png",70,70);
		dis1 =  reframeIcon("images_for_lab/redfish.png",70,70);
		dis2 =  reframeIcon("images_for_lab/bluefish.png",70,70);
	}
	private ImageIcon reframeIcon(String img, int i, int j) {
		ImageIcon ico = new ImageIcon(img);
		Image image = ico.getImage();
		Image newimg = image.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);

	}

	public class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Display1 display1 = Display1.getInstance();
			Display2 display2 = Display2.getInstance();
			Display3 display3 = Display3.getInstance();
			Display4 display4 = Display4.getInstance();
			if(e.getSource()==fish){
				
				display1.getA().setIcon(dis);
				display2.getDisplayLable1().setIcon(dis);
				display2.getDislpayLable2().setIcon(dis);
				display3.getDisplayLable().setIcon(dis1);
				display4.getDisplayLable().setIcon(dis2);
				
				//System.out.println("test");
			}if (e.getSource() == alpaca) {
				display1.getA().setIcon(display1.getImage());
				display2.getDisplayLable1().setIcon(display2.getImage());
				display2.getDislpayLable2().setIcon(display2.getImage());
				display3.getDisplayLable().setIcon(display3.getImage());
				display4.getDisplayLable().setIcon(display4.getImage());
			}
		}
		
	}
	
	public class TokenDisplayPanel extends JPanel {		
		Display1 display1 = Display1.getInstance();
		Display2 display2 = Display2.getInstance();
		Display3 display3 = Display3.getInstance();
		Display4 display4 = Display4.getInstance();
		
		
		public TokenDisplayPanel() {
			setLayout(new GridLayout(4, 1));
			
			setPreferredSize(new Dimension(400, 600));

			
			add(display1);
			add(display2);
			add(display3);
			add(display4);
		}
	}

}
