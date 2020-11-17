package crypto;

import java.util.Arrays;

public class TranspositionCipher extends Cipher{

	// # ��ġ ��ȣ
	//	- �޼����� key�� ��ŭ�� ���̷� ���� �� �ٸ� �������� �о ��ȣȭ �ϴ� ���

	// ex>
	// 	plain : common sense is not so common.
	//	key : 8
	//	key ���� �ξ� �۾ƾ���

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

	// setPlain �Լ� ���� ���� �ްԲ� �ϱ⵵����


	// encryption �޼����� ������ ������ȣ�� ��ġ��Ű�� ���� ����.
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
		//	- �ӽ� ������ builder�� ���ο� �ν��Ͻ��� ����
		//	- �߰�ȣ ����� �����
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

	// column ��
	// row ��
	public String decryption(String crypto) {
		int len = crypto.length();
		int columnSize = (int)Math.ceil(len / (double)key);
		int numOfBlanks = columnSize * key - len;
		int numOfFull = key - numOfBlanks;

		StringBuilder[]	builders = getBuilders(columnSize);

		for(int column = 0; column < columnSize; ++column) {

			int crypto_index = column;

			//�� ���� �ݺ��ɶ����� Full�ΰ�� �÷���ŭ
			//				Full�� �ƴ� ��� �÷� -1��ŭ �ε��� ����
			for(int row = 0; row < key; ++row) {
				builders[column].append(crypto.charAt(crypto_index));

				if(row < numOfFull) {
					crypto_index += columnSize;
				}else {
					crypto_index += columnSize - 1;
				}

				// �߰��� index�� ������ �÷��̸鼭 ���ÿ� ������ full�� ���
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
		// ������ Ŭ������ ��/Ű ���� �ٸ� �����ν��Ͻ���
		// �����ϰ� ����� �� �ֱ� ������ �򹮰� Ű�� static�� �ƴϴ�.
		String crypto = new TranspositionCipher(8).encryption("common sense is not so common.");
		System.out.println(crypto);

		String plain = new TranspositionCipher(8).decryption(crypto);
		System.out.println(plain);
		

	}

}
