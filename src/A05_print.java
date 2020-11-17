
public class A05_print {

	public static void main(String[] args) {

		// console�� ����ϱ����� �Լ�

		// 1. print �⺻
		System.out.print("Hello, world");
		System.out.print("Hello, world");
		System.out.print("Hello, world");

		// 2. println �ڵ��ٹٲ�
		//  - \n�� �ڵ����� ����
		//	- ���� �Ͻ� \n�� ���
		System.out.println();
		System.out.println("Hello, world!");
		System.out.println("Hello, world!");
		System.out.println("Hello, world!");

		// 3. printf
		//	- ����(format) ���ڸ� �̿��� ��� ������ �Լ� / �ڵ��ٹٲ�X 
		//	- %d	: 10���� ���� (decimal)
		//	- %x,X	: 16���� ���� (hexa decimal) / �ҹ���, �빮�� ���ϴ°ɷ� ���
		// 	- %o	: 8���� ���� 	(octal)
		//	- %s	: ���ڿ� 		(String)
		//	- %c	: ����		(Character)
		//	- %f	: �Ǽ�		(float) / %.10f �ɼǰ���
		// ex)2020�� 10�� 20��
		int year = 2020;
		int month = 10;
		int day = 20;
		System.out.printf("%d�� %d�� %d��\n", year,month,day);
		System.out.printf("%x %X\n", 10, 10);
		System.out.printf("%.10f\n", 123.456789);
		System.out.printf("����� �ſ����� '%s'�Դϴ�.\n", "1���");
		System.out.printf("%d[%c], %x(16), %o(8)\n", 65, 65, 65, 65);

		//# ���Ĺ��� �ɼ� �ڡڡ�
		//		�� d�� �ش�Ǵ°��� �ƴ�
		//	%����d : ���ڸ�ŭ ĭ�� Ȯ���� �� ������ ���� ���
		System.out.printf("�̸� : %15s\n", "Hong Gildong");
		System.out.printf("���� : %15d\n", 15);
		// �Ѿ�� �ȵȴ�
		System.out.printf("�̸� : %15s\n", "Hoooooooooooooooong Gildong");
		
		//	%-����d : ���ڸ�ŭ ĭ�� Ȯ���� �� ���� ���� ���
		System.out.printf("%-10s : Hong Gildong\n", "Fullname");
		System.out.printf("%-10s : 15\n", "Age");
		
		// %0����d : ���� ��ŭ ĭ�� Ȯ���� �� 0�� ��ĭ�� ä�� ��� (%d, %f ������)
		System.out.printf("%010d\n", 123);
		System.out.printf("%010f\n", 123.123);
		
		// %+����d : ��� �տ� ��ȣ�� ���
		System.out.printf("������ ���� %+d���Դϴ�.\n", -5);
		System.out.printf("������ ���� %+d���Դϴ�.\n", 20);
		
		// %.����f : �Ҽ� �ڸ����� ����
		System.out.printf(".3\t:%.3f\n", 123.123);
		System.out.printf("default\t:%f\n", 123.123);
		System.out.printf(".10\t:%.10f\n", 123.123);
		System.out.printf(".20\t:%.20f\n", 123.123);
		System.out.printf(".255\t:%.255f\n", 123.123);

	}

}
