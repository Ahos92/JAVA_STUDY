package quiz;

import java.util.Scanner;

public class B01_GuessAge {

	// 사용자로부터 올해의 년도와 나이를 입력 받으면
	// 한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어 보세요.
	public static void main(String[] args) {
		
		System.out.println("###나이 추측 프로그램###");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("올해의 년도를 입력하세요>");
		int thisYear = sc.nextInt();
		System.out.print("태어난 년도를 입력하세요>");
		int birthYear = sc.nextInt();
		
		int age =thisYear-birthYear+1;
		System.out.println("당신의 한국 나이는 "+age+"살 입니다.");

		
		sc.close();
		
		
	}
}
