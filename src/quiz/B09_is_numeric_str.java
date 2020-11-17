package quiz;

import java.util.Scanner;

public class B09_is_numeric_str {

	// 입력 받은 문자열에 숫자만 포함되어 있으면 결과에 1을 저장
	// 다른 문자가 포함되어있다면 0을 저장
	// 단, 비어있을때는 결과 2
	public static void main(String[] args) {

		System.out.print("문장 입력 > ");
		String sentence = new Scanner(System.in).nextLine();

		int status = 1;

		if(sentence == null || sentence.isEmpty()) { // sentence.equals(""), sentence.length()==0 2개는 같은 의미
			status = 2; 
		}else {

			for(int i = 0, len = sentence.length(); i < len; ++i) {
				char ch = sentence.charAt(i);
				if(!(ch >= '0' && ch <= '9')) {// (ch < '0' && ch > '9')
					status = 0;
					break;
				}
			}
		}
		System.out.println("문자열 상태 : "+status);
		
		
		switch(status) {// 나온 상태스탯을 가지고 여러가지 처리가 가능함
		case 0:
		case 1:
		case 2:
		}
	}
}
