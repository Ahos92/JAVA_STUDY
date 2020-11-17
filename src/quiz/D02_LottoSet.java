package quiz;

import java.util.HashSet;
import java.util.Set;

public class D02_LottoSet {

	// 1���� 45������ �ߺ����� ���� ���ڷ� �̷���� 6�ڸ� HashSet�� �����غ�����.
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
