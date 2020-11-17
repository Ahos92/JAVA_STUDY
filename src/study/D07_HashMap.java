package study;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class D07_HashMap {

	// # Map
	//	- Key / Value �� �Ѽ�Ʈ�� �̷�� �ڷᱸ��
	//	- Key���� ���� Value�� ã�� �ڷᱸ��
	//	- Key�� �ߺ��� ������� �ʴ´�.
	
	// # HashMap
	//	- 
	
	public static void main(String[] args) {
	
		// Map �� ���׸��� �ΰ� �޴´�.
		//	 - Integer�� ���� �迭�� ����ϱ⶧���� ���� �������� ����.
		Map<String, String> map1 = new HashMap<>();
		
		// put() �� �̿��� ������ ����.
		//	- Key�� �ش� �������� ī�װ�(�Ӽ�)
		//	- Value�� �ش� �׸��� ���� �����Ѵ�.
		map1.put("�̸�", "������");
		map1.put("����", "5��");
		map1.put("����", "���޶�Ͼ�");
		map1.put("����", "ġ�Ϳ�"); // �� ���� Key�� �Է��ϸ� �����̵�
		map1.put("������ ����", "5��");
		
		// # get�޼��忡 Key���� ������ ���ϴ� �׸��� ���� ������.
		System.out.println(map1.get("����"));
		System.out.println();
		
		// # �ݺ������� MapȰ���ϱ�
		//	- KeySet : Key��� �̷���� Set�� ��ȯ�Ѵ�.
		//	- ValueSet : Value��� �̷���� Collection�� ��ȯ�Ѵ�.
		//	- entrySet :  Entry<K, V>��� �̷���� Set�� ��ȯ�Ѵ�.
		System.out.println("map1�� key�� : " + map1.keySet());
		System.out.println("map1�� value�� :" + map1.values());
		System.out.println("map1�� entry�� : " + map1.entrySet());
		System.out.println();
		
		// # KeySet �ݺ���
		for (String key : map1.keySet()) {
			System.out.println(key + " - " + map1.get(key));
		}
		System.out.println();
		
		// # values �ݺ���(�� �Ⱦ�)
		//	- value �� key�� ã�°��� �Ұ���
		for (String value : map1.values()) {
			System.out.println(value);
		}
		System.out.println();
		
		// # entrySet �ݺ���
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + " / " + entry.getValue());
		}
		System.out.println();
		
		// # containskey
		System.out.println(map1.containsKey("������ ����"));
		System.out.println(map1.containsKey("������ ���� "));
		System.out.println();
		// # containsValue
		System.out.println(map1.containsValue("5��"));
		System.out.println(map1.containsValue("5�� "));
		System.out.println();
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("TEST", "ABC");
		map2.put("TEST2", "DEF");
		// # putAll�� �ٸ� Map�� �����͸� �߰��� �� �ִ�. ( key / value Ÿ���� �¾ƾ���) 
		map1.putAll(map2);
		System.out.println(map1);
		System.out.println();
		
		// # remove�޼���� ���ϴµ����͸� ���� �� �ִ�.
		//	- key�� ������ ����°�� - �����ϰ� ��ȯ
		///	- key value ��η� ����� ��� : ��Ȯ�ϰ� ��ġ�� ���� ����
		System.out.println(map1.remove("����", "6��"));
		System.out.println(map1);
		System.out.println(map1.size()+"��");
		System.out.println(map1.remove("����", "5��"));
		System.out.println(map1);
		System.out.println(map1.size()+"��");
		System.out.println();
		
		
		// # get�޼��带 ����ϴٰ� ������ Ȥ�� Ű�� ���� ��� null�� ��ȯ�ȴ�
		//	NullPointerException�� �߻��� ������ �ִ�.
		//		- getOrDefault() �̿��� null ���� ��ȯ�Ǵ� ��Ȳ�� �⺻���� ��ȯ���� �� �ִ�.
		System.out.println(map1.getOrDefault("������ �̸�", "�⺻��"));
		System.out.println(map1.get("������ ����"));
		System.out.println();
		
		// MapŸ�� ���ο� MapŸ�� �ֱ�
		HashMap<String, HashMap<String, String>> phone_book =  new HashMap<>();
		// ���ο� �ؽ��� �ν��Ͻ��� ������ ���� �ϸ�  -> Ű������ �ش� �ؽ����� ������ �ִ�. ( ������� key ���� �̿��ϴ� ����
		phone_book.put("�п�", new HashMap<>());
		phone_book.put("����", new HashMap<>());
		phone_book.put("����б�", new HashMap<>());
		phone_book.put("���б�", new HashMap<>());
		phone_book.put("���Ƹ�", new HashMap<>());
		
		HashMap<String, String> group_map = phone_book.get("�п�");
		group_map.put("010-1234-1234", "�踻��");
		group_map.put("010-5678-5678", "�踻��");
		
		System.out.println(phone_book);
		
	}
	
}
