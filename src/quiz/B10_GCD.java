package quiz;

public class B10_GCD {

	// 두 숫자를 입력받으면 두 숫자의 최대 공약수를 구해보세요

	public static void main(String[] args) {

		int num = 333,  num2 = 444, gcd = 1, num_d = 0, num2_d = 0, n = 1;

		//유클리드 알고리즘
		if(num < num2) {
			int temp = num;
			num = num2;
			num2 = temp;
		}
		
		for(; n != 0;) {
			n = num % num2;
			num = num2;
			num2 = n;
		}
		System.out.printf("최대 공약수는 %d 입니다.",  num);
		
		// 3.
//		if(num > num2) {
//			int temp = num;
//			num = num2;
//			num2 = temp;
//		}
//		
//		for(int i = num; i > 0; --i) {
//			
//			if(num % i == 0 && num2 % i ==0) {
//				gcd = i;
//				break;
//			}
//		}
//		System.out.printf("%d와 %d의 최대 공약수는 %d 입니다.", num, num2, gcd);
		
		
		// 2.
//		for(int i = 2; true; ++i) {
//
//			if(num % i != 0 || num2 % i != 0) {
//				continue;	
//			} else{
//				gcd *= i;
//				num /= i; num2 /= i;
//			}
//			
//			if(i > num || i > num2) {
//				System.out.printf("%d와 %d의 최대 공약수는 %d 입니다.", num, num2, gcd);
//				break;
//			}
//
//		}
		
		// 1.
//		if (num == num2) {
//			gcd = num;
//
//		}else {
//
//			for(int i = 1; i <= num; ++i) {
//
//				if(num % i == 0) {
//					num_d = i;
//				}
//
//				for(int j = 1; j <= num_d; ++j) {
//					if(num2 % i == 0) {
//						num2_d = i;
//						if(num_d == num2_d) {
//							gcd = num_d;
//						}
//					}
//				}
//			}
//		}
//		System.out.printf("%d와 %d의 최대 공약수는 %d 입니다.", num, num2, gcd);

	}

}