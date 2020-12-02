package swing.comp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Dice extends JPanel {
	
	final static String[] PATHS = {
			"Images/one.jpg",
			"Images/two.jpg",
			"Images/three.jpg",
			"Images/four.jpg",
			"Images/five.jpg",
			"Images/six.jpg"
	};

	public int num;

	public Dice() {
		super(new CardLayout());
		setBackground(Color.black);
		
		try {
			for (int i = 0; i <= 5; ++i) {
				add(Integer.toString(i), new JLabel(new ImageIcon(
						ImageIO
							.read(new File(PATHS[i]))
							.getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		num = 0;
	}

	public void roll() {
		((CardLayout) this.getLayout())
			.show(this, Integer.toString(num = (int)(Math.random() * 6)));
		this.repaint();
	}

}