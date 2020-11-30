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

	// 연습문제
	// 	버튼을 하나 추가하고, 그 버튼을 누르면 사과 그림이 바나나로 변하도록 만들어 보세요
	// 	(다시 누르면 사과가 됩니다.)
	final static String[] PATHS = {
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\아이씻팔.jpg",
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\어서오고.jpg",
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\초능력.jpg",
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\둘리 물.jpg",
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\선넘네.jpg",
				"C:\\Users\\Ahos\\Desktop\\사진\\짤\\둘리웃음.png"
	};
	
	// ArrayList에 미리 ImageIon들을 만들어 놓는다.
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
		// JLabel : 텍스트, 그림 등을 적을 수 있는 컴포넌트
		JLabel label01 = new JLabel("Hello, Java GUI!!");
		JLabel label02 = new JLabel(images.get(curr_image));
		
		JButton btn1 = new JButton("이미지 변경");
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
		label02.setBorder(BorderFactory.createLineBorder(Color.black, 2, true)); // 테두리
		
		// 컴포넌트들의 글꼴 설정
		// 	라벨에만 걸면 해당 라벨만 적용 , 프레임에 걸면 해당프레임전체
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
