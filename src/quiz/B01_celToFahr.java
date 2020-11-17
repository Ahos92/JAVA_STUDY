package quiz;

import java.util.Scanner;

public class B01_celToFahr {

	public static void main(String[] args) {
		// 사용자로부터 섭씨 온도를 입력받으면 화씨로 변환 해주는 프로그램
		
		System.out.println("### 온도 변환 프로그램 ###");

		System.out.print("섭씨온도(℃)를 입력해주세요. > ");
//		Scanner sc = new Scanner(System.in);		
//		double celc = sc.nextDouble();
		
		// 스캐너 한번만 사용할경우 이렇게 사용하기도함 , 대신 다시 사용 할경우 통로 하나 다시 만들어줘야함
		double celc = new Scanner(System.in).nextDouble();
		
		double fahr = (celc*9/5) + 32;
		
		System.out.printf("화씨온도(℉) : %.1f℉", fahr);
		
		

	}

}
