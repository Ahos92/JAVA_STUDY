package quiz;

public class B09_printAlphabet {

	// �ݺ����� �̿��Ͽ� A���� Z���� ��� �غ�����
	
	// �ݺ����� �̿��Ͽ� a���� z���� ��� �غ�����
	
	public static void main(String[] args) {
		
		
		int upper = (int)'A';
				
		for(int i=upper; i<upper+26; ++i) {
			System.out.print((char)i);
		}
		
		System.out.println();
		
		for(char i='a'; i<='z'; ++i) { // char���� ���� �ִ�.
			System.out.print(i);
		}
	}
}
