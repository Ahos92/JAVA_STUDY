package quiz.diceimage;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class MouseRightClick extends MouseAdapter {

	JPopupMenu popup;
	Component comp;
	
	public MouseRightClick(JPopupMenu popup, Component comp) {
		this.popup = popup;
		this.comp = comp;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			int x = e.getX();
			int y = e.getY();
			popup.show(comp, x, y);
		}
	}	
	
}
