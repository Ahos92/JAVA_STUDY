package quiz;

import java.util.Scanner;

public class B01_celToFahr {

	public static void main(String[] args) {
		// ����ڷκ��� ���� �µ��� �Է¹����� ȭ���� ��ȯ ���ִ� ���α׷�
		
		System.out.println("### �µ� ��ȯ ���α׷� ###");

		System.out.print("�����µ�(��)�� �Է����ּ���. > ");
//		Scanner sc = new Scanner(System.in);		
//		double celc = sc.nextDouble();
		
		// ��ĳ�� �ѹ��� ����Ұ�� �̷��� ����ϱ⵵�� , ��� �ٽ� ��� �Ұ�� ��� �ϳ� �ٽ� ����������
		double celc = new Scanner(System.in).nextDouble();
		
		double fahr = (celc*9/5) + 32;
		
		System.out.printf("ȭ���µ�(��) : %.1f��", fahr);
		
		

	}

}
