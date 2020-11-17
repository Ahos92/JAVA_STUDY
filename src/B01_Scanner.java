
import java.util.Scanner;
// java.lang은 기본이라 안해도됨
// 같은 패키지 소스는 import안해도 쓸수있음

import quiz.A01_printQuiz;

public class B01_Scanner {

	// Scanner 클래스
	//	- 외부 입력 기능들 모여있는 클래스
	//	- 어디서 입력박을지 결정한 뒤 다양한방법으로 입력받을 수 있
	//	- console 입력 System.in

	public static void main(String[] args) {
		
//		A01_printQuiz.main(null); // 다른 패키지
//		A00_Hello.main(null); // 동일 패키지
		
		// 스캐너 생성시 입력받을 곳 지정
		Scanner sc = new Scanner(System.in);
		// next()
		//	- 통로에 존재하는 다음 값을 하나만 꺼낸다
		//	- 타입을 바꾸지 않는다 (String)
		
		//next타입()
		//	- 통로에 존재하는 다음 정수값 하나만을 해당타입으로 읽어온다.
		//	- 통로에 아무값도 없다면 입력이 될때까지 기다린다.
		//	- 통로에 존재하는 다음 값이 해당타입 값이 될수 없을 때 에러
		
		// nextLine()
		//	- 통로에 존재하는 값들 중 한 줄을 가져온다.
		//	- 줄을 구분하는 기준은 \n(엔터)
		System.out.println("아무 값이나 입력해보세요 >");
		int num = sc.nextInt();
		System.out.println("입력 받은 값 : "+num);
		System.out.println(num + 10);
		System.out.println(num - 10);
		System.out.println(num * 10);
		System.out.println(num % 10);
		System.out.println(num / 10);
		//스페이스로 여러개를 동시에 대기 시킬수있음 , 따로 입력해도됨
		int num2 = sc.nextInt();
		System.out.println("두번째 값 : "+num2);
		
		sc.close();
	}
}
