package quiz;

import java.util.Scanner;

public class B09_forQuizBasic {

	// 사용자가 숫자를 입력 했을 때
	// 1. 10부터 입력한 숫자까지의 총 합을 구해보세요
	// 2. 1부터 입력한 숫자 사이의 3의 배수만 모두 출력하고 몇 개 있는지도 출력해보세요
	// 3. 
	public static void main(String[] args) {

		//1
		Scanner sc = new Scanner(System.in);
		System.out.println("10부터 입력한 숫자까지의 합\n숫자를 입력해 주세요 > ");
		int num = sc.nextInt();
		int sum = 0 ;
		int end = num;
		int start= 10;
		// 시작 변수 끝 변수 만들고'
		// 조건을 만들어 두 변수를 바꾸면 조건문 한번으로 끝
		if(start>end) {
			int temp = start;
			start = end;
			end =temp;
		}

		for(int i = start; i <= end; ++i) {
			sum+=i;
		}

		System.out.printf("10부터 %d까지 숫자의 총합은 %d 입니다\n", num,sum);


		//2
		System.out.print("\n1부터 입력한 숫자사이의 3의배수 구하기\n");
		int count = 0;
		int start2= 1;
		int end2 = num;

		if(start2>end2) {
			int temp = start2;
			start2 = end2;
			end2 =temp;
		}
		for(int i = start2; i <= end2; ++i) {
			if(i%3==0) {
				++count;
				System.out.println(i);
			}
		}
		System.out.printf("1부터 %d사이의 3의배수의 총 갯수는 %d개 입니다", num,count);

		sc.close();

	}
}
