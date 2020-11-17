package quiz;

import java.util.Scanner;

public class b05_CheckWord {

	// 사용자로부터 단어를 하나 입력 받고
	// 첫 글자 마지막 글자 일치하면 OK 아니면  NOT OK
	public static void main(String[] args) {

		System.out.println("### 단어 확인 프로그램 ###");

		Scanner sc = new Scanner(System.in);

		System.out.print("단어를 입력 하세요 > ");
		String word = sc.next();
		char firstLetter = word.charAt(0);
		char lastLetter = word.charAt(word.length()-1);
		
//		if(word==null || word=="") {
//			System.out.println("단어가 올바르지 않습니다.");
//			return;
//		}

		if(firstLetter == lastLetter) {
			System.out.println("OK");
		}else {
			System.out.println("NOT OK");
		}

		System.out.println("프로그램 종료");
		
		sc.close();
	}
}
