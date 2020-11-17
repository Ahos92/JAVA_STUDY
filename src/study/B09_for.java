package study;

public class B09_for {

	public static void main(String[] args) {

		// 반복문
		//	- for, while, do while, for each

		/* 
		   for(초기값; 조건; 증가값){
		 		조건이 true인동안 반복할 명령
		   }
		 */
		// 기본 ★ 횟수에 의미를 안둠
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
					System.out.printf("%d월은 겨울입니다.\n", month);
					break;
				default:
					System.out.printf("%d월은 아직 설정되지 않았습니다.\n", month);
					break;
			}
		}

		// 조건을 비우면 무한(true도 무한)
		// break이용 탈출
		num=0;
		for(;true;) {
			System.out.println(num+=9999);
			
			if(num>200000)
				break;
		}
		
		// continue 이용 스킵
		for(int i=0; i<100; ++i) {
			System.out.printf("%-3d", i);
			
			if(i%10 != 9)
				continue;
			
			System.out.println();
		}
		
		// 반복문으로 총합
		
		int sum =0;
		for(int i = 80; i<=333; ++i) {
			if(i%3==0)
				sum += i;
		}
		System.out.println(sum);
	}
}
