package study;
import java.util.Random;

public class B12_random {

	public static void main(String[] args) {

		// JAVA에서 무작위 숫자 생성하기

		// 1. Math.random()
		//	- Double 타입의 0 <= x < 1 인 랜덤 소수를 생성.
		//	- 이 소수를 이용 하여 원하는 숫자를 만들어서 사용

		// 원하는 숫자를 만드는 절차 (ex 80~100)
		// 	1. 원하는 숫자의 개수를 곱한다. ( * 21)
		//	2. 원하는 숫자 중 가장 작은 숫자를 더한다. ( + 80)
		//	3. 소수점 아래를 삭제 ( int typecasting ....)
				for(int i = 0; i < 10; ++i) {
					System.out.print((int)(Math.random() * 21 + 80)+" ");
				}

		// 2. Random 클래스를 이용
		//	- 생성할 때 원하는 시드번호 선택가능
		//	- 같은 시드 번호로 생성하면 같은 값
		//	- 시드번호를 전달하지 않으면 무작위 시드 선택
				
		Random ran = new Random();
		
		//Random.nextInt(bound); : 원하는 범위의 정수를 반환한다.
		// 0~ bound 미만의 정수를 반환한다.
		//	bound 값을 설정하지 않으면 int범위 전체에서 랜덤 정수가 선택된다.
		System.out.println("\nran.nextInt(30) :"+ran.nextInt(30)); // 0 ~ 29
		System.out.println("ran.nextInt() : "+ran.nextInt());			//int 전체
		System.out.println("ran.nextInt(21)+80 : "+ran.nextInt(21)+80); // 80 ~ 100
		
		// 연습 : 3000이상 5000이하의 랜덤 정수를 100번 생성하고
		//		그동안 나왔던 가장 큰 수와 가장 작은 수를 출력해보세요.

		int max_num = 0, min_num = 0;
		int line = 0;

		for(int i = 0; i < 100; ++i) {

			int num = (int)(Math.random() * 2001 + 3000);
			
			if(i == 0) {
				max_num = num;
				min_num = num;
			}
			else{ 
				max_num = max_num < num ? num : max_num;

				min_num = Math.min(min_num, num);
			}
			System.out.printf("%-5d", num);
			
			line++;
			if(line == 10) {
				System.out.println();
				line = 0;
			}

		}
		System.out.printf("\n3000 ~ 5000 랜덤 숫자중 \n가장 큰  숫자 : %d\n가장 작은 숫자 : %d ", max_num, min_num);

	}
	
	//

}
