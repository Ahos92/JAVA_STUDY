package quiz;

import java.util.Scanner;

public class B09_strupcase {

	// �Է¹��� ���ڿ��� ��� ���ĺ��� �빮�ڷ� ��������
	public static void main(String[] args) {

		System.out.println("��� ���ĺ� �빮�ڷ� �ٲٱ�\n���� �Է� > ");
		String sentence = new Scanner(System.in).nextLine();

		StringBuilder sentenceB = new StringBuilder();

		for(int i = 0, len = sentence.length(); i < len; ++i) {
			
			char ch = sentence.charAt(i);
			
			if(ch >= 'a' && ch <= 'z'){
				ch -= 32;
				//ch -= Math.abs('A' - 'a');
				// ch = (char)(ch - 'a' + 'A');
			}
			
			sentenceB.append(ch);
			
		}
		
		
		String newsentence = sentenceB.toString();
		System.out.println(newsentence);
		
	}

}
