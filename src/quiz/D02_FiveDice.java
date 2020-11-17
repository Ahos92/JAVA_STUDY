package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import myobj.boardgame.FiveDice;

public class D02_FiveDice {

	// 랜덤으로 5개의 주사위를 굴린 다음 (주사위 1~6)

	// 풀하우스 ( 같은 숫자가 2개 / 3개)
	// 스몰 스트레이트 ( 1234 / 2345 / 3456 )
	// 라지 스트레이트 ( 12345 / 23456)
	// 4다이스 ( 같은 숫자 4개 )
	// 5다이스 ( 같은 숫자 5개 )

	// 를 구분하는 클래스 작성 테스트


	public static void main(String[] args) throws InterruptedException {

		FiveDice dice = new FiveDice();

		// 던진 후에 원하는 주사위를 여러개 골라 다시 던질수 있는 기능 추가		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			dice.roll();
			System.out.println("reRoll 할 주사위 선택\n>>");
			Set<Integer> rerolls = new HashSet<>();
			
			int i = -1;
			while ((i = sc.nextInt()) != -1) {
				rerolls.add(i);
			}
			System.out.print("다시 굴릴 인덱스 : " + rerolls);
			dice.reRoll(rerolls);
			
			Thread.sleep(2000);

		}
		
	}
}
