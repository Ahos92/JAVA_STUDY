package quiz;

import java.util.Scanner;

public class B10_Prime {

	// ����ڷκ��� ���ڸ� �Է¹�����
	// 1���� �Է��� ���� ���̿� �����ϴ� �Ҽ��� ��� ����غ�����.

	// �Ҽ� - ����� 1�� �ڱ� �ڽŹۿ� ���� ����

	public static void main(String[] args) {

		System.out.print("�Ҽ� ���ϴ� ���α׷�\n���� �Է� > ");
		int num = new Scanner(System.in).nextInt();


		int prime_count = 0;


		for(int i = 2; i <= num; ++i) {
			int prime_check = 0;
			int sqrt = (int)Math.sqrt(i);
			
			for(int j = 2; j <= sqrt ; ++j){
				
				if(i % j == 0) {
					++prime_check; 
				}
			}
			
			if(prime_check == 0) {
				System.out.println(i);
				++prime_count;
			}

		}

		System.out.printf("1���� %d���� ������ �Ҽ��� %d�� �Դϴ�.", num, prime_count);

	}
}
