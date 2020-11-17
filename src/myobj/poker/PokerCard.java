package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerCard {

	// Ÿ���� ���� ���������°� �ñ�
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
