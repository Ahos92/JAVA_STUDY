package quiz;

import java.util.Scanner;

public class B09_forQuizBasic {

	// ����ڰ� ���ڸ� �Է� ���� ��
	// 1. 10���� �Է��� ���ڱ����� �� ���� ���غ�����
	// 2. 1���� �Է��� ���� ������ 3�� ����� ��� ����ϰ� �� �� �ִ����� ����غ�����
	// 3. 
	public static void main(String[] args) {

		//1
		Scanner sc = new Scanner(System.in);
		System.out.println("10���� �Է��� ���ڱ����� ��\n���ڸ� �Է��� �ּ��� > ");
		int num = sc.nextInt();
		int sum = 0 ;
		int end = num;
		int start= 10;
		// ���� ���� �� ���� �����'
		// ������ ����� �� ������ �ٲٸ� ���ǹ� �ѹ����� ��
		if(start>end) {
			int temp = start;
			start = end;
			end =temp;
		}

		for(int i = start; i <= end; ++i) {
			sum+=i;
		}

		System.out.printf("10���� %d���� ������ ������ %d �Դϴ�\n", num,sum);


		//2
		System.out.print("\n1���� �Է��� ���ڻ����� 3�ǹ�� ���ϱ�\n");
		int count = 0;
		int start2= 1;
		int end2 = num;

		if(start2>end2) {
			int temp = start2;
			start2 = end2;
			end2 =temp;
		}
		for(int i = start2; i <= end2; ++i) {
			if(i%3==0) {
				++count;
				System.out.println(i);
			}
		}
		System.out.printf("1���� %d������ 3�ǹ���� �� ������ %d�� �Դϴ�", num,count);

		sc.close();

	}
}
