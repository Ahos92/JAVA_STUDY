package swing.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class LastAction implements ActionListener{
	
	JPanel panel;

	public LastAction(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).last(panel);

	}
}
