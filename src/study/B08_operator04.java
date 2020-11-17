package study;

public class B08_operator04 {

	public static void main(String[] args) {
		
		// 대입 연산
		// = : 왼쪽 변수에 오른쪽값 대입
		int num = 10;
		num = num+5;
		System.out.println(num);
		System.out.println();
		
		num = 10;
		// 복합 대입 연산 
		// - 누적시키는 연산
		num += 5; 
			System.out.println(num);
		num -= 2; 
			System.out.println(num);
		num *= 2; 
			System.out.println(num);
		num /= 4; 
			System.out.println(num);
		num %= 6; 
			System.out.println(num);
		System.out.println();
		
		num = 10;
		// 단항 연산
		num++; 
			System.out.println(num);		
		++num; 
			System.out.println(num);
		num--;
			System.out.println(num);
		--num;
			System.out.println(num);
		// ++, -- 위치에따라 결과가다름 , 앞에 있을경우 먼저실행
		int a = 3, b = 10;
		int result = ++a*b;
		System.out.println(result);
		System.out.println(a);
	}
}
