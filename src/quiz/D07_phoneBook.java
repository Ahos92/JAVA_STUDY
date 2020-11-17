package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class D07_phoneBook {

	// # HashMap�� �̿��� PhoneBook�� �����غ�����

	// 1. �׷� / ��ȭ��ȣ / �̸� ����
	// 2. �׷� �̸��� Ű������ ������ �ش� �׷��� ��ȭ��ȣ ����� ���´�
	// 3. ��ȭ��ȣ ��Ͽ� ��ȭ��ȣ�� Ű�� ������ �̸��� ���´�

	// # �����ؾ��� �޼���
	// 1. ���ο� �׷��� �߰��ϴ� �޼���
	// 2. �����ϴ� �׷쿡 ���ο� ��ȭ��ȣ�� ����ϴ� �޼���
	// 3. ��ϵ� ��� ��ȭ��ȣ�� �������� ����ϴ� �޼���
	// 4. �̸��� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ��ȭ��ȣ�� ��µǴ� �޼���
	// 5. ��ȭ��ȣ�� �Ϻθ� �Է��ϸ� ��ġ�ϴ� ��� ��ȭ��ȣ�� ��µǴ� �޼���

	HashMap<String, HashMap<String, String>> phone_book;
	
	public D07_phoneBook() {
		phone_book = new HashMap<>();
	}
	
	// boolean
	// �������� ������ ���� (��������)
	/** �׷� �߰������� true*/
	boolean addGroup(String groupName) {
		if (phone_book.containsKey(groupName)) {
			System.err.println("�̹� �����ϴ� �׷� �Դϴ�.");
			return false;
		} else {
			phone_book.put(groupName, new HashMap<>());
			System.out.println("���ο� �׷��� �߰��Ǿ����ϴ�. [" + groupName + "]");
			return true;
		}
	}
	/** ��ȣ �߰� ������ true*/
	boolean addPhoneNumber(String groupName, String name, String phoneNumber) {

		if (!phone_book.containsKey(groupName)) {
			System.err.println("�ش��ϴ� �׷��� �����ϴ�. [" + groupName + "]");
			return false;
		}

		HashMap<String, String> addPhone = phone_book.get(groupName);
		
		if(addPhone.containsKey(phoneNumber)) {
			System.out.println("�ش� ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println("���ο� ��ȣ�� �߰��߽��ϴ�.");
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
	
	// str.contains("str"); ���ٷγ����¸޼���
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
	
	/** ��ȣ�� �˻��ϸ� �ش��ϴ� entry���� Set���·� ��ȯ�Ǵ� �޼���*/
	Set<List<String>> searchByPhoneNumber(String tel_frag) {
		
		Set<List<String>> to_return = new HashSet<>();
		
		for (HashMap<String, String> groupMap : phone_book.values()) {
			
			for (String phoneNumber : groupMap.keySet()) {
			
				if (phoneNumber.contains(tel_frag)) {
					
					// ã������� ������ ����Ʈ�� �籸���Ͽ� ����
					// index 0���� �̸� / 1���� ��ȣ
					List<String> found = new ArrayList<>();
					found.add(groupMap.get(phoneNumber));
					found.add(phoneNumber);
					
					to_return.add(found);
				}	
			}	
		}
		return to_return;
	}

	/** �̸����� �˻��ϸ� �ش��ϴ� entry���� Set���·� ��ȯ�Ǵ� �޼���*/
	Set<List<String>> searchByName(String name_frag) {
		
		Set<List<String>> to_return = new HashSet<>();
		
		for (HashMap<String, String> groupMap : phone_book.values()) {
			
			for (String phoneNumber : groupMap.keySet()) {
			
				String name = groupMap.get(phoneNumber);
				
				if (str_contains(name, name_frag)) {
					
					// ã������� ������ ����Ʈ�� �籸���Ͽ� ����
					// index 0���� �̸� / 1���� ��ȣ
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

		pb.addGroup("����");
		pb.addGroup("ģ��");
		pb.addGroup("ȸ��");
		pb.addGroup("ȸ��");

		pb.addPhoneNumber("�ٺ�", "name", "phoneNumber");
		
		pb.addPhoneNumber("����", "����", "010-0000-0000");
		pb.addPhoneNumber("����", "�ƺ�", "010-1111-1111");

		pb.addPhoneNumber("ģ��", "�达", "010-2222-2222");
		pb.addPhoneNumber("ģ��", "�̾�", "010-3333-3333");

		pb.addPhoneNumber("ȸ��", "�达", "010-4444-4444");
		pb.addPhoneNumber("ȸ��", "�̾�", "010-5555-5555");
		pb.addPhoneNumber("ȸ��", "�־�", "010-6666-6666");
		pb.addPhoneNumber("ȸ��", "�ھ�", "010-6666-6666");

		pb.printAllList();
		
		System.out.println(pb.searchByName("��"));
		
		System.out.println(pb.searchByPhoneNumber("010"));
		
	}

}
