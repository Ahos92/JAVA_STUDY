package quiz;

import java.util.Scanner;

public class b05_CheckWord {

	// ����ڷκ��� �ܾ �ϳ� �Է� �ް�
	// ù ���� ������ ���� ��ġ�ϸ� OK �ƴϸ�  NOT OK
	public static void main(String[] args) {

		System.out.println("### �ܾ� Ȯ�� ���α׷� ###");

		Scanner sc = new Scanner(System.in);

		System.out.print("�ܾ �Է� �ϼ��� > ");
		String word = sc.next();
		char firstLetter = word.charAt(0);
		char lastLetter = word.charAt(word.length()-1);
		
//		if(word==null || word=="") {
//			System.out.println("�ܾ �ùٸ��� �ʽ��ϴ�.");
//			return;
//		}

		if(firstLetter == lastLetter) {
			System.out.println("OK");
		}else {
			System.out.println("NOT OK");
		}

		System.out.println("���α׷� ����");
		
		sc.close();
	}
}
