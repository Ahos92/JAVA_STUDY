package study;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import myobj.fruit.Mango;

public class D05_TreeSet {

	// # TreeSet
	//	- 중복값을 저장할 수 없다. 
	//	- 데이터를 저장할 때 오름차순으로 저장한다.
	//	- 요소로 null을 허용하지 않는다.
	//	- 저장 속도가 느린 대신 데이터 접근 / 검색 속도가 빠르다.

	
	//	★
	// ※ 중복제거 + 원하는 부분 집합 선택 + 크기 정렬
	public static void main(String[] args) {
		
		TreeSet<Mango> mango_tree = new TreeSet<>(new Comparator<Mango>() {
			
			@Override
			public int compare(Mango o1, Mango o2) {
				// Set은 같은 데이터를 허용하지 않기 때문에
				// 같은 당도를 지닌 망고가 모두사라짐
				// o1.sweet - o2.sweet
				
				// 같은 당도를 지녔을때는 망고id(각 개체 유일한 값) 기준으로 다시 정렬하기
				//	 	원래는 hashCode()로 사용 (Primary Key개념)
				// myobj.fruit.Mango
				int sweet_value = o1.sweet - o2.sweet;
				return sweet_value == 0 ? o1.hashCode() - o2.hashCode() : sweet_value;
			}
			
		});
		
		for (int i = 0; i < 100; ++i) {
			mango_tree.add(new Mango());
		}
//		System.out.println(mango_tree.size());
		
		// Comparable에서 return 0; 은 같은 객체임을 의미한다. 그래서 사라짐
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// # TreeSet 활용
		
		// descendingSet() : 내림차순으로 정렬된 Set을 반환
		System.out.println(mango_tree.descendingSet());
		
		// TreeSet을 원하는 기준으로 나누어 사용하기
		System.out.println("\n headSet");
		// HeadSet (toElement) : 맨 앞부터 원하는 기준 까지의 Set을 반환
		Set<Mango> hSet = mango_tree.headSet(new Mango(0, 12, 50));
		System.out.println(hSet.size());
		
		System.out.println("\n tailSet");
		// TaleSet (fromElemnet) : 원하는 기준부터 맨 마지막 까지 Set을 반환
		SortedSet<Mango> tSet = mango_tree.tailSet(new Mango(0, 12, 50));
		System.out.println(tSet.size());
		
		System.out.println("\n h_tSet");
		SortedSet<Mango> h_tSet = tSet.headSet(new Mango(0, 15, 100));
		System.out.println(h_tSet.size());
		
		System.out.println("\n t_tSet");
		SortedSet<Mango> t_tSet = tSet.tailSet(new Mango(0, 15, 100));
		System.out.println(t_tSet.size());
		
		System.out.println("\n subSet(13, 15) from <=  값 <= to");
		// subSet(from, to) from <=  <= to
		SortedSet<Mango> result = mango_tree.subSet(new Mango(0, 12, 100), new Mango(0, 15, 100));
		System.out.println(result);
		
////////////////////////////////////////////
		System.out.println();
		// # TreeSet요소를 하나만 선택하기
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(1);
		int_tree.add(75);
		int_tree.add(3);
		int_tree.add(40);
		int_tree.add(11);

		// floor , ceiling: 해당 값 기준으로 가장 가까운 '작은 값' / '큰 값' 을 반환 
		// 					같은 값이면 해당 값 반환 (이상 / 이하)
		
		// lower , higher : 해당 값 기준으로 가장 가까운 '작은 값' / '큰 값' 을 반환 
		// 					같은 값이면 무시 (초과 / 미만)
		
		System.out.println(int_tree.floor(11));
		System.out.println(int_tree.ceiling(11));
		
		System.out.println(int_tree.lower(11));
		System.out.println(int_tree.higher(11));
		
		
		
	}
	
}
