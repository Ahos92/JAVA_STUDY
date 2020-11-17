package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C12_InputRightThing {

	// 사용자로부터 int타입의 데이터를 입력 받고 출력해보세요.
	// 잘못된 타입 데이터가 들어오더라도 프로그램이 종료되지 않아야 합니다.
	// 올바르게 int가 입력된 경우 프로그램 종료
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("숫자를 입력해 주세요 >");
			
			// 예외처리 자체를 함수로 처리해버리기도 가능
			try {

				int data = input.nextInt();

				System.out.println("프로그램 종료!\n입력 하신 숫자는 " + data + "입니다.");
				break;

			} catch (InputMismatchException e) {
				System.err.println("\t(숫자만 입력해 주세요.)");
				input.nextLine(); // 초기화
			}

		}
		
	}

}
