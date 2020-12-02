package swing.mouse.evt;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class RightClickShowPopup extends MouseAdapter {

	private JPopupMenu popup;
	private Component comp;
	
	public RightClickShowPopup(JPopupMenu popup, Component comp) {
		this.popup = popup;
		this.comp = comp;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			popup.show(comp, e.getX(), e.getY());
		}
	}
}