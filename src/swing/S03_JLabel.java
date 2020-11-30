package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class S03_JLabel extends JFrame {

	// ��������
	// 	��ư�� �ϳ� �߰��ϰ�, �� ��ư�� ������ ��� �׸��� �ٳ����� ���ϵ��� ����� ������
	// 	(�ٽ� ������ ����� �˴ϴ�.)
	final static String[] PATHS = {
				"C:\\Users\\Ahos\\Desktop\\����\\©\\���̾���.jpg",
				"C:\\Users\\Ahos\\Desktop\\����\\©\\�����.jpg",
				"C:\\Users\\Ahos\\Desktop\\����\\©\\�ʴɷ�.jpg",
				"C:\\Users\\Ahos\\Desktop\\����\\©\\�Ѹ� ��.jpg",
				"C:\\Users\\Ahos\\Desktop\\����\\©\\���ѳ�.jpg",
				"C:\\Users\\Ahos\\Desktop\\����\\©\\�Ѹ�����.png"
	};
	
	// ArrayList�� �̸� ImageIon���� ����� ���´�.
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
	
	private int curr_image = 0;
	
	public S03_JLabel() throws IOException {		
		// JLabel : �ؽ�Ʈ, �׸� ���� ���� �� �ִ� ������Ʈ
		JLabel label01 = new JLabel("Hello, Java GUI!!");
		JLabel label02 = new JLabel(images.get(curr_image));
		
		JButton btn1 = new JButton("�̹��� ����");
		btn1.setBounds(350, 150, 150, 150);
		
//		JFrame myframe = this;
		
		btn1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				label02.setIcon(images.get(++curr_image % images.size()));
//				myframe.getContentPane().setBackground(Color.black);
			}
		});
		
		label01.setBounds(50, 50, 500, 50);
		label02.setBounds(50, 120, 300, 300);
		label02.setBorder(BorderFactory.createLineBorder(Color.black, 2, true)); // �׵θ�
		
		// ������Ʈ���� �۲� ����
		// 	�󺧿��� �ɸ� �ش� �󺧸� ���� , �����ӿ� �ɸ� �ش���������ü
		label01.setFont(new Font("Courier", Font.PLAIN, 35));
		add(label01);
		add(label02);
		
		add(btn1);
		
		//
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocation(3000, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			new S03_JLabel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
