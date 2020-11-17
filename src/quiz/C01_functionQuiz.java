package quiz;

public class C01_functionQuiz {

	// 다음 함수를 정의 해보세요
	// 1. 전달한 문자가 알파벳이면 true 아니면 false
	// 2. 전달한 숫자가 3의 배수이면 true 아니면 false
	// 3. 숫자를 한 개 전달하면 문자열 "짝수입니다" 또는 "홀수입니다" 반환
	// 4. 전달한 숫자가 소수인지 아닌지 판별 함수 (boolean)
	// 5. 숫자를 전달하면 해당숫자의 팩토리얼 결과
	//		factorial : (n)*(n-1)*(n-2) ... 3*2*1
	// 6. 숫자 두개(a, b)를 전달하면 a의 b제곱을 반환하는 함수
	//		(0제곱은 1을 반환, Math.pow금지)

	public static boolean alphabetCheck(char text) {
		return (text >= 'A' && text <= 'Z') || (text >= 'a' && text <= 'z');
		//		if((text >= 'A' && text <= 'Z') || (text >= 'a' && text <= 'z')) {
		//			return true;
		//		}
		//		
		//		return false;
	}

	public static boolean multipleOfThree(int num) {
		return num % 3 == 0;

		//		if(num % 3 == 0) {
		//			return true;
		//		}
		//		return false;	
	}

	public static String evenOdd(int num) {
		return num % 2 == 0 ? "짝수입니다" : "홀수입니다";
		//		String msg = "";
		//		if(num % 2 == 0) {
		//			msg = "짝수입니다";
		//		}else if (num % 2 == 1){
		//			msg = "홀수입니다";
		//		}
		//		return msg;
	}

	public static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}

		double sqrt = Math.sqrt(num);

		for(int i = 2; i <= sqrt; ++i) {
			if(num % i == 0){
				return false;
			}	
		}
		return true;
	}

	public static int factorial(int num) {
		int result = 1;

		for(int i = 1; i <= num; ++i) {
			result *= i;
		}
		return result;
	}
	///////////////////////////////////////////////
	//재귀 함수 : 자기자신을 부르는 함수(성능 안좋음, 읽기 힘듬, 머리아픔)
	public static int recursive_factorial(int num){
		if (num == 1) {
			return 1;
		}
		return num * recursive_factorial(num - 1);
	}
	///////////////////////////////////////////////////

	public static int squared(int num1, int num2) {
		int result = 1;

		if(num2 == 0) {
			result = 1;
		}

		for(int i = 1; i <= num2; ++i) {
			result *= num1;
		}	
		return result;	
	}

	public static int recursive_squared(int num1, int num2) {
		if(num2 == 0) {
			return 1;
		}
		return num1 * recursive_squared(num1, num2-1);	
	}


	public static void main(String[] args) {

		char question1 = 'a';
		System.out.println("문자가 알파벳인지 : " + alphabetCheck(question1));

		int question2 = 333;
		System.out.println("3의 배수인지 : " + multipleOfThree(question2));

		int question3 = 12343;
		System.out.println("짝수인지 홀수인지 : " + evenOdd(question3));

		int question4 = 4;
		System.out.println("소수인지 : " + isPrime(question4));

		int question5 = 10;
		for(int i = 0; i < 11; ++i) {
			System.out.println(i+"! : " + factorial(i));
		}
	
		System.out.println(question5+"! : " + recursive_factorial(question5));
		
		int question6_1 = 2, question6_2 = 8;
		System.out.println("a의 b제곱 구하기 : " + squared(question6_1, question6_2));

		int a = 2;
		for(int i = 0; i <= 8; ++i) {
			System.out.println(a+" ^ "+i+" : "+recursive_squared(a, i));
		}
	}

}
