package quiz;

import java.util.Scanner;

public class B09_printReverse {

	//����ڰ� ������ �Է��ϸ� �� ������ �Ųٷ� ����� ������
	
	public static void main(String[] args) {
	
		System.out.print("������ �Է� �ϼ��� > ");
		
		Scanner sc= new Scanner(System.in);
		
		String sentence = sc.nextLine();
		
		int length = sentence.length()-1;
		
		StringBuilder reverse = new StringBuilder(); // �Ųٷθ��� ���ڿ� ������ ����
		for(int i = length; i >= 0; --i)
			reverse.append(sentence.charAt(i)); // ���ڿ� �������갡�� --������

		System.out.println(reverse);
		
////////////////////////////////////////////////////////////////////////////////////		
		// ���ڿ� ���������� ������ ���� �Ѵ� - ȿ��������
		StringBuilder str = new StringBuilder("hello");
		str.append(", world!");
		// �� ������� String���� ��ȯ�ؾ���
		// println(object)�� ��ȯ�� ���ص������� Stirng�� ���ڸ����� �ݵ�� �������
		String madeStr = str.toString();
		System.out.println(madeStr);
	}
}
