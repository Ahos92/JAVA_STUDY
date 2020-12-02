package quiz.diceimage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import quiz.S08_PopupMenuQuiz;

public class RerollAction implements ActionListener{

	ArrayList<ImageIcon> images;
	ArrayList<JLabel> labels;

	public RerollAction(ArrayList<JLabel> labels, ArrayList<ImageIcon> images) {
		this.images = images;
		this.labels = labels;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " ´­¸²");
		for (int i = 0; i < labels.size(); i++) {
			labels.get(i).setIcon(images.get((int)(Math.random()*6)));
		}
	}
	
}
