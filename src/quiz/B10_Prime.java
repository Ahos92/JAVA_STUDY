package quiz;

import java.util.Scanner;

public class B10_Prime {

	// 사용자로부터 숫자를 입력받으면
	// 1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해보세요.

	// 소수 - 약수가 1과 자기 자신밖에 없는 숫자

	public static void main(String[] args) {

		System.out.print("소수 구하는 프로그램\n숫자 입력 > ");
		int num = new Scanner(System.in).nextInt();


		int prime_count = 0;


		for(int i = 2; i <= num; ++i) {
			int prime_check = 0;
			int sqrt = (int)Math.sqrt(i);
			
			for(int j = 2; j <= sqrt ; ++j){
				
				if(i % j == 0) {
					++prime_check; 
				}
			}
			
			if(prime_check == 0) {
				System.out.println(i);
				++prime_count;
			}

		}

		System.out.printf("1부터 %d까지 사이의 소수는 %d개 입니다.", num, prime_count);

	}
}
