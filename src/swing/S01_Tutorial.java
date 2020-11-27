package swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S01_Tutorial {

	// # Swing
	//	- JAVA�� ������ ���α׷��� ���� �� �ִ� API

	// # ������Ʈ
	//	- �����̳ʿ� �߰��ϴ� ��ǰ��
	//	- JButton, JTable, JSlider, JMenu ...

	// # �����̳�
	//	- ������Ʈ�� �߰��ϴ� ��
	//	- JFrame, JPanel, JDialog ...
	//	- �����̳� ���� ���̾ƿ��� ������ �� �ִ�.
	
	public static void main(String[] args) {
		
		// # JFrame : ������ â�� �ϳ� �����Ѵ�.
		//	- �پ��� ������Ʈ���� �߰��� �� �ִ� �����̳� �� �ϳ�

		// # JButton
		//	- ��ư ������Ʈ
		//	- ������ �����Ѵ�
		
		JFrame frame = new JFrame("����!");
		//JButton b = new JButton("CLICK");
		
		JButton b = new KaKaoButton(KaKaoBtnEnum.CAMERA, 500);

		// b.setBounds(100, 100, 100, 50);
		b.setLocation(200, 200);
		
		
		frame.add(b);		
		// frame�� �⺻������ �����Ǿ� �ִ� ���̾ƿ��� �����Ѵ�.
		frame.setLayout(null);
		
		// �ش� �������� x��ư�� ������ ���� ������ �����Ѵ�.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������ũ�� ����
		frame.setSize(1000, 1000);
		frame.setLocation(2800, 100);
		// �������� ���̰� ����
		//  - GUIȯ�濡���� ȭ�鿡 ��ȭ�� ������� ���� ���� ȭ���� �ٽ� �׷��� �Ѵ�.
		frame.setVisible(true);
		
	}
	
}
