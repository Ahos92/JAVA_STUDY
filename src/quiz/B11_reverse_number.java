package quiz;

import java.util.Scanner;

public class B11_reverse_number {

	// ������ �ϳ� �Է¹ް�
	// �� ������ ���� �ڸ����� ������� ����غ�����

	public static void main(String[] args) {

		int num = 68123;

		int reversed = 0 ;
		
		while(true) {
			reversed += num % 10;
			num /= 10;
			
			if(num <= 0) {
				break;
			}
			
			reversed *= 10;
		}
		System.out.println(reversed);
	}
}
