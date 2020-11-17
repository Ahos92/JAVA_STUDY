package quiz;

import java.util.Scanner;

public class B09_is_contain_alpha {

	// 사용자가 입력한 문자열에 알파벳이 포함되어 있으면 true 출력
	// 없으면 false
	public static void main(String[] args) {

		System.out.print("문자열 입력 > ");
		String word = new Scanner(System.in).nextLine();

		boolean result =false;
		
			// word.length()함수 한번만 호출하게해 더효율적으로가능
		for(int i=0, len = word.length(); i<len; ++i) {
			char ch =word.charAt(i);
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				result=true;
				break; // 가장 가까운 반복문에 적용
			}
		}
		System.out.println(result);
		
	}
}
