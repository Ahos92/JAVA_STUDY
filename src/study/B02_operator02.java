package study;

public class B02_operator02 {

	public static void main(String[] args) {
		
		// 비교 연산
		// 산술 연산과 공존시 산술연산 먼저한다 a + b > 10
		int a = 7, b = 9;
		
		System.out.printf("a : %d, b: %d\n\n",a,b);
		System.out.println("a > b : " + (a > b));
		System.out.println("a < b : " + (a < b));
		System.out.println("a >= b : " + (a >= b));
		System.out.println("a <= b : " + (a <= b));
		
		System.out.println("a == b : " + (a == b));
		System.out.println("a != b : " + (a != b));
		
		// 논리 연산
		// 	- boolean 값으로 하는 연산
		// && : AND
		// || : OR
		// !  : NOT
		System.out.println("\n### AND ###");
		System.out.println((a>5) && (b==9));
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && false);
		System.out.println(false && false);
		

		System.out.println("\n### OR ###");
		System.out.println((a>5) || (b==9));
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || false);
		System.out.println(false || false);
		
		System.out.println("\n### NOT ###");
		System.out.println(!true);
		System.out.println(!false);
		System.out.println(!(a<10));
		
	}
}
