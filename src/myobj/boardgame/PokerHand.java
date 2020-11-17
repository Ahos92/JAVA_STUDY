package myobj.boardgame;

import java.util.*;

public class PokerHand {
	
	// 다섯장의 PokerCard를 가지고있어야함
	
	// 다섯장의 PokerCard의 숫자 무늬를 통해 족보를 완성해야함
	
	// 다른 PokerHand 인스턴스와 족보를 통한 크기비교가 가능해야 함
	
	// 다섯장 중 원하는 카드만 공개하는 기능
	
	// 카드를 한장씩 추가하는 기능

	public static void main(String[] args) {
		Deck deck = new Deck();
		CheckPoker check = new CheckPoker();
		int result = 0, count = 0;
		
		while(true) {
			++count;
			HashSet<String> hand = new HashSet<>();
			// 시작 핸드
			while(hand.size() != 5) {
				hand.add(deck.draw());
			}
			if(check.pedigree(hand) == 1 || check.pedigree(hand) == 2) {
			System.out.print(hand);
			result = check.pedigree(hand);
			check.resultPrint(result);
			System.out.println("횟수 : "+count);
			break;
			}
		}
		
		
		
	}
	
}
