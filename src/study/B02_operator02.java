package study;

public class B02_operator02 {

	public static void main(String[] args) {
		
		// �� ����
		// ��� ����� ������ ������� �����Ѵ� a + b > 10
		int a = 7, b = 9;
		
		System.out.printf("a : %d, b: %d\n\n",a,b);
		System.out.println("a > b : " + (a > b));
		System.out.println("a < b : " + (a < b));
		System.out.println("a >= b : " + (a >= b));
		System.out.println("a <= b : " + (a <= b));
		
		System.out.println("a == b : " + (a == b));
		System.out.println("a != b : " + (a != b));
		
		// �� ����
		// 	- boolean ������ �ϴ� ����
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
