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
		
		JButton button1 = new JButton("눌러보세요!");
		JButton button2 = new JButton("CLICK ME!");
		JButton button3 = new JButton(new ImageIcon("C:\\Users\\Ahos\\Desktop\\사진\\짤\\선넘네.jpg"));
									// 이미지아이콘을 만들때 따로 빼서 이미지를 짤라서 생성할수 있음!
		
		// 위치, 크기 설정 동시
		button1.setBounds(100, 100, 100, 50);
		button2.setBounds(100, 250, 100, 50);
		button3.setBounds(200, 100, 300, 300);
		
		// setText : 컴포넌트의 텍스트를 변경
		button1.setText("ABCDEFG!");
		button2.setText("눌러보세요!");
		
		// setEnable : 버튼 활성/바활성
		button1.setEnabled(true);
		button2.setEnabled(true);
		
		// 버튼 기본동작 
		ActionListener basic_btn_action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
										// 이벤트 객체 넘겨받음
				System.out.println("버튼이 눌렸습니다!");
				
				System.out.println("눌린버튼의 전체 정보 : " + e.getSource());
				
				JButton clicked_btn = (JButton)e.getSource();
				System.out.println("ActionCommand() : " + e.getActionCommand());
				System.out.println("버튼의 이름 : " + clicked_btn.getText());
			}
		};
		
		// 버튼에 동작을 추가
		//	- ActionListener 인터페이스의 구현체 추가
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
