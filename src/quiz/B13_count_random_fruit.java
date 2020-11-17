package quiz;

import java.util.Arrays;
import java.util.Random;

public class B13_count_random_fruit {

	// 크기 100의 배열에 랜덤 과일 문자열을 저장해보세요
	// 	(apple, banana, orange, peach, kiwi)

	// 각 과일이 몇번 등장했는지 모두 기록하고 출력
	public static void main(String[] args) {

		Random ran = new Random();

		int size = 100;

		String[] fruits_box = new String[size];
		String[] fruits_name = {"apple", "banana", "orange", "peach", "kiwi"};
		
		//////////////////////////////////////////////////////////////////////////////
		int apple = 0;
		int banana = 1; 
		int orange = 2; // 이런식으로 index에 이름을 지어주면좋다
						// enum(열거형데이터)의 시초 
		
		System.out.println("오렌지의 번호 : "+ orange);
		System.out.println("오렌지 이름 :" + fruits_name[orange]);
		////////////////////////////////////////////////////////////////////////////////
		
		
		int fruit_kind = fruits_name.length;

		for(int i = 0; i < size; i++) {

			fruits_box[i] = fruits_name[ran.nextInt(fruit_kind)];
		}

		int[] count_box = new int[fruit_kind];
		
		// 1. me
		for(int i = 0; i < fruit_kind; i++) {

			for(int j = 0; j < size; j++) {

				if(fruits_box[j] == fruits_name[i]) {
					count_box[i] += 1;
				}

			}
			System.out.printf("%-7s의 총 갯수는 %d개 입니다.\n", fruits_name[i], count_box[i]);

		}

		// 2.
//		for(int i = 0; i < 100; i++) {
//
//			if(fruits_box[i] == fruits_name[0]) {
//				count_box[0] += 1;
//
//			}else if(fruits_box[i] == fruits_name[1]) {
//				count_box[1] += 1;
//
//			}else if(fruits_box[i] == fruits_name[2]) {
//				count_box[2] += 1;
//
//			}else if(fruits_box[i] == fruits_name[3]) {
//				count_box[3] += 1;
//
//			}else if(fruits_box[i] == fruits_name[4]) {
//				count_box[4] += 1;
//			}
//
//		}
//		for(int i = 0; i < fruit_kind; i++) {
//			System.out.printf("%-7s의 총 갯수는 %d개 입니다.\n", fruits_name[i], count_box[i]);
//		}
	}

}
