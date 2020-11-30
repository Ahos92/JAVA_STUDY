package swing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KaKaoButton extends JButton{

	static BufferedImage source = null;
	static HashMap<KaKaoBtnEnum, Image> images;
	
	final static int SOURCE_IMAGE_COL = 6;
	final static int SOURCE_IMAGE_ROW = 2;
	
	static int SOURCE_IMAGE_WIDTH;
	static int SOURCE_IMAGE_HEIGHT;
	
	static {
		images = new HashMap<>();
		try {
			source = ImageIO.read(new File("C:\\Users\\Ahos\\Desktop\\국비지원과정\\수업 자료\\kakao1.png"));

			SOURCE_IMAGE_WIDTH = source.getWidth() / SOURCE_IMAGE_COL;
			SOURCE_IMAGE_HEIGHT = source.getHeight() / SOURCE_IMAGE_ROW;
			
			KaKaoBtnEnum[] enums =KaKaoBtnEnum.values();
			
			int i = 0;
			for (int col = 0; col < SOURCE_IMAGE_COL; col++) {
				for (int row = 0; row < SOURCE_IMAGE_ROW; row++) {
					images.put(enums[i++], source.getSubimage(
							SOURCE_IMAGE_WIDTH * col, SOURCE_IMAGE_HEIGHT * row, 
							SOURCE_IMAGE_WIDTH, SOURCE_IMAGE_HEIGHT));
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	ArrayList<ImageIcon> btn;
	

	KaKaoBtnEnum type;

	public KaKaoButton(KaKaoBtnEnum type) {
		this.type = type;
		setSize(100);

		// My
//		int iconWidth = source.getWidth() / IMAGE_COL;
//		int iconHeight = source.getHeight() / IMAGE_ROW;
//		btn = new ArrayList<>(12);
//
//		for (int col = 0; col < IMAGE_COL; col++) {
//			for (int row = 0; row < IMAGE_ROW; row++) {
//				Image cropped = source.getSubimage(iconWidth * col, iconHeight * row, iconWidth, iconHeight);
//				ImageIcon n =new ImageIcon(cropped);			
//				btn.add(n);
//			}
//		}
//
//		for (int i = 0; i < btn.size(); i++) {			
//			if (type.ordinal() == i) {
//				setIcon(btn.get(i));
//			}
//		}		
		
	}
	
	
	public KaKaoButton(KaKaoBtnEnum type, int size) {
		this.type = type;
		setSize(size);
	}

	private void setSize(int size) {
		super.setSize(size, size);
		super.setIcon(new ImageIcon(
				images.get(type).getScaledInstance(
						size, 
						size,
						Image.SCALE_SMOOTH)
				)
				// getScaledInstance
		);
	}
}
