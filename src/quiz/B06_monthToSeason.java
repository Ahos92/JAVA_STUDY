package quiz;

import java.util.Scanner;

public class B06_monthToSeason {

	// switch 문 이용
	//사용자로부터 달을 입력 받으면 해당하는 계절을 출력
	public static void main(String[] args) {
		
		System.out.println("계절 확인 프로그램");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("달을 입력해 주세요 > ");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("겨울 입니다.");
			break;
		case 3: case 4: case 5:
			System.out.println("봄 입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름 입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println("가을 입니다.");
			break;
		default :
			System.out.println("1~12까지의 숫자만 입력해주십시오.");
			break;
		}
		sc.close();
	}
}
