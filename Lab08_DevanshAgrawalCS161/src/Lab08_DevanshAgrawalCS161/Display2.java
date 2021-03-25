package Lab08_DevanshAgrawalCS161;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Display2 extends JPanel {
	JLabel displayLable1 , dislpayLable2;
	ImageIcon image;
	private volatile static Display2 display2;
	
	public static Display2 getInstance() {
		if(display2 == null) {
			synchronized(Display2.class) {
				if(display2 == null)
					display2 = new Display2();
			}
		}
		return display2;
	}
	public Display2(){
		setLayout(new GridLayout(1, 2));
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(new LineBorder(Color.BLACK));
		image = reframeIcon("images_for_lab/alpaca.png",70,70);
		displayLable1 = new JLabel(image);
		add(displayLable1);
		dislpayLable2 = new JLabel(image);
		add(dislpayLable2);
	}
	
	private ImageIcon reframeIcon(String img, int i, int j) {
		ImageIcon ico = new ImageIcon(img);
		Image image = ico.getImage();
		Image newimg = image.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}
	public JLabel getDisplayLable1() {
		return displayLable1;
	}
	public void setDisplayLable1(JLabel displayLable1) {
		this.displayLable1 = displayLable1;
	}
	public JLabel getDislpayLable2() {
		return dislpayLable2;
	}
	public void setDislpayLable2(JLabel dislpayLable2) {
		this.dislpayLable2 = dislpayLable2;
	}public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	
}
