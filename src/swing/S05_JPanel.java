package swing;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swing.actions.*;

public class S05_JPanel extends JFrame {

	final static String[] PATHS = {
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\아이씻팔.jpg",
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\어서오고.jpg",
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\초능력.jpg",
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\둘리 물.jpg",
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\선넘네.jpg",
			"C:\\Users\\Ahos\\Desktop\\사진\\짤\\둘리웃음.png"
	};

	final static ArrayList<String> imageNames = new ArrayList<>();
	static {
		
		for (String name : PATHS) {
			imageNames.add(name.substring(27, name.length()-4));
		}
	}
	
	public S05_JPanel() {		
		MySwingTools.initTestFrame(this);

		Container c = this.getContentPane();

		// # JPanel
		//	- 프레임 위에추가로 붙일 수 있는 컨테이너
		//	- 새로운 컨테이너 역할을 하는 컴포넌트		
		JPanel south_panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		JPanel center_panel = new JPanel(new CardLayout(10, 10));
		
		// 1. center_panel에 이미지 몇장을 더 추가해 보세요
		// 2. south_panel에 first, last, previous 버튼을 추가해보세요
		JButton next_btn = new JButton("next");
		next_btn.addActionListener(new NextAction(center_panel));
		
		JButton first_btn = new JButton("first"); 
		first_btn.addActionListener(new FirstAction(center_panel));
		
		JButton last_btn = new JButton("last"); 
		last_btn.addActionListener(new LastAction(center_panel));

		JButton prev_btn = new JButton("prev"); 
		prev_btn.addActionListener(new PrevAction(center_panel));

		// # MVC 패턴
		//	- Model 
		//		데이터를 꺼내거나 저장할 때 사용하는 클래스들을 따로 지칭하는 말, 데이터의 형태를 정의
		//	- View
		//		사용자에게 제공할 화면을 구성하는 클래스들을 따로 지칭하는 말
		//	- Controller
		//		사용자의 입력을 처리하는데 필요한 클래스들을 따로 지칭하는 말
		//		(1) 비즈니스 로직 - 비즈니스마다 달라지는 처리
		//		(2) DAO(Data Access Object) - 데이터베이스(또는 파일시스템)의 데이터에 접근하는 기능
		
		// 사용자 -> View -> Controller -> Model -> DB
		
		/* # 분할 안할시 문제점
			1. 현재소스에서 lastAction, firstAction ...이 controller로 분류될 수 있다.
			2. 현재 소스는 화면표현(View) 코드와 로직담당(Controller) 코드가 섞여있다.
			3. 
		*/
		
		this.setLayout(new BorderLayout(0, 0));
		this.add(center_panel, BorderLayout.CENTER);
		this.add(south_panel, BorderLayout.SOUTH);

		// center_panel은 cardlayout
		for (int i = 0; i < PATHS.length; i++) {
			center_panel.add(imageNames.get(i), new JLabel(new ImageIcon(PATHS[i])));
		}
		
		// south_panel은 flowlayout
		south_panel.add(first_btn);
		south_panel.add(next_btn);
		south_panel.add(prev_btn);
		south_panel.add(last_btn);
	}

	public static void main(String[] args) {
		new S05_JPanel();		
	}
}
