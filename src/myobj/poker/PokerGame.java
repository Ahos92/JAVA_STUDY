package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

	// �ټ����� PokerCard�� �������־����
	
	// �ټ����� PokerCard�� ���� ���̸� ���� ������ �ϼ��ؾ���
	
	// �ٸ� PokerHand �ν��Ͻ��� ������ ���� ũ��񱳰� �����ؾ� ��
	
	// �ټ��� �� ���ϴ� ī�常 �����ϴ� ���
	
	// ī�带 ���徿 �߰��ϴ� ���

	public static void main(String[] args) {
		int round = 0;
		while (true) {
//			++round;
			PokerDeck deck = new PokerDeck();
			PokerHand player01 = new PokerHand(5);
			
			player01.add(deck.draw());
			player01.add(deck.draw());
			player01.add(deck.draw());
			player01.add(deck.draw());
			player01.add(deck.draw());

			PokerHand player02 = new PokerHand(5);

			player02.add(deck.draw());
			player02.add(deck.draw());
			player02.add(deck.draw());
			player02.add(deck.draw());
			player02.add(deck.draw());
		
			PokerHandRanking hr = new PokerHandRanking(player01);
		
			
			System.out.println("--------player01'S deck");
			player01.openAll();
			player01.show();
			System.out.println("--------player02'S deck");
			player02.openAll();
			player02.show();
			
			ArrayList<PokerHand> players = new ArrayList<>();
			players.add(player01);
			players.add(player02);
			
			System.out.println("�̱� ��� : " + Collections.max(players).hands);
			break;
			
		}

	}
}
