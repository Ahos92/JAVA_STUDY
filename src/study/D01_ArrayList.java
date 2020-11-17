package study;
import java.util.ArrayList;
import java.util.Collections;

public class D01_ArrayList {

	// # Java Collections
	//	- �ڹٿ��� �⺻������ �����ϴ� �ڷᱸ�� �������̽�
	//	- Collections �������̽��� ������ Ŭ���� List, Set�� �ִ�
	
	// # ArrayList
	//	- �迭�� �ٸ��� ũ�Ⱑ �ڵ����� �����Ǵ� �迭
	// 	- �迭�� ������ �����̱� ������ ���������� �����Ϳ� ������ �� ���� �����ϴ�
	
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		// ArrayList�� add(item) : �����͸� ����Ʈ�� �� �ڿ� ���������� �߰��Ѵ�.
		list.add("ȫ�浿");
		list.add("����ġ");
		list.add("�Ӳ���");
		list.add("�����");
		
		System.out.println(list);
		
		// add(index, item) : ���ϴ� ��ġ�� �����͸� �ִ´� , �߰��� ������ ���� ������ ��ĭ�� �и�
		list.add(2, "�̼���");
	
		System.out.println(list);
	
		// ArrayList�� get(index) : �迭ó�� �ε����� �����͸� ���� �� �ִ�.
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		// ArrayList�� Ÿ���� ���������� ������ 
		// ��� Ÿ���� �����ִ� ArrayList�� �ȴ�.
		list.add(0, 1234);
		list.add(0, new Apple());
		
		System.out.println(list);
		// ��� Ÿ���� ����ֱ� ������ ���� �� � Ÿ������ ������ �˱� ���������.
		String name = (String)list.get(5);
		// Object Ÿ�� : ��� Ÿ���� �θ�
		Object thing = list.get(0);
		
		System.out.println(name);
		System.out.println(thing);
		
		// # Ÿ���� ������ ArrayList �����ϱ� 
		//	<>�� Ÿ���� �������ָ� ArrayList�� ��� �޼����� Ÿ���� �ٲ��.
		//	<>�� Generic�̶�� �θ���.
		ArrayList<String> fn_list =  new ArrayList<>();
		
		fn_list.add("apple");
		fn_list.add("orange");
		fn_list.add("kiwi");
		
		System.out.println(fn_list);
		System.out.println(fn_list.get(0));
		
		// size(); : ����Ʈ�� ũ�⸦ ��ȯ;
		System.out.println(list.size());
		System.out.println(fn_list.size());
		
		// remove(index) : ���ϴ� ��ġ ������(��� = element) ���� (�����ϸ鼭 ��ȯ)
		// remove(item) : ���ϴ� ���� �ϳ��� ����
		System.out.println("������ ������ ��ȯ : " + list.remove(0));
		System.out.println(list);
		
		fn_list.add(0, "apple");
		fn_list.add("apple");
		fn_list.add("apple");
		fn_list.add("apple");
		fn_list.add("apple");
		
		System.out.println(fn_list);
		
		System.out.println("������ ������ ��ȯ �� : " + fn_list.remove("apple"));
		
		System.out.println(fn_list);
		int count = 0;
		while(fn_list.remove("apple")) {
			System.out.println("����� ���� �Ǿ����ϴ�. " + ++count);
		}
		System.out.println("������ ��� �������ϴ�. " + fn_list);
		
		
		// # ArrayList�� �ݺ����� �Բ� ����ϸ� ���� ���ϴ�
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
		
		// # �÷����� Collections�� ��ɵ��� ����� �� �ִ�. �������� Ȱ�� �� 
		
		// �ѹ��� ������ �߰��ϱ�
		Collections.addAll(fn_list, "apple", "apple", "apple", "apple");
		
		System.out.println(fn_list);
		
		// ���� Ƚ��
		System.out.println("apple�� ���� Ƚ�� : " + 
						Collections.frequency(fn_list, "apple"));
		// �ִ� �ּ�
		System.out.println(Collections.min(fn_list));
		System.out.println(Collections.max(fn_list));
		
		// ������� ����
		Collections.sort(fn_list);
		System.out.println(fn_list);
		
		// �������� ����
		Collections.reverse(fn_list);
		System.out.println(fn_list);
		
		// �� ����� ��ġ ��ü
		Collections.swap(fn_list, 0, fn_list.size()-1);
		System.out.println(fn_list);
		
		// �ڼ���
		Collections.shuffle(fn_list);
		System.out.println("shuffle : " + fn_list);
		
		// nĭ�� ����� ��ȯ
		Collections.rotate(fn_list, -1);
		System.out.println("rotate : " + fn_list);
		
		// ��ҷ� ���� ä��� (�ַ� �ʱ�ȭ�� ���)
		Collections.fill(fn_list, "banana");
		System.out.println(fn_list);
		
		
	}
}
