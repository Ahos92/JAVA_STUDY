package quiz;

import java.util.Scanner;

public class B09_is_numeric_str {

	// �Է� ���� ���ڿ��� ���ڸ� ���ԵǾ� ������ ����� 1�� ����
	// �ٸ� ���ڰ� ���ԵǾ��ִٸ� 0�� ����
	// ��, ����������� ��� 2
	public static void main(String[] args) {

		System.out.print("���� �Է� > ");
		String sentence = new Scanner(System.in).nextLine();

		int status = 1;

		if(sentence == null || sentence.isEmpty()) { // sentence.equals(""), sentence.length()==0 2���� ���� �ǹ�
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
		System.out.println("���ڿ� ���� : "+status);
		
		
		switch(status) {// ���� ���½����� ������ �������� ó���� ������
		case 0:
		case 1:
		case 2:
		}
	}
}
