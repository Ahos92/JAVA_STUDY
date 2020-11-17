package quiz;

import java.util.Arrays;

public class B13_count_letter_case {


	// 사용자로부터 문장을 하나 입력 받았다 치고
	// 해당 문자열에 어떤알파벳이 몇번 등장했는지 세어서 출력해보세요
	// 대 소문자, 숫자 구별해서 집계

	public static void main(String[] args) {

		String str = "GitHub is home to over 50 million developers working together to host and review code z";

		int[] count_upper = new int[26];
		int[] count_lower = new int[26];
		int[] count_number = new int[10];

		// 2차 배열
//		int[][] num = {{1, 2, 3, 4, 5}, 
//						{6, 7, 8, 9, 10}};
		
		for(int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch >= 'a' && ch <= 'z'){
				count_lower[ch - 'a'] +=1;
				
			} else if (ch >= 'A' && ch <= 'Z') {
				count_upper[ch - 'A'] += 1;
				
			} else if(ch >= '0' && ch <= '9') {
				count_number[ch - '0'] += 1;
				
			}		


		}
		for(int i = 0; i < 26; ++i) {
			if(count_lower[i] > 0) {
				System.out.printf("%c가 등장한 횟수는 %d입니다.\n", i+'a', count_lower[i]);
			}
		}
		for(int i = 0; i < 26; ++i) {
			if(count_upper[i] > 0) {
				System.out.printf("%c가 등장한 횟수는 %d입니다.\n", i+'A', count_upper[i]);
			}
		}
		for(int i = 0; i < 10; ++i) {
			if(count_number[i] > 0) {
				System.out.printf("%c가 등장한 횟수는 %d입니다.\n", i+'0', count_number[i]);
			}
		}

	}
}
