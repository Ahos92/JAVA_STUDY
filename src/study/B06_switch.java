package study;

public class B06_switch {

	public static void main(String[] args) {
		
		// switch-case-default
		// ()안의 연산 결과에따라 실행할 코드결정
		
		int a = 9;
		
		switch (a % 2) {
		case 0:
			System.out.println("짝수입니다.");
			break;
			
		case 1:
			System.out.println("홀수입니다.");
			break;
		}
		
		
		String word ="apple";
		
		switch(word.charAt(0)) {
		case'A': case'a': //break 의도적으로 빼서 양쪽다활용하는경우 , break아예 빼서 옵셜활용가능
			System.out.println("a로 시작하는 단어입니다.");
			break;
			
		case'b':
			System.out.println("b로 시작하는 단어입니다.");
			break;
			
		case'c':
			System.out.println("c로 시작하는 단어입니다.");
			break;
			
		default :
			System.out.println("위의 case가 모두아닙니다.");
			break;
		}
	}
	
}
