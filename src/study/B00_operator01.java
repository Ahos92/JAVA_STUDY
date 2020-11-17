package study;

public class B00_operator01 {

	public static void main(String[] args) {
		
		// 연산자 operator
		
		// 산술 연산자
		int a = 10, b=7;
		double c =7.0;
		System.out.printf("a = %d, b = %d\n",a,b);
		// 연산 우선순위
		System.out.println("+ : "+(a + b));
		System.out.println("- : "+(a - b));
		System.out.println("X : "+ a * b);
		
		// 정수 끼리 나누면 몫만 나온다.
		System.out.println(a / b);
		System.out.println(a / c);
		System.out.println(a / (double)b);
		System.out.println(a % b); // 나머지
		
		System.out.println("제곱  : "+Math.pow(10, 3)); // 제곱 double 타입
		System.out.println("제곱근 : "+Math.sqrt(2));// 제곱근
		System.out.println("절대값 : "+Math.abs(-20));// 절대값
		System.out.println("반올림 : "+Math.round(1.234));// 반올림
		System.out.println("올림  : "+Math.ceil(1.001));
		System.out.println("내림  : "+Math.floor(1.999));
		System.out.println("더 큰 숫자 : "+Math.max(a, b));
		System.out.println("더 작은 숫자 : "+Math.min(a, b));
		
		System.out.println(a ^ b); // 제곱이 아니다 (XOR - 서로 다르면 1)
		
		
	}
		
}
