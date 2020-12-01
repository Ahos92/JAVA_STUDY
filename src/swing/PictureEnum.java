package swing;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public enum PictureEnum {

	MAIN("����", "Images/Main.jpg"),
	COFEE("Ŀ��", "Images/Coffe.jpg"),
	TEA("��", "Images/Tea.jpg"),
	SMOOTHIE("������", "Images/Smoothie.jpg"),
	CAKE("����ũ", "Images/Cake.jpg"),
	SANDWICH("������ġ", "Images/Sandwich.jpg"),
	MACARON("��ī��", "Images/Macaron.jpg");
	

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
