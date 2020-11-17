package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class C12_InputRightThing {

	// ����ڷκ��� intŸ���� �����͸� �Է� �ް� ����غ�����.
	// �߸��� Ÿ�� �����Ͱ� �������� ���α׷��� ������� �ʾƾ� �մϴ�.
	// �ùٸ��� int�� �Էµ� ��� ���α׷� ����
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("���ڸ� �Է��� �ּ��� >");
			
			// ����ó�� ��ü�� �Լ��� ó���ع����⵵ ����
			try {

				int data = input.nextInt();

				System.out.println("���α׷� ����!\n�Է� �Ͻ� ���ڴ� " + data + "�Դϴ�.");
				break;

			} catch (InputMismatchException e) {
				System.err.println("\t(���ڸ� �Է��� �ּ���.)");
				input.nextLine(); // �ʱ�ȭ
			}

		}
		
	}

}
