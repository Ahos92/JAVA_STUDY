package study;
import java.util.Scanner;

public class B11_while {

	public static void main(String[] args) {
		
		// �������� ��ġ�� ���� �ݺ��� ����� �޶��� �� �ִ�.
		
		int i = 0;
		while(i < 10) {
			++i;
			System.out.println("Hello, while ! "+i);
		}
		
		// while���� ����ϰԲ������ Ŭ����
		// 	- has, next ���ľ���� �޼���
		// 		ex) Scanner ...
		
		// System.in - �ܼ��� ���� �Է��� �ϴ� ���(inputStream)
		Scanner sc1 = new Scanner("apple banana orange"); // ���ڿ��� ���� ��ĳ�ʿ� �Է�
		Scanner sc2 = new Scanner("dog cat rat bird ");
		
		// sc1�� ���� ������ �ִµ��� ���
		while(sc1.hasNext()) {
			System.out.println(sc1.next()); // ��ο��� �ϳ�������
		}
		
		while(sc2.hasNext()) {
			System.out.println(sc2.next()); // ��ο��� �ϳ�������
		}
		
		// while ���� ���� ���α׷�
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. ����ϱ�");
			System.out.println("2. �����ϱ�");
			int cmd = sc.nextInt();
			
			switch (cmd) {
			case 1:
				System.out.println("����մϴ�.");
				break;
			case 2:
				System.out.println("�����մϴ�.");
				System.exit(0);
				break;
			default:
				System.out.println("�ùٸ� ������ �ƴմϴ�.");
				break;
			}
			
		}
		
	}
}
