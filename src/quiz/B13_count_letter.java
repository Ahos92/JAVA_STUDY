package quiz;

public class B13_count_letter {

	// 사용자로부터 문장을 하나 입력 받았다 치고
	// 해당 문자열에 어떤알파벳이 몇번 등장했는지 세어서 출력해보세요
	// 대소문자 구분X
	public static void main(String[] args) {

		String str = "GitHub is home to over 50 million developers working together to host and review code";
		str= str.toUpperCase();

		int[] count = new int[26];

		for(int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if(ch >= 'A' && ch <= 'Z') {
				count[ch - 'A'] += 1;
				/*
		  			'A' - 'A' -> 0 -> count[0] += 1
				 */
			}
		}
		for(int i = 0; i < 26; ++i) {
			if(count[i] > 0) {
				System.out.printf("%c가 등장한 횟수는 %d입니다.\n", i+'A', count[i]);
			}
		}
	}
}
