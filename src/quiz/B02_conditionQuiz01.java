package quiz;

public class B02_conditionQuiz01 {

	public static void main(String[] args) {
		
		/*
		[ 알맞은 비교연산을 만들어보세요 ]
		    
		1. int형 변수 a가 10보다 크고 20보다 작을 때 true
		2. int형 변수 b가 짝수일 때 true		
		3. int형 변수 c가 7의 배수일 때 true
		4. int형 변수 hour가 0이상 24미만이고 12이상일 때 true	
		5. int형 변수 d와 e의 차이가 30일 때 true	
		6. int형 변수 year가 400으로 나누어 떨어지거나 
		   또는 4로 나누어 떨어지고 100으로 나누어떨어지지 않을 때 true
		7. 민수가 철수보다 2살 많으면 true
		8. 민수가 철수보다 생일이 3달 빠르면 true  
 		9. boolean형 변수 powerOn이 false일 때 true
		10. 문자열 참조변수 str이 "yes"일 때 true
		11. 삼각형 A가 직각삼각형이면 true
	*/
	
		int a=15;
		System.out.println("1번 : "+(a > 10 && a < 20));
		
		int b=250;
		System.out.println("2번 : "+(b % 2 == 0));
		
		int c=49;
		System.out.println("3번 : "+(c % 7 == 0));
		
		int d=-10, e=20;
		System.out.println("5번 : "+(Math.abs(d-e) == 30));
		
		int hour=13;
		System.out.println("4번 : "+((!(hour < 0 && hour >= 24))&&(hour > 12)));
		
		int year=2020;
		System.out.println("6번 : "+(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)));
		
		int minsuAge=15, chulsuAge=13;
		System.out.println("7번 : "+(minsuAge - chulsuAge == 2));
		
		int minsuBirth=7 , chulsuBirth=10;
		System.out.println("8번 : "+(chulsuBirth - minsuBirth == 3));
		
		boolean powerOn = false;
		System.out.println("9번 : "+(!powerOn));
		
		// 참조형 비교
		String str ="yes";
		System.out.println("10번 : "+str.equals("yes")); // 값을 통한 비교 equals
		// String str2 = "yes"; 				str == str2 // 주소 비교1 true
		// String str3 = new String("yes"); 	str == str3 // 주소 비교2 false
		
		int b1 = 3, b2 = 4, b3 = 5;
		System.out.println("11번 : "+ (b1*b1 == b2*b2 + b3*b3 ||
									   b2*b2 == b1*b1 + b3*b3 ||
									   b3*b3 == b2*b2 + b1*b1));
		
		int a1 = 30, a2 = 60, a3 = 90; //각도
		System.out.println(a1 + a2 + a3 == 180 && (a1 == 90 || a2 == 90 || a3 == 90));
		
	}
}
