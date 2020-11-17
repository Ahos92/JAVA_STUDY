package quiz;

import java.util.HashSet;
import java.util.Set;

public class D02_LottoSet {

	// 1부터 45사이의 중복없는 랜덤 숫자로 이루어진 6자리 HashSet을 생성해보세요.
	public static Set<Integer> generateLottoNum() {
		Set<Integer> lotto = new HashSet<>();
		
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*44 +1));		
		}
		return lotto;
	}
	
	public static void main(String[] args) {
		
		System.out.println(generateLottoNum());
		
	}
	
}
