package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerCard {

	// 타입을 내가 만들어버리는게 궁극
	Rank rank;
	Suit suit;
	
	public PokerCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return suit.getShape() + rank.getSimpleName();
	}
	
}
