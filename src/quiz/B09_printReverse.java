package quiz;

import java.util.Scanner;

public class B09_printReverse {

	//사용자가 문장을 입력하면 그 문장을 거꾸로 출력해 보세요
	
	public static void main(String[] args) {
	
		System.out.print("문장을 입력 하세요 > ");
		
		Scanner sc= new Scanner(System.in);
		
		String sentence = sc.nextLine();
		
		int length = sentence.length()-1;
		
		StringBuilder reverse = new StringBuilder(); // 거꾸로만든 문자열 저장할 변수
		for(int i = length; i >= 0; --i)
			reverse.append(sentence.charAt(i)); // 문자열 누적연산가능 --느리다

		System.out.println(reverse);
		
////////////////////////////////////////////////////////////////////////////////////		
		// 문자열 누적연산은 빌더를 통해 한다 - 효율이좋다
		StringBuilder str = new StringBuilder("hello");
		str.append(", world!");
		// 다 만들고나면 String으로 변환해야함
		// println(object)은 변환을 안해도되지만 Stirng이 들어갈자리에는 반드시 해줘야함
		String madeStr = str.toString();
		System.out.println(madeStr);
	}
}
