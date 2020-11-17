package myobj.boardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiveDice {


	private List<Integer> dices;
	private List<Integer> counts;
	
	private String made; // flag

	private static int NUM_OF_DICE = 5;
	private static int DICE_FACET = 6;

	private final static Set<Set<Integer>> LARGE_CASES;
	private final static Set<Set<Integer>> SMALL_CASES;

	static {

		LARGE_CASES = new HashSet<>(3);
		for (int i = 1; i <= 2; ++i) {
			Set<Integer> large = new HashSet<>(5);
			Collections.addAll(large, i, i+1, i+2, i+3, i+4);
			LARGE_CASES.add(large);
		}

		SMALL_CASES = new HashSet<>(2);
		for (int i = 1; i <= 3; ++i) {
			Set<Integer> small = new HashSet<>(4);
			Collections.addAll(small, i, i+1, i+2, i+3);
			SMALL_CASES.add(small);
		}

	}

	public FiveDice() {
		dices = new ArrayList<>(NUM_OF_DICE);
		counts = new ArrayList<>(DICE_FACET);
		made = "UNCHECKED";
		
		Collections.addAll(dices, 0, 0, 0, 0, 0);
		Collections.addAll(counts, 0, 0, 0, 0, 0, 0);
		// ArrayList는 초기 용량이 가득 차게 되면 용량을 1.5배씩 증가시킨다.
	}

	private void count() {
		for (int i = 0; i < DICE_FACET; ++i) {
			int dice_num = i + 1;

			counts.set(i, Collections.frequency(dices, dice_num));

		}
	}

	private String check() {
		// check by counts
		if(counts.contains(5)) {
			return "Five Dice !!";
		}else if(counts.contains(4)) {
			return "Four Dice !!";
		}else if(counts.contains(2) && counts.contains(3)) {
			return "Full Houes !!";
		}

		// check by dices
		for(Set<Integer> ls : LARGE_CASES) {
			if(dices.containsAll(ls)) {
				return "LARGE STRAIGHT !!";
			}
		}

		for(Set<Integer> ss : SMALL_CASES) {
			if(dices.containsAll(ss)) {
				return "SMALL STRAIGHT !!";
			}
		}

		return "NO MATCHES";
	}

	public void roll() {
		for(int i = 0; i < NUM_OF_DICE; ++i) {
			dices.set(i, (int)(Math.random() * DICE_FACET + 1));
			// set은 덮어쓰는것
		}
		count();
		print();

	}

	public void reRoll(Set<Integer> rerolls) {
		if (rerolls.size() == 0) {
			System.out.println("NOTHING CHANGES");
			return;
		}
		
		made = "UNCHECKED";
		
		for(int i : rerolls) {
			dices.set(i-1, (int)(Math.random() * DICE_FACET + 1));
			System.out.println();
		}
		count();
		print();
	}
	public void print() {
		System.out.print(dices + " : ");
		
		if (made.equals("UNCHECKED")) {
			made = check();
		}
		System.out.println(made);
	}
}
