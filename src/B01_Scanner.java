
import java.util.Scanner;
// java.lang�� �⺻�̶� ���ص���
// ���� ��Ű�� �ҽ��� import���ص� ��������

import quiz.A01_printQuiz;

public class B01_Scanner {

	// Scanner Ŭ����
	//	- �ܺ� �Է� ��ɵ� ���ִ� Ŭ����
	//	- ��� �Է¹����� ������ �� �پ��ѹ������ �Է¹��� �� ��
	//	- console �Է� System.in

	public static void main(String[] args) {
		
//		A01_printQuiz.main(null); // �ٸ� ��Ű��
//		A00_Hello.main(null); // ���� ��Ű��
		
		// ��ĳ�� ������ �Է¹��� �� ����
		Scanner sc = new Scanner(System.in);
		// next()
		//	- ��ο� �����ϴ� ���� ���� �ϳ��� ������
		//	- Ÿ���� �ٲ��� �ʴ´� (String)
		
		//nextŸ��()
		//	- ��ο� �����ϴ� ���� ������ �ϳ����� �ش�Ÿ������ �о�´�.
		//	- ��ο� �ƹ����� ���ٸ� �Է��� �ɶ����� ��ٸ���.
		//	- ��ο� �����ϴ� ���� ���� �ش�Ÿ�� ���� �ɼ� ���� �� ����
		
		// nextLine()
		//	- ��ο� �����ϴ� ���� �� �� ���� �����´�.
		//	- ���� �����ϴ� ������ \n(����)
		System.out.println("�ƹ� ���̳� �Է��غ����� >");
		int num = sc.nextInt();
		System.out.println("�Է� ���� �� : "+num);
		System.out.println(num + 10);
		System.out.println(num - 10);
		System.out.println(num * 10);
		System.out.println(num % 10);
		System.out.println(num / 10);
		//�����̽��� �������� ���ÿ� ��� ��ų������ , ���� �Է��ص���
		int num2 = sc.nextInt();
		System.out.println("�ι�° �� : "+num2);
		
		sc.close();
	}
}
