package quiz;

import java.util.Scanner;

public class B09_Palindrome {
	// ����ڷκ��� �ܾ �ϳ� �Է¹ް�
	// �ش� ����� ȸ���̶�� "PALINDROME"
	// �ƴ϶�� "NOT PALINDROME"

	public static void main(String[] args) {

		System.out.print("ȸ�� ���� ���� �Է� > ");
		String word = new Scanner(System.in).nextLine();

		boolean palin = true;

		for(int i = 0, len = word.length(); i < len/2; ++i) {
			char ch = word.charAt(i);
			char ch2 = word.charAt(len - 1 - i);

			if(ch != ch2) {
				palin = false;
				break;
			}
		}
		
		if(palin) {
			System.out.println("PALINDROME");			
		}else {
			System.out.println("NOT PALINDROME");
		}

		//	�ٸ� ���
//		StringBuilder strb = new StringBuilder(word);
//		
//		//reverse() ���ڿ� ������
//		String reverse = strb.reverse().toString();
//		
//		int half =word.length() / 2;
//
//		for(int i = 0; i < half; ++i) {
//			if(word.charAt(i) != reverse.charAt(i)) {
//				palin = false;
//				break;
//			}
//		}
//		System.out.println(palin ? "PALRINDROME" : "NOT PARINDROME");

	}

}
