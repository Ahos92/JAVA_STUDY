package quiz;

import java.util.Scanner;

public class B11_reverse_number {

	// 정수를 하나 입력받고
	// 그 정수를 일의 자리부터 순서대로 출력해보세요

	public static void main(String[] args) {

		int num = 68123;

		int reversed = 0 ;
		
		while(true) {
			reversed += num % 10;
			num /= 10;
			
			if(num <= 0) {
				break;
			}
			
			reversed *= 10;
		}
		System.out.println(reversed);
	}
}
