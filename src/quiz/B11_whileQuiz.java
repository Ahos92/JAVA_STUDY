package quiz;

public class B11_whileQuiz {
	
	//�ݵ�� while���� �̿�
	
	// 1 ���� 100������ 3�� ��� ����
	
	// 2 200���� 1���� ���
	
	// 3 1���� 200������ ������ 2�� ����� �ƴϰ� 3�� ����� �ƴ� ���ڵ��� ������ ���غ�����
	public static void main(String[] args) {
		
		int i = 0, sum = 0;
		while(i < 100) {
			i++;
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.printf("1���� 100���� 3�� ��� �� : %d\n\n", sum);
		
		int j = 200, num, line= 0;
		while(j > 0) {
			num = j;
			j--;
			line++;
			System.out.printf("%-4d", num);
			if(line == 20) {
				System.out.println();
				line = 0;
			}
		}
		System.out.println();
		
		int k = 0;
		sum = 0;
		while(k < 200) {
			k++;
			if(k % 2 == 0 || k % 3 == 0) {
				continue;
			}
			sum += k ; 
		}
		System.out.printf("2�ǹ���� �ƴϰ� 3�ǹ���� �ƴ� 1~200�� �� : %d", sum);
	}

}
