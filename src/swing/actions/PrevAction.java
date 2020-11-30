package swing.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PrevAction implements ActionListener {

	JPanel panel;

	public PrevAction(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) panel.getLayout()).previous(panel);

	}
}
