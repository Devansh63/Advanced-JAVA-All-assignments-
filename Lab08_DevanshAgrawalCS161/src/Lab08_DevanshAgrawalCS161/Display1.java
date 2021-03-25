package Lab08_DevanshAgrawalCS161;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Display1 extends JPanel {
	JLabel a;
	ImageIcon image;
	

	private volatile static Display1 display1;
	
	public static Display1 getInstance() {
		if(display1 == null) {
			synchronized(Display1.class) {
				if(display1 == null)
					{display1 = new Display1();
					}
			
			}
		}
		return display1;
	}
	public Display1(){
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(new LineBorder(Color.BLACK));		
		image = reframeIcon("images_for_lab/alpaca.png",70,70);
		a = new JLabel(image);
		a.setHorizontalAlignment(JLabel.LEFT);
		add(a);
		
	}
	

	private ImageIcon reframeIcon(String img, int i, int j) {
		ImageIcon ico = new ImageIcon(img);
		Image image = ico.getImage();
		Image newimg = image.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);

	}

	public JLabel getA() {
		return a;
	}

	public void setA(JLabel a) {
		this.a = a;
	}
	
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	
	
}
