package swing;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.*;
import javax.swing.*;

import swing.actions.ContainerAction;
import swing.actions.ShowCardAction;

public class S07_JMenu extends JFrame {

	// My Code
//	final static String[] PATHS = {
//			"Images\\Main.jpg",
//			"Images\\Coffe.jpg",
//			"Images\\Tea.jpg",
//			"Images\\Smoothie.jpg",
//			"Images\\Cake.jpg",
//			"Images\\Sandwich.jpg",
//			"Images\\Macaron.jpg"
//	};
//	
//	final static ArrayList<ImageIcon> images = new ArrayList<>();
//	
//	static {
//	
//		for (String path : PATHS) {
//			setImageIcon(path);
//		}	
//	}
//	
//	private static void setImageIcon(String path) {
//		try {
//			images.add(new ImageIcon(ImageIO
//										.read(new File(path))
//											.getScaledInstance(500, 500, Image.SCALE_SMOOTH)
//									)
//						);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	final static ArrayList<String> imageNames = new ArrayList<>();
//	static {
//		
//		for (String name : PATHS) {
//			imageNames.add(name.substring(7, name.length()-4));
//		}
//	}
	
	public S07_JMenu() {
		MySwingTools.initTestFrame(this);
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("메인");
//		JMenu sub_menu = new JMenu("디저트");
//		
//		JMenuItem i1, i2, i3;
//		JMenuItem s1, s2, s3;
//		
//		i1 = new JMenuItem("Coffe");
//		i2 = new JMenuItem("Tea");
//		i3 = new JMenuItem("Smoothie");
//	
//		s1 = new JMenuItem("Cake");
//		s2 = new JMenuItem("Sandwich");
//		s3 = new JMenuItem("Macaron");
//		
		// My code
//		CardLayout cards = new CardLayout();
//		JPanel p = new JPanel(cards);
//		JLabel label = new JLabel();
//		Container c = this.getContentPane();
//		
//		setLayout(cards);
//		
//		for (int i = 0; i < PATHS.length; i++) {
//			add(imageNames.get(i), new JLabel(images.get(i)));
//			p.add(label);
//		}
//		
//		i1.addActionListener(new ContainerAction(cards, c));
//		i2.addActionListener(new ContainerAction(cards, c));
//		i3.addActionListener(new ContainerAction(cards, c));
//		
//		s1.addActionListener(new ContainerAction(cards, c));
//		s2.addActionListener(new ContainerAction(cards, c));
//		s3.addActionListener(new ContainerAction(cards, c));
//	
//		menu.add(i1);
//		menu.add(i2);
//		menu.add(i3);
//
//		sub_menu.add(s1);
//		sub_menu.add(s2);
//		sub_menu.add(s3);
//		
//		menu.add(sub_menu);

		

		setJMenuBar(bar);	

		setLayout(new BorderLayout());
		
		
		JPanel center_panel = new JPanel();
		JLabel pic_label = new JLabel("메인");
		center_panel.setLayout(new CardLayout(20, 20));
		
		menu.addActionListener(new ShowCardAction(center_panel, pic_label, PictureEnum.MAIN.kName));
		
		for (PictureEnum picname : PictureEnum.values()) {
			center_panel.add(picname.kName, new PictureLabel(picname));
			
			JMenuItem item = new JMenuItem(picname.kName);
			item.addActionListener(new ShowCardAction(center_panel, pic_label, picname.kName));
			menu.add(item);
			menu.addSeparator();
		}
		
		bar.add(menu);
		
		add(center_panel, BorderLayout.CENTER);
		add(pic_label, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new S07_JMenu();
		
	}
	
}
