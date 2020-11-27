package quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class S02_ImageButtonQuiz extends JFrame{

	// kakao1.png�� �̿��� 12���� ��ư�� �����غ�����
	
	// 2������ 
	BufferedImage source;

	JButton[][] btns;
	private static int btn_width;
	private static int btn_height;

	public S02_ImageButtonQuiz() {

		JButton test = new JButton();

		try {
			source = ImageIO.read(new File("C:\\Users\\Ahos\\Desktop\\����\\���� �̹���\\1fby-6t-555d.png"));

			System.out.println("�ʺ�: " + source.getWidth());
			System.out.println("����: " + source.getHeight());

			System.out.println("��ĭ �ʺ� : " + source.getWidth());
			System.out.println("���� : " + source.getHeight() / 550);
			
			
			
			btn_width = source.getWidth();
			btn_height = (int) source.getHeight() / 566;
			
			btns = new JButton[1][566];

			int col = 0 ;
			int row = 0 ;
			for (int i = 0; i < btns.length; ++i) {

				for (int j = 0; j < btns[i].length; ++j) {
					btns[i][j] = new JButton();
					btns[i][j].setSize(btn_width, btn_height);
					btns[i][j].setLocation(col * btn_height, row * btn_height);
					btns[i][j].setIcon(new ImageIcon(source.getSubimage(0, j * btn_height, btn_width, btn_height)));
					add(btns[i][j]);
					row++;
					if (row == 22) {
						col++;
						row = 0;
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(2800, 100);
		setSize(btn_height * 27, btn_height * 24);
		setVisible(true);

	}

	//  My ��ȿ�� �ҽ�
	//	Image image;
	//	ImageIcon soruce;
	//	
	//	int[][]	division;
	//	private static int icon_width;
	//	private static int icon_height;
	//
	//	public JButton makeIcon(ImageIcon sourcefile, int x, int y, int width, int height) {
	//		image = sourcefile.getImage();
	//		image = createImage(new FilteredImageSource(image.getSource(),
	//				new CropImageFilter(x, y, width, height)));
	//		
	//		JButton btn = new JButton(new ImageIcon(image));
	//
	//		return btn;
	//	}
	//	
	//	public S02_ImageButtonQuiz() {
	//		soruce = new ImageIcon("C:\\Users\\Ahos\\Desktop\\����\\���� �̹���\\kakao1.png");
	//		// ��ǥ��� �迭
	//		division = new int[2][6];
	//		icon_width = soruce.getIconWidth() / 6;
	//		icon_height = soruce.getIconHeight() / 2;
	//		
	//		JButton btns = new JButton();
	//
	//		for (int i = 0; i < division.length; i++) {
	//			
	//			for (int j = 0; j < division[i].length; j++) {
	//				btns = makeIcon(soruce, j * icon_width, i * icon_height, icon_width, icon_height);
	//				btns.setSize(icon_width, icon_height);
	//				btns.setLocation(j * icon_width, i * icon_height);
	//				add(btns);
	//			}
	//		}
	//		
	//		setLayout(null);
	//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	//		setLocation(2800, 100);
	//		setSize(1000, 500);
	//		setVisible(true);
	//	}
	//
	public static void main(String[] args) {

		new S02_ImageButtonQuiz();

	}
}
