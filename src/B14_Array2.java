
public class B14_Array2 {


	// �迭�ȿ� �迭 �ֱ�
	// �ּҾȿ� �ּ� - ����������

	public static void main(String[] args) {

		int[] scores = { 99, 123, 456, 789 };

		int[][] arr2 = {	
				new int[5], // ����ִ� 5ĭ �迭 
				null, // �������� - int�� �迭�̶� �迭 ��ü�� ������ ���� Ÿ���̶� ����
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				new int[] {1, 2, 3},
				scores
		};
		
		// ��
		System.out.println("arr2�� ����� �迭�� ��ΰ���? " + arr2.length);
		System.out.println("arr2�� ����� �迭�� 0��° �迭�� ��ΰ���? " + arr2[0].length);
//		System.out.println("arr2�� ����� �迭�� 1��° �迭�� ��ΰ���? " + arr2[1].length); // null �̶� ����
		System.out.println("arr2�� ����� �迭�� 2��° �迭�� ��ΰ���? " + arr2[2].length);
		System.out.println("arr2�� ����� �迭�� 3��° �迭�� ��ΰ���? " + arr2[3].length);
		System.out.println("arr2�� ����� �迭�� 4��° �迭�� ��ΰ���? " + arr2[4].length);
		
		// ���̸� Ȱ���Ͽ� n���� �迭�� n�� �ݺ������� ��� Ž���� �� �ִ�.
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(i + "��° �迭 : ");
			int[] arr = arr2[i];
					
					if(arr != null) {
						for(int j = 0; j < arr.length; ++j) {
							System.out.print(arr2[i][j]+" ");
							//System.out.print(arr[j] + " "); ���� �ǹ� 
						}
						System.out.println();
					}else{
						System.out.println("null");
					}
					System.out.println();
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////
		// Ȱ�� ��
		int[][] scores2 = {
				{80, 90, 100},
				{50, 60, 70},
				{40, 30, 100},
				{90, 90, 90},
		};
		
		// 1. ��
		// 2. �׸�
		// 3. X
		// ���� �ʿ� ���� ��� / ���̾����ġ�� ���ð��ΰ� ��
		int[][] map = {
				{2, 2, 4, 4, 4},
				{2, 2, 4, 4, 4, 4, 1},
				{2, 2, 4, 4, 4},
				{2, 2, 4, 3, 4, 4 ,5},
				{2, 2, 2, 2, 2, 2, 2, 2},
				{2, 2, 2, 2, 2, 2, 2, 2},
		};
		
		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				
				switch(map[i][j]) {
				case 1: System.out.print("o ");
					break;
				case 2: System.out.print("�� ");
					break;
				case 3: System.out.print("�� ");
					break;
				case 5: System.out.print("�� ");
				 	break;
				default: System.out.print(" ");
					
				}
			}
			System.out.println();
		}
		
		
		
//		final int width = 10;
//		final int height = 10;
//		
//		for (int i = 0; i < width; ++i) {
//			
//			for (int j = 0; j < height; ++j) {
//				
//				for (int[] point : points) {
//					if()
//				}
//				System.out.print("X ");
//			}
//			System.out.println();
//			
//		}

		
	}
}
