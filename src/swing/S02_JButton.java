package swing;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_JButton extends JFrame{

	public S02_JButton() {
		
		JButton button1 = new JButton("����������!");
		JButton button2 = new JButton("CLICK ME!");
		JButton button3 = new JButton(new ImageIcon("C:\\Users\\Ahos\\Desktop\\����\\©\\���ѳ�.jpg"));
									// �̹����������� ���鶧 ���� ���� �̹����� ©�� �����Ҽ� ����!
		
		// ��ġ, ũ�� ���� ����
		button1.setBounds(100, 100, 100, 50);
		button2.setBounds(100, 250, 100, 50);
		button3.setBounds(200, 100, 300, 300);
		
		// setText : ������Ʈ�� �ؽ�Ʈ�� ����
		button1.setText("ABCDEFG!");
		button2.setText("����������!");
		
		// setEnable : ��ư Ȱ��/��Ȱ��
		button1.setEnabled(true);
		button2.setEnabled(true);
		
		// ��ư �⺻���� 
		ActionListener basic_btn_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
										// �̺�Ʈ ��ü �Ѱܹ���
				System.out.println("��ư�� ���Ƚ��ϴ�!");
				
				System.out.println("������ư�� ��ü ���� : " + e.getSource());
				
				JButton clicked_btn = (JButton)e.getSource();
				System.out.println("ActionCommand() : " + e.getActionCommand());
				System.out.println("��ư�� �̸� : " + clicked_btn.getText());
			}
		};
		
		// ��ư�� ������ �߰�
		//	- ActionListener �������̽��� ����ü �߰�
		button1.addActionListener(basic_btn_action);		
		button2.addActionListener(basic_btn_action);
		
		add(button1);
		add(button2);
		add(button3);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(3300, 100);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new S02_JButton();
		
	}
}
