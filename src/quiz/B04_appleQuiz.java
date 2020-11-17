package quiz;

//Ctrl + Shift + O 자동 import
import java.util.Scanner;

public class B04_appleQuiz {

	// 사과를 10개씩 담을 수 있는 바구니가 있다
	// 사용자가 사과의 개수를 입력받으면 필요한 바구니의 개수를 계산해주는 조건식
	
	// 사과를 double로 받아서 소수점 올림으로도 가능
	// 변할수있는값 변수로 만들기
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("사과의 개수 입력 : ");
		int apple = sc.nextInt();
		int bucket;
		// 변수 앞 final 은 수정불가능한 변수가 된다.
		
		if(apple%10 == 0) {
			bucket = apple/10;
		} else {
			bucket = apple/10+1;
		}
		System.out.println("바구니의 개수 : "+bucket);
		
		sc.close();
		
	}

}
