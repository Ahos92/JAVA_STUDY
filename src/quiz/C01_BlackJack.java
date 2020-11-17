package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C01_BlackJack {

	// 1. 베팅을 하고 딜러와 플레이어가 카드를 2장씩받는다
	//		이 때, 딜러의 카드는 한 장 가려놓는다.
	// 2. 사용자는 카드를 더뽑을지(hit) 멈출지(stand)를 결정한다
	// 3. 사욪아가 멈추면 딜러가 가려져 있떤 카드를 뒤집은 뒤 규칙에 따라 카드를 뽑는다.
	//			컴퓨터는 카드 합이 16 이하일때 무조건 뽑고, 17이상이면 무조건 멈춘다
	// 4. 딜러보다 합이 높거나 정확하게 21이라면 승리 (베팅 금액만큼 플레이어의 돈이 오른다)
	//		딜러보다 합이 낮거나 21이 넘으면 패배 (베팅 금액만큼 플레이어의 돈이 떨어진다)
	//		딜러와 카드합이 같다면 무승부

	// 전역 변수
	public static int[] deck;
	public static int[] com;
	public static int[] user;

	// ★★★
	public static int[] game_index;

	public static int[] suffle() {
		int[] deck = new int[52];

		for(int i = 0; i < 52; ++i) {
			deck[i] = i;
		}

		for(int i = 0; i < 100; i++) {
			int ran = (int)(Math.random() * 51 + 1);

			int temp = deck[0];
			deck[0] = deck[ran];
			deck[ran] = temp;
		}

		return deck;
	}
	
	//★★★
	public static void draw(int player) {
		switch(player) {
		case 0:
			com[game_index[0]++] = deck[game_index[2]++];
			break;
		case 1:
			user[game_index[1]++] = deck[game_index[2]++];
			break;
		}

	}
	
	public static String prettyCard(int card) {
		char[] shape = {'♠', '♥', '♣', '◆'};
		String[] value = {"A", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "J", "Q", "K"};

		int shape_index = card / 13;
		int value_index = card % 13;

		return shape[shape_index] + value[value_index];
	}
	
								// 카드 뒷면까기 mode에따라
	public static void print_game(int mode) {

		System.out.println("딜러의 카드 : ");
		System.out.print("\t");
		for(int i = 0; i < game_index[0]; ++i) {
			if(i == 0 && mode == 0) {
				System.out.print("X  ");
			}else {
				System.out.print(prettyCard(com[i]) + "  ");
			}
		}
		if(mode == 0) {
			System.out.println();
		}else {
			System.out.printf("(%d)\n", game_value(0));
		}

		System.out.println("플레이어의 카드 : ");
		System.out.print("\t");
		for(int i = 0; i < game_index[1]; ++i) {
			System.out.print(prettyCard(user[i]) + "  ");
		}
		System.out.printf("(%d)\n", game_value(1));
	}

	public static int game_value(int p) {
		int[] values = new int[game_index[p]];

		for(int i = 0; i < values.length; ++i) {
			values[i] = p == 0 ? com[i] % 13 : user[i] % 13;
		}

		return getSum(values);
	}
	public static int getSum(int[] values) {
		int sum = 0;
		int ace = 0;
		for (int i = 0; i < values.length; ++i) {
			if(values[i] == 0) {
				sum += 11;
				ace += 1;
			} else if(values[i] >= 10) {
				sum += 10;
			} else {
				sum += values[i];
			}
		}	
		// A가 1개 이상 존재하면서 합이 21을 넘을 때 1로 변경
		while(sum > 21 && ace > 0) {
			sum -= 10;
			ace -= 1;
		}

		return sum;
	}

	public static int game_start() {

		deck = suffle();

		com = new int[12];
		user = new int[12];
		game_index = new int[3]; 
		//★★★ com = 0 , user = 1 , deck = 2
		// 덱에서 뺄대 덱인덱스 증가 유저의 덱에 넣을떈 넣으면서 증가 / 단항 계산식 ++ 사용..
		// draw 메서드에 적용
		
		draw(0); // 딜러(컴퓨터) - 0
		draw(1); // 유저(플레이어) - 1
		draw(0);
		draw(1);

		Scanner console = new Scanner(System.in);
		int user_value = game_value(1);
		//플레이어 선택
		while((user_value = game_value(1)) < 21) {

			print_game(0);

			System.out.print("1. hit\t 2. stand \n>>");
			int select = console.nextInt();

			if(select == 2) {
				break;				
			} else if (select == 1) {
				draw(1);
			}
		}
		
		print_game(1);
		
		int com_value;
		while((com_value = game_value(0)) <= 16) {
			try {
			Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			draw(0);
			print_game(1);
			com_value = game_value(0);
		}

		return check_game(com_value, user_value);
	}

	public static int check_game(int com, int user) {

		if (com > 21 && user > 21) {
			return 0;
		} else if (com == user) {
			return 0;
		} else if (user <= 21 && com > 21) {
			return user == 21 ? 2 : 1;
		}else if( user <= 21 && user > com) {
			return user == 21 ? 2 : 1;
		}
		else if(user == 21 && user > com) {
			return 2;
		}
		return -1;
	}
	public static void main(String[] args) {

		int play_money = 10000;

		while(play_money > 0) {
			int betting = 5000;

			int game_result = game_start();
			play_money -= betting;
			
			System.out.println("================================");
			StringBuilder msg = new StringBuilder("게임 결과 : ");

			switch(game_result) {
			case 0: 
				play_money += betting;
				msg.append("무승부\n");
				break;
			case 1:
				play_money += betting * 2;
				msg.append("승리\n");
				break;
			case 2:
				play_money += (int)(betting * 2.5);
				msg.append("BlackJack\n");
				break;
			default:
				msg.append("패배\n");
			}
			msg.append("현재 잔액 : " + play_money + "원");
			System.out.println(msg);
			System.out.println("================================");
		}
	}
}

