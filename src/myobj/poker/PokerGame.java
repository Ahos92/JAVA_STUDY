package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

	// 다섯장의 PokerCard를 가지고있어야함
	
	// 다섯장의 PokerCard의 숫자 무늬를 통해 족보를 완성해야함
	
	// 다른 PokerHand 인스턴스와 족보를 통한 크기비교가 가능해야 함
	
	// 다섯장 중 원하는 카드만 공개하는 기능
	
	// 카드를 한장씩 추가하는 기능

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
			
			System.out.println("이긴 사람 : " + Collections.max(players).hands);
			break;
			
		}

	}
}
