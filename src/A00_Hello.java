/**
 *  문서화 주석
 *	(이클립스가 이 설명을 읽어준다)
 */

// public class 의 이름은 파일명과 반드시 같아야한다.
public class A00_Hello {
	
	/* main 함수
	 *  - 프로그램의 시작 지점
	 *  - 프로그램 시작시 가장먼저 main()함수를 찾아서 실행
	 */
	public static void main(String[] args) {
		
		// System.out.println() 함수
		// ()안에 전달한 데이터를 콘솔에 출력
		System.out.println();
		System.out.println("	Hello, world!");
		System.out.println("	안녕");
		System.out.println("	★★★★★★");
		System.out.println("┌─────────────────────┐");
		System.out.println("│		      │");
		System.out.println("│	1.start	      │");
		System.out.println("│		      │");
		System.out.println("│	2.exit        │");
		System.out.println("│		      │");
		System.out.println("└─────────────────────┘");
		
		//자바의 데이터들
		// 1. ""사이에 적는것 : 문자열 (String)
		 System.out.println("Aa가~家");
		 
		 //2. 숫자 (int, Integer)
		 System.out.println(123);
		 System.out.println(123+321);
		 System.out.println(123*2231);
		 
		 
		 //3. 실수 (Double, Float)
		 System.out.println(123.456);
		 System.out.println(123.456f);// float
		 
		 //4. ''사이에 적는것 : 문자(Character), 문자하나(여러개 에러)
		 System.out.println('d');
		 System.out.println('ㄱ');
		 System.out.println('가');
		 System.out.println('家');
		 System.out.println('§');

		// ※ 다른타입 + 정수 = 이어붙인 문자열
		 System.out.println("123"+456);
		 System.out.println("일이삼"+456);
		 
		 // 실수 + 정수 = 실수
		 System.out.println(123.456f + 78);
		 
		 // 문자+ 정수 = 숫자
		 System.out.println('한'+90);
		 
		 //
		 System.out.println("家의 코드 값 :"+(int)'家');
		 System.out.println("$의 코드 값 :"+(int)'$');
		 System.out.println("\'가'의 코드 값 :"+(int)'가');
		 
		 //
		 System.out.println((char)23478);
		 System.out.println((char)36);
		 System.out.println((char)44032);
		 
		 // ; 한 명령어가 끝났음을 알림.
		 //////
	}
	
}
