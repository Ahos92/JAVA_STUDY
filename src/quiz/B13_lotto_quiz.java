package quiz;

import java.util.Arrays;
import java.util.Random;

public class B13_lotto_quiz {

	// 1 부터 45 사이의 중복없는 랜덤 숫자 6개로 이루어진 배열 생성

	public static void main(String[] args) {

		// 1.
//		int[] lotto = new int[6];
//		boolean duple = false;
//		int i = 0;
//
//		while(i != 6) {
//
//			lotto[i] = (int)Math.random()*45+1;
//
//			for(int j = 0; j < i; ++j) {
//
//				if(lotto[i] == lotto[j]) {
//					duple = true;
//					break;
//				}
//			}
//
//			if(!duple) {
//				++i;
//
//			}
//		}
//		System.out.println(Arrays.toString(lotto));
		
		
		// 2.
//		Random ran = new Random();
//		
//		int[] lotto = new int[6];
//		int[] number = new int[45];
//		
//		for(int i = 0; i < number.length; i++) {
//			number[i] = i + 1;
//		}
//		
//		int i = 0;
//		
//		while(i != 6) {
//			int random_index = ran.nextInt(45);
//			
//			if(number[random_index] != -1) {
//				lotto[i] = number[random_index];
//				number[random_index] = -1;
//				++i;
//			}
//		}
//		System.out.println("숫자 상태 : " + Arrays.toString(number));
//		System.out.println(Arrays.toString(lotto));
		

		// 3.
//		Random ran = new Random();
//		
//		int[] lotto = new int[6];
//		int[] number = new int[45];
//		
//		for(int i = 0; i < number.length; i++) {
//			number[i] = i + 1;
//		}
//		
//		// 섞는 방법
//		for(int i = 0; i < 5000; i++) {
//			int random_index = ran.nextInt(44) + 1;
//			
//			int temp = number[0];
//			number[0] = number[random_index];
//			number[random_index] = temp;
//		}
//		
//		for(int i = 0; i < 6; ++i) {
//			System.out.println(i+"번째 당첨 번호 : "+ number[i]);
//		}
		
	}
}
