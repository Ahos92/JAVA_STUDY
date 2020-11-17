
public class A05_print {

	public static void main(String[] args) {

		// console에 출력하기위한 함수

		// 1. print 기본
		System.out.print("Hello, world");
		System.out.print("Hello, world");
		System.out.print("Hello, world");

		// 2. println 자동줄바꿈
		//  - \n이 자동으로 적용
		//	- 공란 일시 \n만 출력
		System.out.println();
		System.out.println("Hello, world!");
		System.out.println("Hello, world!");
		System.out.println("Hello, world!");

		// 3. printf
		//	- 서식(format) 문자를 이용해 출력 가능한 함수 / 자동줄바꿈X 
		//	- %d	: 10진수 정수 (decimal)
		//	- %x,X	: 16진수 정수 (hexa decimal) / 소문자, 대문자 원하는걸로 출력
		// 	- %o	: 8진수 정수 	(octal)
		//	- %s	: 문자열 		(String)
		//	- %c	: 문자		(Character)
		//	- %f	: 실수		(float) / %.10f 옵션가능
		// ex)2020년 10월 20일
		int year = 2020;
		int month = 10;
		int day = 20;
		System.out.printf("%d년 %d월 %d일\n", year,month,day);
		System.out.printf("%x %X\n", 10, 10);
		System.out.printf("%.10f\n", 123.456789);
		System.out.printf("당신의 신용등급은 '%s'입니다.\n", "1등급");
		System.out.printf("%d[%c], %x(16), %o(8)\n", 65, 65, 65, 65);

		//# 서식문자 옵션 ★★★
		//		※ d만 해당되는것은 아님
		//	%숫자d : 숫자만큼 칸을 확보한 뒤 오른쪽 정렬 출력
		System.out.printf("이름 : %15s\n", "Hong Gildong");
		System.out.printf("나이 : %15d\n", 15);
		// 넘어가면 안된다
		System.out.printf("이름 : %15s\n", "Hoooooooooooooooong Gildong");
		
		//	%-숫자d : 숫자만큼 칸을 확보한 뒤 왼쪽 정렬 출력
		System.out.printf("%-10s : Hong Gildong\n", "Fullname");
		System.out.printf("%-10s : 15\n", "Age");
		
		// %0숫자d : 숫자 만큼 칸을 확보한 뒤 0을 빈칸에 채워 출력 (%d, %f 만적용)
		System.out.printf("%010d\n", 123);
		System.out.printf("%010f\n", 123.123);
		
		// %+숫자d : 양수 앞에 부호를 출력
		System.out.printf("오늘은 섭씨 %+d℃입니다.\n", -5);
		System.out.printf("오늘은 섭씨 %+d℃입니다.\n", 20);
		
		// %.숫자f : 소수 자릿수를 설정
		System.out.printf(".3\t:%.3f\n", 123.123);
		System.out.printf("default\t:%f\n", 123.123);
		System.out.printf(".10\t:%.10f\n", 123.123);
		System.out.printf(".20\t:%.20f\n", 123.123);
		System.out.printf(".255\t:%.255f\n", 123.123);

	}

}
