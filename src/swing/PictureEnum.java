package swing;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public enum PictureEnum {

	MAIN("메인", "Images/Main.jpg"),
	COFEE("커피", "Images/Coffe.jpg"),
	TEA("차", "Images/Tea.jpg"),
	SMOOTHIE("스무디", "Images/Smoothie.jpg"),
	CAKE("케이크", "Images/Cake.jpg"),
	SANDWICH("샌드위치", "Images/Sandwich.jpg"),
	MACARON("마카롱", "Images/Macaron.jpg");
	

	String kName;
	String img_path;
	Image image;
	
	PictureEnum(String kName, String img_path) {
		this.kName = kName;
		this.img_path = img_path;
		try {
			this.image = ImageIO.read(new File(img_path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static ImageIcon createIcon() {
		return new ImageIcon();
	}
	
}
