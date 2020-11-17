
public class A02_variable {

	/* # 변수
	 *  - 데이터를 미리담아놓고 사용할 수 있는 공간
	 *  - 변수 타입 미리지정 (선언, declare) - int, String ...
	 *  - 
	 */
	
	public static void main(String[] args) {
		
		// =의 의미 프로그래밍언어에선 대입
		int a; 
		a = 10;
		System.out.println(a);
		System.out.println(a+10);
		System.out.println(a*3);
		System.out.println(a+a+a+a);
		
		// JAVA에서는 선언하지않은 변수 사용 불가
		// {}내부에 선언한 변수는 벗어나면 소멸
//		b = 33;
//		System.out.println(b);
		
		// 선언 방법
		int num1;
		int num2, num3, num4; 
		int num5 = 99; 
		int num6 = 7, num7 = 31, num8 = 900;
		
		// 값이 대입하지 않은 변수는 사용x
		// 맨처음 값을 대입하는 것을 초기화(initialize)
		num1 = 123;
		System.out.println("num1 : "+num1);
		System.out.println("num5 : "+num5);
		System.out.println("num6 : "+num6);
		System.out.println("num7 : "+num7);
		System.out.println("num8 : "+num8);
		
		
	}

}
