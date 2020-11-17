package study;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import myobj.fruit.Mango;

public class D05_TreeSet {

	// # TreeSet
	//	- �ߺ����� ������ �� ����. 
	//	- �����͸� ������ �� ������������ �����Ѵ�.
	//	- ��ҷ� null�� ������� �ʴ´�.
	//	- ���� �ӵ��� ���� ��� ������ ���� / �˻� �ӵ��� ������.

	
	//	��
	// �� �ߺ����� + ���ϴ� �κ� ���� ���� + ũ�� ����
	public static void main(String[] args) {
		
		TreeSet<Mango> mango_tree = new TreeSet<>(new Comparator<Mango>() {
			
			@Override
			public int compare(Mango o1, Mango o2) {
				// Set�� ���� �����͸� ������� �ʱ� ������
				// ���� �絵�� ���� ���� ��λ����
				// o1.sweet - o2.sweet
				
				// ���� �絵�� ���������� ����id(�� ��ü ������ ��) �������� �ٽ� �����ϱ�
				//	 	������ hashCode()�� ��� (Primary Key����)
				// myobj.fruit.Mango
				int sweet_value = o1.sweet - o2.sweet;
				return sweet_value == 0 ? o1.hashCode() - o2.hashCode() : sweet_value;
			}
			
		});
		
		for (int i = 0; i < 100; ++i) {
			mango_tree.add(new Mango());
		}
//		System.out.println(mango_tree.size());
		
		// Comparable���� return 0; �� ���� ��ü���� �ǹ��Ѵ�. �׷��� �����
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// # TreeSet Ȱ��
		
		// descendingSet() : ������������ ���ĵ� Set�� ��ȯ
		System.out.println(mango_tree.descendingSet());
		
		// TreeSet�� ���ϴ� �������� ������ ����ϱ�
		System.out.println("\n headSet");
		// HeadSet (toElement) : �� �պ��� ���ϴ� ���� ������ Set�� ��ȯ
		Set<Mango> hSet = mango_tree.headSet(new Mango(0, 12, 50));
		System.out.println(hSet.size());
		
		System.out.println("\n tailSet");
		// TaleSet (fromElemnet) : ���ϴ� ���غ��� �� ������ ���� Set�� ��ȯ
		SortedSet<Mango> tSet = mango_tree.tailSet(new Mango(0, 12, 50));
		System.out.println(tSet.size());
		
		System.out.println("\n h_tSet");
		SortedSet<Mango> h_tSet = tSet.headSet(new Mango(0, 15, 100));
		System.out.println(h_tSet.size());
		
		System.out.println("\n t_tSet");
		SortedSet<Mango> t_tSet = tSet.tailSet(new Mango(0, 15, 100));
		System.out.println(t_tSet.size());
		
		System.out.println("\n subSet(13, 15) from <=  �� <= to");
		// subSet(from, to) from <=  <= to
		SortedSet<Mango> result = mango_tree.subSet(new Mango(0, 12, 100), new Mango(0, 15, 100));
		System.out.println(result);
		
////////////////////////////////////////////
		System.out.println();
		// # TreeSet��Ҹ� �ϳ��� �����ϱ�
		
		TreeSet<Integer> int_tree = new TreeSet<>();
		
		int_tree.add(99);
		int_tree.add(1);
		int_tree.add(75);
		int_tree.add(3);
		int_tree.add(40);
		int_tree.add(11);

		// floor , ceiling: �ش� �� �������� ���� ����� '���� ��' / 'ū ��' �� ��ȯ 
		// 					���� ���̸� �ش� �� ��ȯ (�̻� / ����)
		
		// lower , higher : �ش� �� �������� ���� ����� '���� ��' / 'ū ��' �� ��ȯ 
		// 					���� ���̸� ���� (�ʰ� / �̸�)
		
		System.out.println(int_tree.floor(11));
		System.out.println(int_tree.ceiling(11));
		
		System.out.println(int_tree.lower(11));
		System.out.println(int_tree.higher(11));
		
		
		
	}
	
}
