package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class S06_JTextField extends JFrame {

	public S06_JTextField() {	
		JTextField input01;
		JLabel label01 = new JLabel();
		
		input01 = new JTextField("���⿡ �ƹ��ų� �Է��ϼ���!");
		this.getContentPane().add(input01);
		add(label01);
		
		input01.setBounds(20, 20, 200, 50);
		label01.setBounds(20, 100, 300, 300);
		
		// KeyAdapter : KeyListener�� ���� �������� �ʵ��� �߻�Ŭ������ �ٲ���� Ŭ����
		input01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("input01 keyReleased! by KeyAdapter!");
				
				System.out.println("KeyChar : " + e.getKeyChar());
				System.out.println("KeyCode : " + e.getKeyCode());
				switch (e.getKeyCode()) {
				case 37: label01.setText(label01.getText() + '��');
					break;
				case 38: label01.setText(label01.getText() + '��');
					break;
				case 39: label01.setText(label01.getText() + '��');
					break;
				case 40: label01.setText(label01.getText() + '��');
					break;
					
				}
			}
		});
		
//			new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) { // Ű���忡�� ���� ����
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) { // Ű ���� ��
//			}
//		}

		
			// TextField�� �׼� ������ EnterŰ
		input01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��� �Է� �� �� : " + e.getActionCommand());

				input01.setText("");
			}
		});
		
		// setVisible ������ �츮���� ���̴� ȭ���� �׸���.
		MySwingTools.initTestFrame(this);
	}
	
	public static void main(String[] args) {
		new S06_JTextField();
	}
	
}
