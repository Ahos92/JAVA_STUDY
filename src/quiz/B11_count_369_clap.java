package quiz;

public class B11_count_369_clap {

	// 사용자로부터 정수 하나를 입력 받고
	// 해당 숫자 까지 369게임이 진행된다면 박수를 총 몇번 쳐야하는지 세어보세요

	public static void main(String[] args) {

		// 프로그램 실행시간 측정 System.currentTimeMillis(); 밀리세컨드
		Long start_time = System.currentTimeMillis();	
		// '인트'로 하기
		int user = 99999999;
		int i = 0, check = 0, clap_count = 0;
		
		boolean debugMode = false;
		
		while(i < user) { 
			++i;
			check = i;
			
			if(debugMode) {
				System.out.printf("%d : ", i);
			}
			
			while(check != 0) {
				if(check % 10 == 3 || check % 10 == 6 || check % 10 == 9) {
					++clap_count;
					if(debugMode) {
						System.out.print("짝");
					}
				}
				check /= 10;			
			}
			if(debugMode) {
				System.out.println();
			}
		}
		System.out.println(clap_count+"회");
		
		Long end_time = System.currentTimeMillis();
		
		System.out.println("걸린 시간 : "+(end_time - start_time));
	
		// 문자 열로 하기
//		int clap = 0;
//		
//		for (int i = 1; i <= user; ++i) {
//			String ch = "" + i;
//			int len = ch.length();
//			
//			for (int k = 0; k < len; ++k) {
//				if(ch.charAt(k) == '3' ||
//						ch.charAt(k) == '6' ||
//						ch.charAt(k) == '9') {
//					++clap;
//				}
//			}
//		}System.out.println(clap);
//		
//		Long end_time = System.currentTimeMillis();
//		
//		System.out.println("걸린 시간 : "+(end_time - start_time));

	}
}

