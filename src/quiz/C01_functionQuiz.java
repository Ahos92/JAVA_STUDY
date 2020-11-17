package quiz;

public class C01_functionQuiz {

	// ���� �Լ��� ���� �غ�����
	// 1. ������ ���ڰ� ���ĺ��̸� true �ƴϸ� false
	// 2. ������ ���ڰ� 3�� ����̸� true �ƴϸ� false
	// 3. ���ڸ� �� �� �����ϸ� ���ڿ� "¦���Դϴ�" �Ǵ� "Ȧ���Դϴ�" ��ȯ
	// 4. ������ ���ڰ� �Ҽ����� �ƴ��� �Ǻ� �Լ� (boolean)
	// 5. ���ڸ� �����ϸ� �ش������ ���丮�� ���
	//		factorial : (n)*(n-1)*(n-2) ... 3*2*1
	// 6. ���� �ΰ�(a, b)�� �����ϸ� a�� b������ ��ȯ�ϴ� �Լ�
	//		(0������ 1�� ��ȯ, Math.pow����)

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
		return num % 2 == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		//		String msg = "";
		//		if(num % 2 == 0) {
		//			msg = "¦���Դϴ�";
		//		}else if (num % 2 == 1){
		//			msg = "Ȧ���Դϴ�";
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
	//��� �Լ� : �ڱ��ڽ��� �θ��� �Լ�(���� ������, �б� ����, �Ӹ�����)
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
		System.out.println("���ڰ� ���ĺ����� : " + alphabetCheck(question1));

		int question2 = 333;
		System.out.println("3�� ������� : " + multipleOfThree(question2));

		int question3 = 12343;
		System.out.println("¦������ Ȧ������ : " + evenOdd(question3));

		int question4 = 4;
		System.out.println("�Ҽ����� : " + isPrime(question4));

		int question5 = 10;
		for(int i = 0; i < 11; ++i) {
			System.out.println(i+"! : " + factorial(i));
		}
	
		System.out.println(question5+"! : " + recursive_factorial(question5));
		
		int question6_1 = 2, question6_2 = 8;
		System.out.println("a�� b���� ���ϱ� : " + squared(question6_1, question6_2));

		int a = 2;
		for(int i = 0; i <= 8; ++i) {
			System.out.println(a+" ^ "+i+" : "+recursive_squared(a, i));
		}
	}

}
