package quiz;

import java.util.Arrays;

public class B14_Array2Quiz {

	public static void main(String[] args) {

		int[][] numArr = {
				{10, 10, 10, 10},
				{90, 50, 30, 70},
				{800, 500},
				{300, 300, 300}
		};

		// 1. numArr�� ���հ� ���(�Ҽ��� ��°�ڸ�) ���
		int sum = 0; 
		double length = 0;

		for(int i = 0; i < numArr.length; ++i) {
			length += numArr[i].length;

			for(int j = 0; j < numArr[i].length; ++j) {
				sum += numArr[i][j];	
			}

		}
		System.out.printf("numArr[]�� ���� : %d\nnumArr[]�� ������ ��� : %.2f\n", sum, sum / length);

		// 2. numArr�� �� ���� �հ� ���� ���� ��� ���ؼ� ���
		//		ex) 0���� �� : 10 + 10 + 10 + 10
		//			0���� �� : 10 + 90 + 800 + 300
		System.out.println();
		
		int[] sum_row = new int[numArr.length];
		int[] sum_col = new int[numArr.length]; 
		
		for(int i = 0; i < numArr.length; ++i) {
		
			for(int j = 0; j < numArr[i].length; ++j) {
				sum_row[i] += numArr[i][j];
				sum_col[j] += numArr[i][j];
			}		
		}
		System.out.println("���� �� : "+Arrays.toString(sum_row));
		System.out.println("���� �� : "+Arrays.toString(sum_col));
//		for(int i = 0; i < numArr.length; ++i) {
//			System.out.printf("%d���� �� : %d\n", i, sum_row[i]);
//			System.out.printf("%d���� �� : %d\n", i, sum_col[i]);
//			System.out.println();
//		}
	}

}
