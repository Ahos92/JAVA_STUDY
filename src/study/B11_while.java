package study;
import java.util.Scanner;

public class B11_while {

	public static void main(String[] args) {
		
		// 증가값의 위치에 따라 반복의 결과가 달라질 수 있다.
		
		int i = 0;
		while(i < 10) {
			++i;
			System.out.println("Hello, while ! "+i);
		}
		
		// while문만 사용하게끔설계된 클래스
		// 	- has, next 수식어가붙은 메서드
		// 		ex) Scanner ...
		
		// System.in - 콘솔을 통해 입력을 하는 통로(inputStream)
		Scanner sc1 = new Scanner("apple banana orange"); // 문자열을 통해 스캐너에 입력
		Scanner sc2 = new Scanner("dog cat rat bird ");
		
		// sc1에 다음 내용이 있는동안 출력
		while(sc1.hasNext()) {
			System.out.println(sc1.next()); // 통로에서 하나꺼내라
		}
		
		while(sc2.hasNext()) {
			System.out.println(sc2.next()); // 통로에서 하나꺼내라
		}
		
		// while 문을 통한 프로그램
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 계속하기");
			System.out.println("2. 종료하기");
			int cmd = sc.nextInt();
			
			switch (cmd) {
			case 1:
				System.out.println("계속합니다.");
				break;
			case 2:
				System.out.println("종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("올바른 선택이 아닙니다.");
				break;
			}
			
		}
		
	}
}
