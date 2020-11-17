package quiz;

import java.util.Scanner;

public class B10_NextPrime {

	
	//사용자로부터 숫자를 입력
	// 입력받은 수보다  더크거나 같은 다음 소수를 찾아서 출력해보세요
	
	public static void main(String[] args) {
		
		System.out.print("수 입력 >");
		int num = new Scanner(System.in). nextInt();
		
		int prime = 0;
		
		for(int i = num; true; ++i) {
			
			int check = 0;
			int sqrt = (int)Math.sqrt(i);
			for(int j = 2; j <= sqrt; ++j) {
				
				if(i % j == 0) {
					++check; 
				}
			}
			
			if(check == 0) {
				if(num <= 0 || num == 1) {
					i = 2;
				}	
				prime = i;
				System.out.printf("\'%d\'보다 크거나 같은 다음 소수는 \'%d\'입니다.", num, prime);
				break;
			}
		}
		
		
	}
}
