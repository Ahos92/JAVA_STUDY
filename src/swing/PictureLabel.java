package swing;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PictureLabel extends JLabel {

	public PictureLabel(PictureEnum picture) {
		super(new ImageIcon(picture.image
									.getScaledInstance(400, 400, Image.SCALE_SMOOTH)));	
	}
}
