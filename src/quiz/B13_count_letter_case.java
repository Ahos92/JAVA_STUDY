package quiz;

import java.util.Arrays;

public class B13_count_letter_case {


	// ����ڷκ��� ������ �ϳ� �Է� �޾Ҵ� ġ��
	// �ش� ���ڿ��� ����ĺ��� ��� �����ߴ��� ��� ����غ�����
	// �� �ҹ���, ���� �����ؼ� ����

	public static void main(String[] args) {

		String str = "GitHub is home to over 50 million developers working together to host and review code z";

		int[] count_upper = new int[26];
		int[] count_lower = new int[26];
		int[] count_number = new int[10];

		// 2�� �迭
//		int[][] num = {{1, 2, 3, 4, 5}, 
//						{6, 7, 8, 9, 10}};
		
		for(int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch >= 'a' && ch <= 'z'){
				count_lower[ch - 'a'] +=1;
				
			} else if (ch >= 'A' && ch <= 'Z') {
				count_upper[ch - 'A'] += 1;
				
			} else if(ch >= '0' && ch <= '9') {
				count_number[ch - '0'] += 1;
				
			}		


		}
		for(int i = 0; i < 26; ++i) {
			if(count_lower[i] > 0) {
				System.out.printf("%c�� ������ Ƚ���� %d�Դϴ�.\n", i+'a', count_lower[i]);
			}
		}
		for(int i = 0; i < 26; ++i) {
			if(count_upper[i] > 0) {
				System.out.printf("%c�� ������ Ƚ���� %d�Դϴ�.\n", i+'A', count_upper[i]);
			}
		}
		for(int i = 0; i < 10; ++i) {
			if(count_number[i] > 0) {
				System.out.printf("%c�� ������ Ƚ���� %d�Դϴ�.\n", i+'0', count_number[i]);
			}
		}

	}
}
