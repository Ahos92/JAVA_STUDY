package quiz;

import java.util.Scanner;

public class B06_monthToSeason {

	// switch �� �̿�
	//����ڷκ��� ���� �Է� ������ �ش��ϴ� ������ ���
	public static void main(String[] args) {
		
		System.out.println("���� Ȯ�� ���α׷�");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��� �ּ��� > ");
		int month = sc.nextInt();
		
		switch(month) {
		case 12: case 1: case 2:
			System.out.println("�ܿ� �Դϴ�.");
			break;
		case 3: case 4: case 5:
			System.out.println("�� �Դϴ�.");
			break;
		case 6: case 7: case 8:
			System.out.println("���� �Դϴ�.");
			break;
		case 9: case 10: case 11:
			System.out.println("���� �Դϴ�.");
			break;
		default :
			System.out.println("1~12������ ���ڸ� �Է����ֽʽÿ�.");
			break;
		}
		sc.close();
	}
}
