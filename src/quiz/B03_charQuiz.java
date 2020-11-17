package quiz;

public class B03_charQuiz {

	public static void main(String[] args) {
		/*
		 	[알맞은 조건식 만들기]
		 	1. char형 변수 a가 'q'또는 'Q'일 때 true
		 	2. char형 변수 b가 공백이나 탭이 아닐 때 true
		 	3. char형 변수 c가 문자('0' ~ '9')일 때 true
		 	4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		 	5. char형 변수 e가 한글일 때 true
		 	6. char형 변수 f가 일본어일 때 true
		 */
		
		char a = 'q';
		System.out.println(a=='q' || a=='Q');
		
		char b = 'b';
		System.out.println(!(b==' ' || b=='\t'));
		
		char c = '0';
		System.out.println(c >= 48 && c <= 57);
		
		char d = 'z';
		System.out.println((d >= 65 && d <=90) || (d >= 97 && d <= 122));
		
		char e = 'ㄱ';
		System.out.println(e >= 12593 && e <= 12686 || e >= 44032 && e <= 55215);
		//한글
		// Hangul Jamo : 0x1100 ~ 0x11FF
		// Hangul Syllables : 0xAC00 ~ 0xD7A3
		
		char f = 'あ';
		System.out.println(f >= 12352 && f <= 12543);
		
	}

}
