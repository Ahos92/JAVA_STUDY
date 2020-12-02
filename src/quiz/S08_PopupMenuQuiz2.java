package quiz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import swing.comp.Dice;
import swing.mouse.evt.RightClickShowPopup;

public class S08_PopupMenuQuiz2 extends JFrame {
	
	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("주사위");
	JPopupMenu popup = new JPopupMenu();
	JMenuItem popup_item_reroll = new JMenuItem("reroll");
	
	public S08_PopupMenuQuiz2() {					
		JPanel dice_panel = new JPanel(new GridLayout(1, 5, 5, 5));
		ArrayList<Dice> dices = new ArrayList<>(5);
		
		for (int i = 0; i < 5; ++i) {
			dices.add(new Dice());
			dice_panel.add(dices.get(i));
		}
		dice_panel.addMouseListener(new RightClickShowPopup(popup, dice_panel));
		dice_panel.setBackground(Color.black);
		
		JButton reroll_btn = new JButton("다시 굴리기");		
		reroll_btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Dice dice : dices) {
					dice.roll();
				}
				
				ArrayList<Integer> counts = new ArrayList<>();
				for (int i = 0; i < 5; ++i) {
					int num = dices.get(i).num;
					System.out.println("주사위" + i + ": " + dices.get(i).num);
					counts.set(num, counts.get(num) + 1);
				}

			}
		});
		
		setJMenuBar(bar);
		bar.add(menu);
		
		popup.add(popup_item_reroll);
		menu.add(popup_item_reroll);
		
		add(dice_panel, BorderLayout.CENTER);
		add(reroll_btn, BorderLayout.SOUTH);
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(3000, 100);
		setSize(500, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new S08_PopupMenuQuiz2();
	}

}