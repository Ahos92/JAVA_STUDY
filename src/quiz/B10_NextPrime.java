package quiz;

import java.util.Scanner;

public class B10_NextPrime {

	
	//����ڷκ��� ���ڸ� �Է�
	// �Է¹��� ������  ��ũ�ų� ���� ���� �Ҽ��� ã�Ƽ� ����غ�����
	
	public static void main(String[] args) {
		
		System.out.print("�� �Է� >");
		int num = new Scanner(System.in). nextInt();
		
		int prime = 0;
		
		for(int i = num; true; ++i) {
			
			int check = 0;
			int sqrt = (int)Math.sqrt(i);
			for(int j = 2; j <= sqrt; ++j) {
				
				if(i % j == 0) {
					++check; 
				}
			}
			
			if(check == 0) {
				if(num <= 0 || num == 1) {
					i = 2;
				}	
				prime = i;
				System.out.printf("\'%d\'���� ũ�ų� ���� ���� �Ҽ��� \'%d\'�Դϴ�.", num, prime);
				break;
			}
		}
		
		
	}
}
