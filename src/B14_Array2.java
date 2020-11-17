
public class B14_Array2 {


	// 배열안에 배열 넣기
	// 주소안에 주소 - 더블포인터

	public static void main(String[] args) {

		int[] scores = { 99, 123, 456, 789 };

		int[][] arr2 = {	
				new int[5], // 비어있는 5칸 배열 
				null, // 지정안함 - int형 배열이라도 배열 자체가 참조형 변수 타입이라 가능
				{1, 2, 3, 4, 5, 6, 7, 8, 9},
				new int[] {1, 2, 3},
				scores
		};
		
		// ★
		System.out.println("arr2에 저장된 배열이 몇개인가요? " + arr2.length);
		System.out.println("arr2에 저장된 배열중 0번째 배열이 몇개인가요? " + arr2[0].length);
//		System.out.println("arr2에 저장된 배열중 1번째 배열이 몇개인가요? " + arr2[1].length); // null 이라 에러
		System.out.println("arr2에 저장된 배열중 2번째 배열이 몇개인가요? " + arr2[2].length);
		System.out.println("arr2에 저장된 배열중 3번째 배열이 몇개인가요? " + arr2[3].length);
		System.out.println("arr2에 저장된 배열중 4번째 배열이 몇개인가요? " + arr2[4].length);
		
		// 길이를 활용하여 n차원 배열은 n중 반복문으로 모두 탐색할 수 있다.
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(i + "번째 배열 : ");
			int[] arr = arr2[i];
					
					if(arr != null) {
						for(int j = 0; j < arr.length; ++j) {
							System.out.print(arr2[i][j]+" ");
							//System.out.print(arr[j] + " "); 같은 의미 
						}
						System.out.println();
					}else{
						System.out.println("null");
					}
					System.out.println();
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////
		// 활용 예
		int[][] scores2 = {
				{80, 90, 100},
				{50, 60, 70},
				{40, 30, 100},
				{90, 90, 90},
		};
		
		// 1. 원
		// 2. 네모
		// 3. X
		// 게임 맵에 많이 사용 / 적이어느위치에 나올것인가 등
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
				case 2: System.out.print("■ ");
					break;
				case 3: System.out.print("§ ");
					break;
				case 5: System.out.print("† ");
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
