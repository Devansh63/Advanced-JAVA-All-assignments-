package Lab08_DevanshAgrawalCS161;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Display3 extends JPanel {

	JLabel displayLable;
	ImageIcon image;

	public volatile static Display3 display3;

	public static Display3 getInstance() {
		if (display3 == null) {
			synchronized (Display3.class) {
				if (display3 == null)
					display3 = new Display3();
			}
		}
		return display3;
	}

	public Display3() {
		setBorder(new LineBorder(Color.BLACK));
		image = reframeIcon("images_for_lab/redalpaca.png",70,70);
		displayLable = new JLabel(image);
		add(displayLable);
	}

	

	private ImageIcon reframeIcon(String img, int i, int j) {
		ImageIcon ico = new ImageIcon(img);
		Image image = ico.getImage();
		Image newimg = image.getScaledInstance(i, j, Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}

	public JLabel getDisplayLable() {
		return displayLable;
	}

	public void setDisplayLable(JLabel displayLable) {
		this.displayLable = displayLable;
	}
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
}
