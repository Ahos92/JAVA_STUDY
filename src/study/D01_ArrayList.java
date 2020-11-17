package study;
import java.util.ArrayList;
import java.util.Collections;

public class D01_ArrayList {

	// # Java Collections
	//	- 자바에서 기본적으로 제공하는 자료구조 인터페이스
	//	- Collections 인터페이스를 구현한 클래스 List, Set이 있다
	
	// # ArrayList
	//	- 배열과 다르게 크기가 자동으로 조절되는 배열
	// 	- 배열과 유사한 형태이기 때문에 순차적으로 데이터에 접근할 때 가장 유리하다
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		// ArrayList의 add(item) : 데이터를 리스트의 맨 뒤에 순차적으로 추가한다.
		list.add("홍길동");
		list.add("전우치");
		list.add("임꺽정");
		list.add("김두한");
		
		System.out.println(list);
		
		// add(index, item) : 원하는 위치에 데이터를 넣는다 , 중간에 넣으면 뒤쪽 데이터 한칸씩 밀림
		list.add(2, "이순신");
	
		System.out.println(list);
	
		// ArrayList의 get(index) : 배열처럼 인덱스로 데이터를 꺼낼 수 있다.
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		// ArrayList에 타입을 지정해주지 않으면 
		// 모든 타입이 들어갈수있는 ArrayList가 된다.
		list.add(0, 1234);
		list.add(0, new Apple());
		
		System.out.println(list);
		// 모든 타입이 들어있기 때문에 꺼낼 때 어떤 타입으로 꺼낼지 알기 힘들어진다.
		String name = (String)list.get(5);
		// Object 타입 : 모든 타입의 부모
		Object thing = list.get(0);
		
		System.out.println(name);
		System.out.println(thing);
		
		// # 타입을 지정한 ArrayList 생성하기 
		//	<>로 타입을 지정해주면 ArrayList의 모든 메서드의 타입이 바뀐다.
		//	<>는 Generic이라고 부른다.
		ArrayList<String> fn_list =  new ArrayList<>();
		
		fn_list.add("apple");
		fn_list.add("orange");
		fn_list.add("kiwi");
		
		System.out.println(fn_list);
		System.out.println(fn_list.get(0));
		
		// size(); : 리스트의 크기를 반환;
		System.out.println(list.size());
		System.out.println(fn_list.size());
		
		// remove(index) : 원하는 위치 아이템(요소 = element) 삭제 (삭제하면서 반환)
		// remove(item) : 원하는 값을 하나만 삭제
		System.out.println("삭제된 아이템 반환 : " + list.remove(0));
		System.out.println(list);
		
		fn_list.add(0, "apple");
		fn_list.add("apple");
		fn_list.add("apple");
		fn_list.add("apple");
		fn_list.add("apple");
		
		System.out.println(fn_list);
		
		System.out.println("값으로 삭제된 반환 값 : " + fn_list.remove("apple"));
		
		System.out.println(fn_list);
		int count = 0;
		while(fn_list.remove("apple")) {
			System.out.println("사과가 삭제 되었습니다. " + ++count);
		}
		System.out.println("삭제가 모두 끝났습니다. " + fn_list);
		
		
		// # ArrayList와 반복문을 함께 사용하면 아주 편하다
		for(int i = 0, size = list.size(); i < size; ++i) {
			System.out.println(list.get(i));
		}
		// forEach
		for (String fn : fn_list) {
			System.out.println("fruit name : " + fn);
		}
		
		ArrayList<Person> plist = new ArrayList<>();
		
		plist.add(new Dentist());
		plist.add(new Doctor());
		plist.add(new Police());
		
		for (Person p : plist) {
			p.sayHi();
		}
		
		// # 컬렉션은 Collections의 기능들을 사용할 수 있다. 다형성의 활용 예 
		
		// 한번에 여러개 추가하기
		Collections.addAll(fn_list, "apple", "apple", "apple", "apple");
		
		System.out.println(fn_list);
		
		// 등장 횟수
		System.out.println("apple의 등장 횟수 : " + 
						Collections.frequency(fn_list, "apple"));
		// 최대 최소
		System.out.println(Collections.min(fn_list));
		System.out.println(Collections.max(fn_list));
		
		// 순서대로 정렬
		Collections.sort(fn_list);
		System.out.println(fn_list);
		
		// 역순으로 정렬
		Collections.reverse(fn_list);
		System.out.println(fn_list);
		
		// 두 요소의 위치 교체
		Collections.swap(fn_list, 0, fn_list.size()-1);
		System.out.println(fn_list);
		
		// 뒤섞기
		Collections.shuffle(fn_list);
		System.out.println("shuffle : " + fn_list);
		
		// n칸씩 모든요소 순환
		Collections.rotate(fn_list, -1);
		System.out.println("rotate : " + fn_list);
		
		// 요소로 가득 채우기 (주로 초기화에 사용)
		Collections.fill(fn_list, "banana");
		System.out.println(fn_list);
		
		
	}
}
