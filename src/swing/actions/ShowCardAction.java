package swing.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class ShowCardAction implements ActionListener{

	Container card_panel;
	String card_name;
	JLabel pic_label;
	
	public ShowCardAction(Container card_panel, JLabel pic_label, String card_name) {
		this.card_panel = card_panel;
		this.card_name = card_name;
		this.pic_label = pic_label;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) card_panel.getLayout()).show(card_panel, card_name);
		pic_label.setText(card_name);
	}
	
	
}
