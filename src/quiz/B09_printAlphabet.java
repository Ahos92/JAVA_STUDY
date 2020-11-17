package quiz;

public class B09_printAlphabet {

	// 반복문을 이용하여 A부터 Z까지 출력 해보세요
	
	// 반복문을 이용하여 a부터 z까지 출력 해보세요
	
	public static void main(String[] args) {
		
		
		int upper = (int)'A';
				
		for(int i=upper; i<upper+26; ++i) {
			System.out.print((char)i);
		}
		
		System.out.println();
		
		for(char i='a'; i<='z'; ++i) { // char형도 쓸수 있다.
			System.out.print(i);
		}
	}
}
