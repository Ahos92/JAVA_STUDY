package myobj.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PokerHand implements Comparable<PokerHand> {

	ArrayList<PokerCard> hands;
	
	boolean[] opens;
	
	public PokerHand(int handsize) {
		hands = new ArrayList<>(handsize);
		opens = new boolean[handsize];
		
		for(int i = 0; i < handsize; ++i) {
			if(i < 2) {
				opens[i] = false;
			}else {
				opens[i] = true;
			}
		}
	}
	
	public void add(PokerCard card) {
		hands.add(card);
	}

	public void show() {
		for(int i = 0, size = hands.size(); i < size; ++i) {
			System.out.print((i + 1) + "번째 카드 : ");
			if(opens[i]) {
				System.out.print(hands.get(i));
			}else {
				System.out.print("NOT OPENED");
			}
			System.out.println();
		}	
	}
	
	public void open(int hand_index) {
		opens[hand_index] = !opens[hand_index];
	}
	
	public void openAll() {
		Arrays.fill(opens, true);
	}
	
	Set<Rank> getRankSet(){
		Set<Rank> ranks = new HashSet<>();
		
		for(PokerCard hand : hands) {
			ranks.add(hand.rank);
		}
		
		return ranks;
	}

	@Override
	public int compareTo(PokerHand o) {
		PokerHandRanking rank1 = new PokerHandRanking(this);
		PokerHandRanking rank2 = new PokerHandRanking(o);
		
		System.out.println("player01 : " + rank1.getHandrank());
		System.out.println("player02 : " + rank2.getHandrank());
		
		return rank1.getHandrank().compareTo(rank2.getHandrank());
	}

}
