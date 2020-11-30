package swing.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class NextAction implements ActionListener{

	JPanel panel;
	
	public NextAction(JPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).next(panel);
		
	}
}
