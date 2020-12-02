package quiz;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import quiz.diceimage.*;

public class S08_PopupMenuQuiz extends JFrame {

	// 화면에 5개의 주사위를 띄우고
	// 팝업메뉴, 메뉴바, 버튼에 REROLL기능을 달아보세요

	// 어느곳에 있는 REROLL을 누르던 간에 주사위가 변해야 합니다.
	final static String[] PATHS = {
			"Images/one.jpg",
			"Images/two.jpg",
			"Images/three.jpg",
			"Images/four.jpg",
			"Images/five.jpg",
			"Images/six.jpg"
	};

	final static ArrayList<ImageIcon> images = new ArrayList<>();	
	static {
		for (String path : PATHS) {
			setImageIcon(path);
		}	
	}	

	ArrayList<JLabel> labels = new ArrayList<>();
	{
		for (int i = 0; i < 5; i++) {
			labels.add(new JLabel(images.get((int)(Math.random()*6))));			
		}
	}

	private static void setImageIcon(String path) {
		try {
			images.add(new ImageIcon(ImageIO
					.read(new File(path))
					.getScaledInstance(70, 70, Image.SCALE_SMOOTH)
					)
					);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	JPanel center_panel = new JPanel(new GridLayout(1, 5, 10, 10));
	JPanel south_panel = new JPanel(new FlowLayout());

	JPopupMenu popup = new JPopupMenu();
	JMenuItem reroll_popup = new JMenuItem("POPUP REROLL");

	JMenuBar mbar = new JMenuBar();
	JMenu menu = new JMenu("menu");
	JMenuItem reroll_menu = new JMenuItem("MENU REROLL");

	JButton reroll_btn = new JButton("BTN REROLL");

	public S08_PopupMenuQuiz() throws IOException {	
		
		setLayout(new BorderLayout());

		for (int i = 0; i < labels.size(); i++) {
			center_panel.add(labels.get(i));
		}

		south_panel.add(reroll_btn);

		popup.add(reroll_popup);
		mbar.add(menu);
		menu.add(reroll_menu);
	
		addMouseListener(new MouseRightClick(popup, this));	

		reroll_btn.addActionListener(new RerollAction(labels, images));

		reroll_menu.addActionListener(new RerollAction(labels, images));

		reroll_popup.addActionListener(new RerollAction(labels, images));

		add(center_panel, BorderLayout.CENTER);
		add(south_panel, BorderLayout.SOUTH);
		add(mbar, BorderLayout.NORTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1300, 100);
		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			new S08_PopupMenuQuiz();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 창 크기
	//	f.addComponentListener(new ComponentAdapter() {
	//		@Override
	//		public void componentResized(ComponentEvent e) {
	//			System.out.println("프레임 가로 : " + f.getWidth());
	//			System.out.println("프레임 세로 : " + f.getHeight());
	//		}
	//	});

}
