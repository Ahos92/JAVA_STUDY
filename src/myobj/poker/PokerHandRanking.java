package myobj.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokerHandRanking {

	private static Set<Rank> MOUNTAIN;
	private static Set<Rank> BACK_STRAIGHT;
	private static Set<Set<Rank>> STRAIGHT;
	
	static {
		MOUNTAIN = new HashSet<>(5);
		Collections.addAll(MOUNTAIN, 
				Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE);
		
		BACK_STRAIGHT = new HashSet<>(5);
		Collections.addAll(MOUNTAIN, 
				Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.ACE);
		
		Rank[] rank_values = Rank.values();
		STRAIGHT = new HashSet<>(5);
		for (Rank rank : Rank.values()) {
			Set<Rank> straight = new HashSet<>();
			straight.add(rank);
			straight.add(rank_values[rank.ordinal() + 1]);
			straight.add(rank_values[rank.ordinal() + 2]);
			straight.add(rank_values[rank.ordinal() + 3]);
			straight.add(rank_values[rank.ordinal() + 4]);
			STRAIGHT.add(straight);
			
			if(rank.equals(Rank.NINE)) {
				break;
			}
		}
//		System.out.println(STRAIGHT);
	}
	
	public HandRank handrank;
	
	private List<Integer> rankCount;
	private List<Integer> suitCount;
	
	public PokerHandRanking(PokerHand hands) {
		rankCount = new ArrayList<>(Rank.NUM_OF_RANK);
		suitCount = new ArrayList<>(Suit.NUM_OF_SUIT);
		
		for(int i = 0; i < Rank.NUM_OF_RANK; ++i) {
			rankCount.add(0);
		}
		
		for(int i = 0; i < Suit.NUM_OF_SUIT; ++i) {
			suitCount.add(0);
		}
		
		check(hands);
		
	}
	
	private boolean checkMountain(Set<Rank> ranks) {
		return ranks.containsAll(MOUNTAIN);
	}
	
	private boolean checkBackSt(Set<Rank> ranks) {
		return ranks.containsAll(BACK_STRAIGHT);
	}
	
	private boolean checkStraight(Set<Rank> ranks) {
		for(Set straight : STRAIGHT) {
			if (ranks.containsAll(straight)) {
				return true;
			}
		}
		return false;
	}
	
	private void check(PokerHand player) {
		
		List<PokerCard> hands = player.hands;
		
		for (PokerCard hand : hands) {
			int rv = hand.rank.getRankValue();
			int sv = hand.suit.getSuitValue();
			
			rankCount.set(rv, rankCount.get(rv) + 1);
			suitCount.set(sv, suitCount.get(sv) + 1);
		}
	
		Set<Rank> ranks = player.getRankSet();
		
		
		if (suitCount.contains(5) && checkMountain(ranks)) {
			this.handrank = HandRank.ROYAL_FLUSH;
			
		} else if(suitCount.contains(5) && checkStraight(ranks)) {
			this.handrank = HandRank.STRAIGHT_FLUSH;
			
		} else if(suitCount.contains(5) && checkStraight(ranks)) {
			this.handrank = HandRank.STRAIGHT_FLUSH;
			
		} else if(rankCount.contains(4)){
			this.handrank = HandRank.FOUR_CARD;
			
		} else if(rankCount.contains(3) && rankCount.contains(2)){
			this.handrank = HandRank.FULL_HOUSE;
			
		} else if (suitCount.contains(5)) {
			this.handrank = HandRank.FLUSH;
			
		} else if (checkMountain(ranks)) {
			this.handrank = HandRank.MOUNTAIN;
			
		} else if(checkStraight(ranks)){
			this.handrank = HandRank.STRAIGHT;
			
		} else if(rankCount.contains(3)){
			this.handrank = HandRank.TRIPLE;
			
		} else if (rankCount.contains(2)) {
			if (rankCount.indexOf(2) !=  rankCount.lastIndexOf(2)) {
				//indexOf 앞에서부터 해당요소 찾기  / lastIndexof는 뒤에서부터 해당요소 찾기
				this.handrank = HandRank.TWO_PAIR;
			} else {
				this.handrank = HandRank.ONE_PAIR;
			}
			
		} else {
			this.handrank = handrank.HIGH_CARD;
		}

	}
	
	public HandRank getHandrank() {
		return handrank;
	}
	
}
