package study;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class D07_HashMap {

	// # Map
	//	- Key / Value 가 한세트를 이루는 자료구조
	//	- Key값을 통해 Value를 찾는 자료구조
	//	- Key는 중복을 허용하지 않는다.
	
	// # HashMap
	//	- 
	
	public static void main(String[] args) {
	
		// Map 은 제네릭을 두개 받는다.
		//	 - Integer를 쓰면 배열과 비슷하기때문에 굳이 쓸이유는 없다.
		Map<String, String> map1 = new HashMap<>();
		
		// put() 를 이용해 데이터 저장.
		//	- Key는 해당 데이터의 카테고리(속성)
		//	- Value는 해당 항목의 값을 저장한다.
		map1.put("이름", "꼬맹이");
		map1.put("나이", "5살");
		map1.put("견종", "포메라니안");
		map1.put("견종", "치와와"); // ★ 같은 Key를 입력하면 수정이됨
		map1.put("주인의 나이", "5살");
		
		// # get메서드에 Key값을 전달해 원하는 항목의 값을 꺼낸다.
		System.out.println(map1.get("견종"));
		System.out.println();
		
		// # 반복문으로 Map활용하기
		//	- KeySet : Key들로 이루어진 Set을 반환한다.
		//	- ValueSet : Value들로 이루어진 Collection을 반환한다.
		//	- entrySet :  Entry<K, V>들로 이루어진 Set을 반환한다.
		System.out.println("map1의 key들 : " + map1.keySet());
		System.out.println("map1의 value들 :" + map1.values());
		System.out.println("map1의 entry들 : " + map1.entrySet());
		System.out.println();
		
		// # KeySet 반복문
		for (String key : map1.keySet()) {
			System.out.println(key + " - " + map1.get(key));
		}
		System.out.println();
		
		// # values 반복문(잘 안씀)
		//	- value 로 key를 찾는것은 불가능
		for (String value : map1.values()) {
			System.out.println(value);
		}
		System.out.println();
		
		// # entrySet 반복문
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());
		}
		System.out.println();
		
		// # containskey
		System.out.println(map1.containsKey("주인의 나이"));
		System.out.println(map1.containsKey("주인의 나이 "));
		System.out.println();
		// # containsValue
		System.out.println(map1.containsValue("5살"));
		System.out.println(map1.containsValue("5살 "));
		System.out.println();
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("TEST", "ABC");
		map2.put("TEST2", "DEF");
		// # putAll로 다른 Map의 데이터를 추가할 수 있다. ( key / value 타입이 맞아야함) 
		map1.putAll(map2);
		System.out.println(map1);
		System.out.println();
		
		// # remove메서드로 원하는데이터를 지울 수 있다.
		//	- key값 만으로 지우는경우 - 삭제하고 반환
		///	- key value 모두로 지우는 경우 : 정확하게 일치할 떄만 삭제
		System.out.println(map1.remove("나이", "6살"));
		System.out.println(map1);
		System.out.println(map1.size()+"개");
		System.out.println(map1.remove("나이", "5살"));
		System.out.println(map1);
		System.out.println(map1.size()+"개");
		System.out.println();
		
		
		// # get메서드를 사용하다가 데이터 혹은 키가 없는 경우 null이 반환된다
		//	NullPointerException이 발생할 위험이 있다.
		//		- getOrDefault() 이용해 null 값이 반환되는 상황에 기본값을 반환받을 수 있다.
		System.out.println(map1.getOrDefault("엄마의 이름", "기본값"));
		System.out.println(map1.get("엄마의 견종"));
		System.out.println();
		
		// Map타입 내부에 Map타입 넣기
		HashMap<String, HashMap<String, String>> phone_book =  new HashMap<>();
		// 새로운 해쉬맵 인스턴스를 값으로 저장 하면  -> 키값으로 해당 해쉬맵을 꺼낼수 있다. ( 변수대신 key 값을 이용하는 개념
		phone_book.put("학원", new HashMap<>());
		phone_book.put("가족", new HashMap<>());
		phone_book.put("고등학교", new HashMap<>());
		phone_book.put("중학교", new HashMap<>());
		phone_book.put("동아리", new HashMap<>());
		
		HashMap<String, String> group_map = phone_book.get("학원");
		group_map.put("010-1234-1234", "김말숙");
		group_map.put("010-5678-5678", "김말숙");
		
		System.out.println(phone_book);
		
	}
	
}
