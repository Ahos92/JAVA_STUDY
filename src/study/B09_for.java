package study;

public class B09_for {

	public static void main(String[] args) {

		// �ݺ���
		//	- for, while, do while, for each

		/* 
		   for(�ʱⰪ; ����; ������){
		 		������ true�ε��� �ݺ��� ���
		   }
		 */
		// �⺻ �� Ƚ���� �ǹ̸� �ȵ�
		for(int i = 0; i<5; ++i) {
			System.out.println("Hello, world!"+i);
		}

		// 
		int num =0;
		for(; num<5;) {
			System.out.println("d"+num);
			++num;
		}
		
		//
		for(int month=1; month<=12; ++month) {
			switch(month){
				case 1: case 2: case 3:
					System.out.printf("%d���� �ܿ��Դϴ�.\n", month);
					break;
				default:
					System.out.printf("%d���� ���� �������� �ʾҽ��ϴ�.\n", month);
					break;
			}
		}

		// ������ ���� ����(true�� ����)
		// break�̿� Ż��
		num=0;
		for(;true;) {
			System.out.println(num+=9999);
			
			if(num>200000)
				break;
		}
		
		// continue �̿� ��ŵ
		for(int i=0; i<100; ++i) {
			System.out.printf("%-3d", i);
			
			if(i%10 != 9)
				continue;
			
			System.out.println();
		}
		
		// �ݺ������� ����
		
		int sum =0;
		for(int i = 80; i<=333; ++i) {
			if(i%3==0)
				sum += i;
		}
		System.out.println(sum);
	}
}
