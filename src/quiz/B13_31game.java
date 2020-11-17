package quiz;

import java.util.Random;
import java.util.Scanner;

public class B13_31game {

	// 컴퓨터와 사람이 번갈아 가면서 숫자를 선택 한다. (1, 2, 3)
	// 컴퓨터는 랜덤으로 숫자를 선택 한다.
	// 마지막에 31을 부르는 사람 혹은 컴퓨터가 패배한다

	public static void main(String[] args) {

		Scanner player = new Scanner(System.in);
		Random ran = new Random();

		System.out.println("1. 31게임 시작");
		System.out.println("2. exit");
		int menu = player.nextInt();

		int game_num = 0;
		boolean re_game = true;

		if(menu == 1) {

			while(re_game) {

				boolean computer_turn = ran.nextBoolean();
				System.out.printf("<%s>의 선공입니다!\n",
						computer_turn ? "컴퓨터" : "유저");

				while(true) {
					//입력
					int count31;	
					if(computer_turn) {

						int com = ran.nextInt(3)+1;
						count31 = com;
						System.out.printf("컴퓨터 > %d\n", com );

					} else {
						count31 = player.nextInt();

						if(count31 > 3 || count31 < 1) {
							System.out.println("올바른 숫자를 입력해주세요.");
							continue;
						}
						System.out.printf("유저 > %d\n", count31);
					} 
					
					//처리
					game_num += count31;
					System.out.printf("\t현재 숫자 : %d / 31\n", game_num);
					
					computer_turn = !computer_turn;
					
					if(game_num >= 30) {
						break;
					}
				}
				System.out.printf("<%s>의 승리!\n", computer_turn ? "유저" : "컴퓨터");
				
				System.out.println("\n1. 다시 하기");
				System.out.println("2. 종료 하기");
				int re_button = player.nextInt();
				re_game = re_button == 1 ? true : false;
			}
		}
		if(menu == 2 || re_game == false) {
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}

	}

}
