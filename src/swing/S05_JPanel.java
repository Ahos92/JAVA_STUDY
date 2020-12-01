package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swing.actions.*;

public class S05_JPanel extends JFrame {

	final static String[] PATHS = {
			"Images\\Main.jpg",
			"Images\\Coffe.jpg",
			"Images\\Tea.jpg",
			"Images\\Smoothie.jpg",
			"Images\\Cake.jpg",
			"Images\\Sandwich.jpg",
			"Images\\Macaron.jpg"
	};

	final static ArrayList<String> imageNames = new ArrayList<>();
	static {

		for (String name : PATHS) {
			imageNames.add(name.substring(7, name.length()-4));
		}
	}
	final static ArrayList<ImageIcon> images = new ArrayList<>();

	static {

		for (String path : PATHS) {
			setImageIcon(path);
		}	
	}

	private static void setImageIcon(String path) {
		try {
			images.add(new ImageIcon(ImageIO
					.read(new File(path))
					.getScaledInstance(300, 300, Image.SCALE_SMOOTH)
					)
					);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public S05_JPanel() {		
		MySwingTools.initTestFrame(this);

		Container c = this.getContentPane();

		// # JPanel
		//	- ������ �����߰��� ���� �� �ִ� �����̳�
		//	- ���ο� �����̳� ������ �ϴ� ������Ʈ		
		JPanel south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel center_panel = new JPanel(new CardLayout(20, 20));

		// 1. center_panel�� �̹��� ������ �� �߰��� ������
		// 2. south_panel�� first, last, previous ��ư�� �߰��غ�����
		JButton next_btn = new JButton("next");
		next_btn.addActionListener(new NextAction(center_panel));

		JButton first_btn = new JButton("first"); 
		first_btn.addActionListener(new FirstAction(center_panel));

		JButton last_btn = new JButton("last"); 
		last_btn.addActionListener(new LastAction(center_panel));

		JButton prev_btn = new JButton("prev"); 
		prev_btn.addActionListener(new PrevAction(center_panel));

		// # MVC ����
		//	- Model 
		//		�����͸� �����ų� ������ �� ����ϴ� Ŭ�������� ���� ��Ī�ϴ� ��, �������� ���¸� ����
		//	- View
		//		����ڿ��� ������ ȭ���� �����ϴ� Ŭ�������� ���� ��Ī�ϴ� ��
		//	- Controller
		//		������� �Է��� ó���ϴµ� �ʿ��� Ŭ�������� ���� ��Ī�ϴ� ��
		//		(1) ����Ͻ� ���� - ����Ͻ����� �޶����� ó��
		//		(2) DAO(Data Access Object) - �����ͺ��̽�(�Ǵ� ���Ͻý���)�� �����Ϳ� �����ϴ� ���

		// ����� -> View -> Controller -> Model -> DB

		/* # ���� ���ҽ� ������
			1. ����ҽ����� lastAction, firstAction ...�� controller�� �з��� �� �ִ�.
			2. ���� �ҽ��� ȭ��ǥ��(View) �ڵ�� �������(Controller) �ڵ尡 �����ִ�.
			3. 
		 */

		this.setLayout(new BorderLayout(0, 0));
		this.add(center_panel, BorderLayout.CENTER);
		this.add(south_panel, BorderLayout.SOUTH);

		// center_panel�� cardlayout
		for (int i = 0; i < PATHS.length; i++) {
			center_panel.add(imageNames.get(i), new JLabel(images.get(i)));
		}

		// south_panel�� flowlayout
		south_panel.add(first_btn);
		south_panel.add(next_btn);
		south_panel.add(prev_btn);
		south_panel.add(last_btn);
	}

	public static void main(String[] args) {
		new S05_JPanel();		
	}
}
