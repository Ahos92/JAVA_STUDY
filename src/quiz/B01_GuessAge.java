package quiz;

import java.util.Scanner;

public class B01_GuessAge {

	// ����ڷκ��� ������ �⵵�� ���̸� �Է� ������
	// �ѱ� ���̸� ����Ͽ� �� ������ �˷��ִ� ���α׷��� ����� ������.
	public static void main(String[] args) {
		
		System.out.println("###���� ���� ���α׷�###");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �⵵�� �Է��ϼ���>");
		int thisYear = sc.nextInt();
		System.out.print("�¾ �⵵�� �Է��ϼ���>");
		int birthYear = sc.nextInt();
		
		int age =thisYear-birthYear+1;
		System.out.println("����� �ѱ� ���̴� "+age+"�� �Դϴ�.");

		
		sc.close();
		
		
	}
}
