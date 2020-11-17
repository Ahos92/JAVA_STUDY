
import java.util.*;

public class D02_HashSet {

	// # Set
	//	- '집합'을 구현해놓은 클래스
	//	-  요소로 같은 값이 들어오는 것을 중복을 허용하지 않는다
	
	// # Hash
	//	- 어떤 값을 넣었을 때 전혀 예측할 수 없는 값이 생성되어야 하는 알고리즘
	//	- 예측할 수 없는 값을 이용하므로 정렬이 불가능하다
	//	- 생성된 값으로 원래 값을 찾는 것이 불가능에 가깝다  
	//	- 다시 원래 값으로 돌아갈 수 없는 단방향성 알고리즘
	//	- 속도가 빠르고 보안성도 뛰어난 알고리즘
	
	// a	->	5341341243
	// b 	->	5123341512
	// c	->	3435232123
	
	public static void main(String[] args) {

		HashSet<Integer> even = new HashSet<>();
		
		// 똑같은 데이터를 저장 할수 없다 (Set 특징)
		even.add(2);
		even.add(2);
		even.add(2);
		even.add(4);
		even.add(6);
		even.add(16);
		// 값이 순서대로 보관되지 않는다 index의 개념이 없음 (Hash 특징)
		System.out.println(even);
		
		// HashSet은 index가 없기 떄문에 하나만 꺼낼수가 없다.
		for(int i : even) {
			System.out.println("하나씩 꺼냄 : " + i);
		}
		
		//
		ArrayList<String> animal_list = new ArrayList<>();
		
		animal_list.add("zibra");
		animal_list.add("zibra");
		animal_list.add("lion");
		animal_list.add("lion");
		animal_list.add("lion");
		animal_list.add("tiger");
		animal_list.add("eagle");
		animal_list.add("eagle");
		
		Collections.shuffle(animal_list);
		System.out.println(animal_list);
		
		//////////////////////////////////////////////////////////////////////////////
		//업캐스팅 활용 / Set에 HashSet 넣기  / Collection에 ArrayList넣기
		// 중복제거 효과
		Set<String> animal_set = new HashSet<>(animal_list);
		System.out.println(animal_set);
		
		////////////////////////////////////////////////////////////////////////////
		// 컬렉션을 배열로 변환하기 1
		Object[] animal_arr = animal_list.toArray();
		//String으로 받을 때 다운캐스팅 필요
		String first_animal = (String)animal_arr[0];
		System.out.println(first_animal);
		
		// 컬렉션을 배열로 변환하기 2
		//	- 미리 만들어둔 제네릭 배열을 전달하는 방식
		String[] animal_arr2 = new String[animal_set.size()];
		animal_set.toArray(animal_arr2);
		
		first_animal = animal_arr2[0];
		System.out.println(first_animal);
		
		///////////////////////////////////////////////////////////////////////////
		// contains : 컬렉션에 해당요소가 있는지 여부를 반환
		System.out.println(animal_list.contains("lion"));
		System.out.println(animal_set.contains("lion"));
		
		// size
		System.out.println(animal_set.size());
		
		// remove - 성공시 true 반환 
		System.out.println(animal_set.remove("lion"));
		
		
		// # 다른 컬렉션을 이용하는 메서드들
		Set<Character> alphabets01 = new HashSet<>();
		Set<Character> alphabets02 = new HashSet<>();
		
		Collections.addAll(alphabets01, 'A', 'B', 'C', 'D', 'E');
		Collections.addAll(alphabets02, 'D', 'E', 'F', 'G', 'H');
		
		System.out.println(alphabets01);
		System.out.println(alphabets02);
		
		// 1. addAll(Collection) : 전달한 컬렉션의 모든 값을 추가한다.
		List<Character> alpha_all = new ArrayList<>();
		
		alpha_all.addAll(alphabets01);
		alpha_all.addAll(alphabets02);
		
		System.out.println(alpha_all);
		
		// 2. removeAll(Collection) : 전달한 컬렉션과 일치하는 모든 값을 제거한다
		Set<Character> to_remove = new HashSet<>();
		Collections.addAll(to_remove, 'A', 'D');
		
		alpha_all.removeAll(to_remove);
		
		System.out.println(alpha_all);
		
		// 3. retainAll(Collection) : 전달한 컬렉션과 일치하는 값만 유지한다.
		List<Character> to_retain = new ArrayList<>();
		
		to_retain.add('E');
		to_retain.add('G');
		
		alpha_all.retainAll(to_retain);
		System.out.println(alpha_all);
		
		// 4. coniansAll(Collection) : 전달한 컬렉션의 모든 요소가 포함되어있는지 확인
		Collections.addAll(alpha_all, 'A', 'B', 'C', 'D');
		
		Set<Character> must_contain = new HashSet<>();
		
		must_contain.add('A');
		must_contain.add('B');
		must_contain.add('C');
		must_contain.add('D');
//		must_contain.add('Z');
		
		System.out.println(alpha_all + "에 "
						+ must_contain + "이 모두 포함되어 있나요? "
						+ alpha_all.containsAll(must_contain));
		
		
	}

}
