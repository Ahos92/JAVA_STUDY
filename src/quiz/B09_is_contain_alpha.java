package quiz;

import java.util.Scanner;

public class B09_is_contain_alpha {

	// ����ڰ� �Է��� ���ڿ��� ���ĺ��� ���ԵǾ� ������ true ���
	// ������ false
	public static void main(String[] args) {

		System.out.print("���ڿ� �Է� > ");
		String word = new Scanner(System.in).nextLine();

		boolean result =false;
		
			// word.length()�Լ� �ѹ��� ȣ���ϰ��� ��ȿ�������ΰ���
		for(int i=0, len = word.length(); i<len; ++i) {
			char ch =word.charAt(i);
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				result=true;
				break; // ���� ����� �ݺ����� ����
			}
		}
		System.out.println(result);
		
	}
}
