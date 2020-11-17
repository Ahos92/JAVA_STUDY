package study;
import java.util.Scanner;

public class B05_charAt {

	public static void main(String[] args) {
		
		// "문자열".charAt(inderx)
		// 	- 문자열에서 원하는 번째의 문자를 꺼내는 함수
		//	- 반환되는 타입은 Char
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("아무거나 입력해 보세요 > ");
		String word = sc.next();
		
		System.out.println(word);
		System.out.println(word.charAt(0));
		
		// #문자열.length()
		// 	- 문자열이 몇글자로 이루어져있는지 , int 타입
		if(word.length() >= 5)
			System.err.println(word.charAt(4));
		else
			System.out.println("해당 단어의 길이가 5보다 짧습니다.");
		
		 
	}

}
