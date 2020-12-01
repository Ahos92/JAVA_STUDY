package swing.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class FirstAction implements ActionListener{

	Container card_panel;

	public FirstAction(Container card_panel) {
		this.card_panel = card_panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) card_panel.getLayout()).first(card_panel);

	}
}
