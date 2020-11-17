package quiz;

import java.util.Scanner;

public class B09_Palindrome {
	// 사용자로부터 단어를 하나 입력받고
	// 해당 ㅏㄴ어가 회문이라면 "PALINDROME"
	// 아니라면 "NOT PALINDROME"

	public static void main(String[] args) {

		System.out.print("회문 검증 문장 입력 > ");
		String word = new Scanner(System.in).nextLine();

		boolean palin = true;

		for(int i = 0, len = word.length(); i < len/2; ++i) {
			char ch = word.charAt(i);
			char ch2 = word.charAt(len - 1 - i);

			if(ch != ch2) {
				palin = false;
				break;
			}
		}
		
		if(palin) {
			System.out.println("PALINDROME");			
		}else {
			System.out.println("NOT PALINDROME");
		}

		//	다른 방법
//		StringBuilder strb = new StringBuilder(word);
//		
//		//reverse() 문자열 뒤집기
//		String reverse = strb.reverse().toString();
//		
//		int half =word.length() / 2;
//
//		for(int i = 0; i < half; ++i) {
//			if(word.charAt(i) != reverse.charAt(i)) {
//				palin = false;
//				break;
//			}
//		}
//		System.out.println(palin ? "PALRINDROME" : "NOT PARINDROME");

	}

}
