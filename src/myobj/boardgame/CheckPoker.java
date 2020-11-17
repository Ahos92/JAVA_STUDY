package myobj.boardgame;

import java.util.*;

public class CheckPoker {
	
	private List<Integer> cards;
	private List<Integer> counts;
	
	private final static List<List<Integer>> STRAIGHT_CASE;
	private final static List<Integer> MOUNTAIN;
	static {
		
		STRAIGHT_CASE = new ArrayList<>(8);
		for (int i = 1; i <= 9; ++i) {
			List<Integer> straight = new ArrayList<>();
			Collections.addAll(straight, i, i+1, i+2, i+3, i+4);
			STRAIGHT_CASE.add(straight);
		}
		
		MOUNTAIN = new ArrayList<>();
		Collections.addAll(MOUNTAIN, 1, 10, 11, 12, 13);
	}
	
	
	public CheckPoker() {
		counts = new ArrayList<>(5);
	
		Collections.addAll(counts, 0, 0, 0, 0, 0);
	}

	public int pedigree(HashSet<String> hand) {
		numCheck(hand);
		cards = stCheck(hand);
		boolean flush = shapeCheck(hand);
		
		if (cards.containsAll(MOUNTAIN) && flush) {
			return 1;	
		} else if (cards.containsAll(MOUNTAIN) && !flush) {
			return 7;
		}	
		
		for (List<Integer> bst : STRAIGHT_CASE) {
			if (cards.containsAll(bst) && Collections.max(cards) == 5 && flush) {
				return 2;
			} else if (cards.containsAll(bst) && Collections.max(cards) == 5) {
				return 8;
			} if (cards.containsAll(bst) && flush) {
				return 3;
			}if (cards.containsAll(bst)) {
				return 9;
			}
			
		}
	
		if (flush) {
			return 6;
		}
	
		if(counts.contains(4)) {
			return 4;
		} else if(counts.contains(3) && counts.contains(2)) { 
			return 5;
		} else if(counts.contains(3)) {
			return 10;
		} else if(counts.contains(2) && Collections.frequency(counts, 1) == 1) {
			return 11;
		} else if(counts.contains(2)) {
			return 12;
		}
	
		return 0;
	}

	private boolean shapeCheck(HashSet<String> hand) {
		ArrayList<Character> ch_shape = new ArrayList<>(5);
		char s;
		for(String i : hand) {
			s = i.charAt(0);
			ch_shape.add(s);
		}
		boolean flush = false;
		for(int i = 0; i < 5; i++) {
			if (Collections.frequency(ch_shape, ch_shape.get(i)) == 5){
				flush = true;
			}
			
		}
		return flush;
	}
	
	private void numCheck(HashSet<String> hand) {
		ArrayList<Character> ch_num = new ArrayList<>(5);
		char n;
		for(String i : hand) {
			n = i.charAt(1);
			ch_num.add(n);
		}
		
		for (int i = 0; i < 5; ++i) {
		
			counts.set(i, Collections.frequency(ch_num, ch_num.get(i)));

		}
//		System.out.print(ch_num);

	}
	
	private ArrayList<Integer> stCheck(HashSet<String> hand){
		ArrayList<Integer> ch_num = new ArrayList<>(5);
		int n;
		for(String i : hand) {
			n = i.charAt(1);
			if(n >= 65) {
				ch_num.add(n-55);
			}else {
				ch_num.add(n-'0');
			}
		}
//		System.out.println(ch_num);
		return ch_num;
	}
	
	public void resultPrint(int result) {
		
		switch(result) {
		case 1: System.out.println("Royal Straight Flush");
			break;
		case 2: System.out.println("Back Straight Flush");
			break;
		case 3: System.out.println("Straight Flush");
			break;
		case 4: System.out.println("Four Card");
			break;
		case 5: System.out.println("Full House");
			break;
		case 6: System.out.println("Flush");
			break;
		case 7: System.out.println("Mountain");
			break;
		case 8: System.out.println("Back Straight");
			break;
		case 9: System.out.println("Straight");
			break;
		case 10: System.out.println("Triple");
			break;
		case 11: System.out.println("Two pair");
			break;
		case 12: System.out.println("One pair");
			break;
		case 0: System.out.println("No match");
			break;
		}
		
	}

}
