package crypto;

import java.util.Arrays;

public class TranspositionCipher extends Cipher{

	// # 전치 암호
	//	- 메세지를 key값 만큼의 길이로 나눈 뒤 다른 방향으로 읽어서 암호화 하는 방식

	// ex>
	// 	plain : common sense is not so common.
	//	key : 8
	//	key 값이 훨씬 작아야함

	// 0 1 2 3 4 5 6 7
	// ---------------
	// C o m m o n   s
	// e n s e   i s  
	// n o t   s o   c
	// o m m o n .

	public char[][]	test(String text){
		int len = text.length();
		int column = (int)Math.ceil(len / (double)key);
		
		char[][] ch= new char[key][column];
		for(int i = 0; i < key; ++i){
			for(int j = 0; j < column; ++j){
				ch[i][j] = text.charAt(j);
			}
		}
		
		return ch;
	}



	// crypto : Cenoonommstmme oo snnio. s s c  

	int key;

	public TranspositionCipher(int key) {
		this.key = key;
	}

	// setPlain 함수 만들어서 값을 받게끔 하기도가능


	// encryption 메서드의 형식을 시저암호와 일치시키는 것이 좋다.
	public String encryption(String plain) {
		StringBuilder[]	builders = getBuilders(key);

		int len = plain.length();
		for (int i = 0; i < len; ++i) {
			builders[i % key].append(plain.charAt(i));
		}

		return joinBuilders(builders);
	}

	private String joinBuilders(StringBuilder[] builders) {
		StringBuilder result = new StringBuilder();

		// for each 
		//	- 임시 변수인 builder에 새로운 인스턴스를 만듬
		//	- 중괄호 벗어나면 사라짐
		for(StringBuilder builder : builders) {
			result.append(builder);
		}

		return result.toString();
	}

	private StringBuilder[] getBuilders(int colunmSize) {
		StringBuilder[] builders  = new StringBuilder[colunmSize];

		for(int i = 0; i < builders.length; ++i) {
			builders[i] = new StringBuilder();
		}

		return builders;
	}

	// column 열
	// row 행
	public String decryption(String crypto) {
		int len = crypto.length();
		int columnSize = (int)Math.ceil(len / (double)key);
		int numOfBlanks = columnSize * key - len;
		int numOfFull = key - numOfBlanks;

		StringBuilder[]	builders = getBuilders(columnSize);

		for(int column = 0; column < columnSize; ++column) {

			int crypto_index = column;

			//한 줄이 반복될때마다 Full인경우 컬럼만큼
			//				Full이 아닌 경우 컬럼 -1만큼 인덱스 증가
			for(int row = 0; row < key; ++row) {
				builders[column].append(crypto.charAt(crypto_index));

				if(row < numOfFull) {
					crypto_index += columnSize;
				}else {
					crypto_index += columnSize - 1;
				}

				// 추가한 index가 마지막 컬럼이면서 동시에 마지막 full인 경우
				if(column == columnSize - 1 && row == numOfFull - 1) {
					break;
				} else if(crypto_index >= len) {
					break;
				}
			}
		}
		return joinBuilders(builders);
	}

	public static void main(String[] args) {
		// 만들어둔 클래스로 평문/키 값이 다른 여러인스턴스를
		// 생성하고 사용할 수 있기 때문에 평문과 키는 static이 아니다.
		String crypto = new TranspositionCipher(8).encryption("common sense is not so common.");
		System.out.println(crypto);

		String plain = new TranspositionCipher(8).decryption(crypto);
		System.out.println(plain);
		

	}

}
