package study;
import java.util.Scanner;

public class B05_charAt {

	public static void main(String[] args) {
		
		// "���ڿ�".charAt(inderx)
		// 	- ���ڿ����� ���ϴ� ��°�� ���ڸ� ������ �Լ�
		//	- ��ȯ�Ǵ� Ÿ���� Char
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("�ƹ��ų� �Է��� ������ > ");
		String word = sc.next();
		
		System.out.println(word);
		System.out.println(word.charAt(0));
		
		// #���ڿ�.length()
		// 	- ���ڿ��� ����ڷ� �̷�����ִ��� , int Ÿ��
		if(word.length() >= 5)
			System.err.println(word.charAt(4));
		else
			System.out.println("�ش� �ܾ��� ���̰� 5���� ª���ϴ�.");
		
		 
	}

}
