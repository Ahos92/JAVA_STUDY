package swing.actions;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContainerAction implements ActionListener{
	
	CardLayout cards;
	Container contain;
	
	public ContainerAction(CardLayout cards, Container contain) {
		this.cards = cards;
		this.contain = contain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(contain, e.getActionCommand());
	}
}
