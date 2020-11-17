package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class D07_phoneBook {

	// # HashMap을 이용한 PhoneBook을 구현해보세요

	// 1. 그룹 / 전화번호 / 이름 저장
	// 2. 그룹 이름을 키값으로 넣으면 해당 그룹의 전화번호 목록이 나온다
	// 3. 전화번호 목록에 전화번호를 키로 넣으면 이름이 나온다

	// # 구현해야할 메서드
	// 1. 새로운 그룹을 추가하는 메서드
	// 2. 존재하는 그룹에 새로운 전화번호를 등록하는 메서드
	// 3. 등록된 모든 전화번호를 보기좋게 출력하는 메서드
	// 4. 이름의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 메서드
	// 5. 전화번호의 일부를 입력하면 일치하는 모든 전화번호가 출력되는 메서드

	HashMap<String, HashMap<String, String>> phone_book;
	
	public D07_phoneBook() {
		phone_book = new HashMap<>();
	}
	
	// boolean
	// 데이터의 안정성 위해 (덮어쓰기방지)
	/** 그룹 추가성공시 true*/
	boolean addGroup(String groupName) {
		if (phone_book.containsKey(groupName)) {
			System.err.println("이미 존재하는 그룹 입니다.");
			return false;
		} else {
			phone_book.put(groupName, new HashMap<>());
			System.out.println("새로운 그룹이 추가되었습니다. [" + groupName + "]");
			return true;
		}
	}
	/** 번호 추가 성공시 true*/
	boolean addPhoneNumber(String groupName, String name, String phoneNumber) {

		if (!phone_book.containsKey(groupName)) {
			System.err.println("해당하는 그룹이 없습니다. [" + groupName + "]");
			return false;
		}

		HashMap<String, String> addPhone = phone_book.get(groupName);
		
		if(addPhone.containsKey(phoneNumber)) {
			System.out.println("해당 정보가 수정되었습니다.");
		} else {
			System.out.println("새로운 번호를 추가했습니다.");
		}
		
		addPhone.put(phoneNumber, name);
		return true;
	}

	void printAllList() {
		for (Entry<String, HashMap<String, String>> group : phone_book.entrySet()) {
			System.out.printf("\n-------- %s --------\n", group.getKey());
			for(Entry<String, String> list : group.getValue().entrySet()) {
				System.out.printf("%s : %s\n", list.getValue(), list.getKey());
			}
		}

	}
	
	// str.contains("str"); 한줄로끝나는메서드
	private boolean str_contains(String check, String frag) {
		char[] chk = check.toCharArray();
		char[] fr = frag.toCharArray();
		
		char ch1 = fr[0];
		
		for (int i = 0; i < chk.length; ++i){
			
			if(chk[i] == ch1 && (chk.length - i) >= fr.length) {
				
				int cnt = 0;
				for (int j = 0; j < fr.length; ++i) {
					
					if (chk[i + j] == fr[j]) {
						++cnt;
					} else {
						break;
					}
				}
				
				if(cnt == fr.length) {
					return true;
				}
			}	
		}
		
		return false;
	}
	
	/** 번호로 검색하면 해당하는 entry들이 Set형태로 반환되는 메서드*/
	Set<List<String>> searchByPhoneNumber(String tel_frag) {
		
		Set<List<String>> to_return = new HashSet<>();
		
		for (HashMap<String, String> groupMap : phone_book.values()) {
			
			for (String phoneNumber : groupMap.keySet()) {
			
				if (phoneNumber.contains(tel_frag)) {
					
					// 찾은사람의 정보를 리스트로 재구성하여 전달
					// index 0번에 이름 / 1번에 번호
					List<String> found = new ArrayList<>();
					found.add(groupMap.get(phoneNumber));
					found.add(phoneNumber);
					
					to_return.add(found);
				}	
			}	
		}
		return to_return;
	}

	/** 이름으로 검색하면 해당하는 entry들이 Set형태로 반환되는 메서드*/
	Set<List<String>> searchByName(String name_frag) {
		
		Set<List<String>> to_return = new HashSet<>();
		
		for (HashMap<String, String> groupMap : phone_book.values()) {
			
			for (String phoneNumber : groupMap.keySet()) {
			
				String name = groupMap.get(phoneNumber);
				
				if (str_contains(name, name_frag)) {
					
					// 찾은사람의 정보를 리스트로 재구성하여 전달
					// index 0번에 이름 / 1번에 번호
					List<String> found = new ArrayList<>();
					found.add(name);
					found.add(phoneNumber);
					
					to_return.add(found);
				}	
			}	
		}
		return to_return;
	}

	public static void main(String[] args) {
		D07_phoneBook pb = new D07_phoneBook();

		pb.addGroup("가족");
		pb.addGroup("친구");
		pb.addGroup("회사");
		pb.addGroup("회사");

		pb.addPhoneNumber("바보", "name", "phoneNumber");
		
		pb.addPhoneNumber("가족", "엄마", "010-0000-0000");
		pb.addPhoneNumber("가족", "아빠", "010-1111-1111");

		pb.addPhoneNumber("친구", "김씨", "010-2222-2222");
		pb.addPhoneNumber("친구", "이씨", "010-3333-3333");

		pb.addPhoneNumber("회사", "김씨", "010-4444-4444");
		pb.addPhoneNumber("회사", "이씨", "010-5555-5555");
		pb.addPhoneNumber("회사", "최씨", "010-6666-6666");
		pb.addPhoneNumber("회사", "박씨", "010-6666-6666");

		pb.printAllList();
		
		System.out.println(pb.searchByName("김"));
		
		System.out.println(pb.searchByPhoneNumber("010"));
		
	}

}
