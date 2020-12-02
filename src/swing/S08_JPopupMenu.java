package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class S08_JPopupMenu {

	public static void main(String[] args) {
		JFrame f = new JFrame();

		JPopupMenu popup = new JPopupMenu("Edit");
		JMenuItem copy = new JMenuItem("복사");
		JMenuItem cut = new JMenuItem("잘라내기");
		JMenuItem paste = new JMenuItem("붙여넣기");

		popup.add(copy);
		popup.add(cut);
		popup.add(paste);

		copy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("복사를 선택 했습니다.");
			}
		});
		
		cut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("잘라내기를 선택했습니다.");
			}
		});
		
		// 마우스 이벤트 처리
		f.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// e.getButton() 어느 마우스 버튼이 눌렸는지 번호로 알려준다
				if (e.getButton() == MouseEvent.BUTTON3) {
					int x = e.getX();
					int y = e.getY();
					//				System.out.printf("(%d, %d) 눌림\n", x, y);
					popup.show(f, x, y);
				}
			}
		});	

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(1300, 100);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);

	}
}
