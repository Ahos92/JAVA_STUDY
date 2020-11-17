package study;
import java.util.Random;

public class B12_random {

	public static void main(String[] args) {

		// JAVA���� ������ ���� �����ϱ�

		// 1. Math.random()
		//	- Double Ÿ���� 0 <= x < 1 �� ���� �Ҽ��� ����.
		//	- �� �Ҽ��� �̿� �Ͽ� ���ϴ� ���ڸ� ���� ���

		// ���ϴ� ���ڸ� ����� ���� (ex 80~100)
		// 	1. ���ϴ� ������ ������ ���Ѵ�. ( * 21)
		//	2. ���ϴ� ���� �� ���� ���� ���ڸ� ���Ѵ�. ( + 80)
		//	3. �Ҽ��� �Ʒ��� ���� ( int typecasting ....)
				for(int i = 0; i < 10; ++i) {
					System.out.print((int)(Math.random() * 21 + 80)+" ");
				}

		// 2. Random Ŭ������ �̿�
		//	- ������ �� ���ϴ� �õ��ȣ ���ð���
		//	- ���� �õ� ��ȣ�� �����ϸ� ���� ��
		//	- �õ��ȣ�� �������� ������ ������ �õ� ����
				
		Random ran = new Random();
		
		//Random.nextInt(bound); : ���ϴ� ������ ������ ��ȯ�Ѵ�.
		// 0~ bound �̸��� ������ ��ȯ�Ѵ�.
		//	bound ���� �������� ������ int���� ��ü���� ���� ������ ���õȴ�.
		System.out.println("\nran.nextInt(30) :"+ran.nextInt(30)); // 0 ~ 29
		System.out.println("ran.nextInt() : "+ran.nextInt());			//int ��ü
		System.out.println("ran.nextInt(21)+80 : "+ran.nextInt(21)+80); // 80 ~ 100
		
		// ���� : 3000�̻� 5000������ ���� ������ 100�� �����ϰ�
		//		�׵��� ���Դ� ���� ū ���� ���� ���� ���� ����غ�����.

		int max_num = 0, min_num = 0;
		int line = 0;

		for(int i = 0; i < 100; ++i) {

			int num = (int)(Math.random() * 2001 + 3000);
			
			if(i == 0) {
				max_num = num;
				min_num = num;
			}
			else{ 
				max_num = max_num < num ? num : max_num;

				min_num = Math.min(min_num, num);
			}
			System.out.printf("%-5d", num);
			
			line++;
			if(line == 10) {
				System.out.println();
				line = 0;
			}

		}
		System.out.printf("\n3000 ~ 5000 ���� ������ \n���� ū  ���� : %d\n���� ���� ���� : %d ", max_num, min_num);

	}
	
	//

}
