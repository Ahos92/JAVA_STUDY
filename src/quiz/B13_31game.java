package quiz;

import java.util.Random;
import java.util.Scanner;

public class B13_31game {

	// ��ǻ�Ϳ� ����� ������ ���鼭 ���ڸ� ���� �Ѵ�. (1, 2, 3)
	// ��ǻ�ʹ� �������� ���ڸ� ���� �Ѵ�.
	// �������� 31�� �θ��� ��� Ȥ�� ��ǻ�Ͱ� �й��Ѵ�

	public static void main(String[] args) {

		Scanner player = new Scanner(System.in);
		Random ran = new Random();

		System.out.println("1. 31���� ����");
		System.out.println("2. exit");
		int menu = player.nextInt();

		int game_num = 0;
		boolean re_game = true;

		if(menu == 1) {

			while(re_game) {

				boolean computer_turn = ran.nextBoolean();
				System.out.printf("<%s>�� �����Դϴ�!\n",
						computer_turn ? "��ǻ��" : "����");

				while(true) {
					//�Է�
					int count31;	
					if(computer_turn) {

						int com = ran.nextInt(3)+1;
						count31 = com;
						System.out.printf("��ǻ�� > %d\n", com );

					} else {
						count31 = player.nextInt();

						if(count31 > 3 || count31 < 1) {
							System.out.println("�ùٸ� ���ڸ� �Է����ּ���.");
							continue;
						}
						System.out.printf("���� > %d\n", count31);
					} 
					
					//ó��
					game_num += count31;
					System.out.printf("\t���� ���� : %d / 31\n", game_num);
					
					computer_turn = !computer_turn;
					
					if(game_num >= 30) {
						break;
					}
				}
				System.out.printf("<%s>�� �¸�!\n", computer_turn ? "����" : "��ǻ��");
				
				System.out.println("\n1. �ٽ� �ϱ�");
				System.out.println("2. ���� �ϱ�");
				int re_button = player.nextInt();
				re_game = re_button == 1 ? true : false;
			}
		}
		if(menu == 2 || re_game == false) {
			System.out.println("������ �����մϴ�.");
			System.exit(0);
		}

	}

}
