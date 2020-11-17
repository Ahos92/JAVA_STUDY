package quiz;

import java.util.*;

public class D02_check {
	
	// 풀하우스 ( 같은 숫자가 2개 / 3개)
	// 스몰 스트레이트 ( 1234 / 2345 / 3456 )
	// 라지 스트레이트 ( 12345 / 23456)
	// 4다이스 ( 같은 숫자 4개 )
	// 5다이스 ( 같은 숫자 5개 )

	private static boolean freq(ArrayList<Integer> dice) {
		Collections.sort(dice);
		for (int i = 0; i < dice.size(); ++i) {
			if(Collections.frequency(dice, dice.get(i)) > 2) {
				return false;
			}	
		}
		return true;
	}
	
	private static boolean largeSt(ArrayList<Integer> dice) {
		if((Collections.min(dice) == 1 && Collections.max(dice) == 5) 
				|| (Collections.min(dice) == 2 && Collections.max(dice) == 6)) {
			
			return true;
		}

		return false;
	}
	
	private static boolean smallSt(ArrayList<Integer> dice) {
		if((Collections.min(dice) == 1 && Collections.max(dice) == 4) 
				|| (Collections.min(dice) == 2 && Collections.max(dice) == 5)
				|| (Collections.min(dice) == 3 && Collections.max(dice) == 6)) {
			
			return true;
		}

		return false;
	}
	
	public static void check(ArrayList<Integer> dice) {
		
		Set<Integer> ch	= new HashSet<>(dice);

		Collections.sort(dice);
		
		if(ch.size() == 2 && 
				Collections.frequency(dice, dice.get(0)) == 2 
				&& Collections.frequency(dice, dice.get(2)) == 3) {
			
			System.out.println(" 풀 하우스!");
			
		}else if(ch.size() == 4 && freq(dice) && smallSt(dice)) {
			System.out.println(" 스몰 스트레이트!");
			
		}else if(ch.size() == 5 && freq(dice) && largeSt(dice)) {		
			System.out.println(" 라지 스트레이트!");
			
		}else if(ch.size() == 2 
							&& (Collections.frequency(dice, dice.get(0)) == 1 
							|| Collections.frequency(dice, dice.get(2)) == 4)) {
			System.out.println(" 4다이스!");
			
		}else if(ch.size() == 1) {
			System.out.println(" 5다이스!");
			
		}
		else {
			System.out.println(" No Matches");
		}
		
		
	}
	
}
