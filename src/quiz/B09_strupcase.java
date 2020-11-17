package quiz;

import java.util.Scanner;

public class B09_strupcase {

	// 입력받은 문자열의 모든 알파벳을 대문자로 만들어보세요
	public static void main(String[] args) {

		System.out.println("모든 알파벳 대문자로 바꾸기\n문장 입력 > ");
		String sentence = new Scanner(System.in).nextLine();

		StringBuilder sentenceB = new StringBuilder();

		for(int i = 0, len = sentence.length(); i < len; ++i) {
			
			char ch = sentence.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
				ch -= 32;
				//ch -= Math.abs('A' - 'a');
				// ch = (char)(ch - 'a' + 'A');
			}
			
			sentenceB.append(ch);
			
		}
		
		
		String newsentence = sentenceB.toString();
		System.out.println(newsentence);
		
	}

}
