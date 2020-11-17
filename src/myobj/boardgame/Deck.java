package myobj.boardgame;

import java.util.*;

public class Deck {
	
	String card;
	int card_num;
	int shape_num;
	List<String> deck;

	public Deck() {
		deck = new ArrayList<>();
		shapeCard(1);
		shapeCard(2);
		shapeCard(3);
		shapeCard(4);
	}
	
	public String draw() {
		return deck.get((int)(Math.random() * 52));
	}

	// ¢¼ ¡ß ¢¾ ¢À
	private void shapeCard(int s) {
		String shape = null;
		if(s == 1) {
			shape ="¢¼";
		} else if(s == 2) {
			shape = "¡Þ";
		} else if(s == 3) {
			shape = "¢½";
		} else {
			shape = "¢À";
		}
		for(int i = 1; i <= 13; ++i) {
			card = String.format("%s%X", shape, i);
			deck.add(card);
		}
	}
}
