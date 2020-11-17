package myobj.poker;

import java.util.Collections;
import java.util.LinkedList;

public class PokerDeck {

	LinkedList<PokerCard> deck;
	
//	public static final int DECKSIZE = 52;
	
	public PokerDeck() {
		
		deck = new LinkedList<>();

		for (Rank rank : Rank.values()) {
			for(Suit suit : Suit.values()) {
				deck.add(new PokerCard(rank, suit));
			}
		}
		
		Collections.shuffle(deck);
		System.out.println("[System] New Deck Created & Shuffled");
	}

	public PokerCard draw() {
		return deck.pop();
	}
	
}
