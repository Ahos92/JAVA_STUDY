package study;

public class B10_innerLoop {

	public static void main(String[] args) {
		
		// 콘솔은 가로로만 출력
		// 세로로 변하는 값
		// 가로로 변하는 값 캐치하기
		
		// 반복문 내 반복문
		for(int i = 0; i < 10; ++i) {
			System.out.printf("=====================바깥 반복문 %d\n", i);
			for(int j = 0; j < 5; ++j) {
				System.out.printf("----------------안쪽 반복문 %d-%d\n", i, j);
				for(int k = 0; k < 2; ++k) {
					System.out.printf("++++++++제일안쪽 반복문 %d-%d-%d\n", i, j, k);
				}
			}
		}
		
		// 다중 반복문 구구단 출력
		// 	- 2~9
		for(int dan = 2; dan <= 9; ++dan) {
			System.out.printf("+++ %d단 +++\n", dan);
			for(int gop = 1; gop <= 9; ++gop) {
				
				System.out.printf("%d x %d = %d\n", dan, gop, dan*gop);
			}
			System.out.println();
		}
	}
	
}
