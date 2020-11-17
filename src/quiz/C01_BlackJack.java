package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C01_BlackJack {

	// 1. ������ �ϰ� ������ �÷��̾ ī�带 2�徿�޴´�
	//		�� ��, ������ ī��� �� �� �������´�.
	// 2. ����ڴ� ī�带 ��������(hit) ������(stand)�� �����Ѵ�
	// 3. ��B�ư� ���߸� ������ ������ �ֶ� ī�带 ������ �� ��Ģ�� ���� ī�带 �̴´�.
	//			��ǻ�ʹ� ī�� ���� 16 �����϶� ������ �̰�, 17�̻��̸� ������ �����
	// 4. �������� ���� ���ų� ��Ȯ�ϰ� 21�̶�� �¸� (���� �ݾ׸�ŭ �÷��̾��� ���� ������)
	//		�������� ���� ���ų� 21�� ������ �й� (���� �ݾ׸�ŭ �÷��̾��� ���� ��������)
	//		������ ī������ ���ٸ� ���º�

	// ���� ����
	public static int[] deck;
	public static int[] com;
	public static int[] user;

	// �ڡڡ�
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
	
	//�ڡڡ�
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
		char[] shape = {'��', '��', '��', '��'};
		String[] value = {"A", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "J", "Q", "K"};

		int shape_index = card / 13;
		int value_index = card % 13;

		return shape[shape_index] + value[value_index];
	}
	
								// ī�� �޸��� mode������
	public static void print_game(int mode) {

		System.out.println("������ ī�� : ");
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

		System.out.println("�÷��̾��� ī�� : ");
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
		// A�� 1�� �̻� �����ϸ鼭 ���� 21�� ���� �� 1�� ����
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
		//�ڡڡ� com = 0 , user = 1 , deck = 2
		// ������ ���� ���ε��� ���� ������ ���� ������ �����鼭 ���� / ���� ���� ++ ���..
		// draw �޼��忡 ����
		
		draw(0); // ����(��ǻ��) - 0
		draw(1); // ����(�÷��̾�) - 1
		draw(0);
		draw(1);

		Scanner console = new Scanner(System.in);
		int user_value = game_value(1);
		//�÷��̾� ����
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
			StringBuilder msg = new StringBuilder("���� ��� : ");

			switch(game_result) {
			case 0: 
				play_money += betting;
				msg.append("���º�\n");
				break;
			case 1:
				play_money += betting * 2;
				msg.append("�¸�\n");
				break;
			case 2:
				play_money += (int)(betting * 2.5);
				msg.append("BlackJack\n");
				break;
			default:
				msg.append("�й�\n");
			}
			msg.append("���� �ܾ� : " + play_money + "��");
			System.out.println(msg);
			System.out.println("================================");
		}
	}
}

