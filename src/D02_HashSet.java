
import java.util.*;

public class D02_HashSet {

	// # Set
	//	- '����'�� �����س��� Ŭ����
	//	-  ��ҷ� ���� ���� ������ ���� �ߺ��� ������� �ʴ´�
	
	// # Hash
	//	- � ���� �־��� �� ���� ������ �� ���� ���� �����Ǿ�� �ϴ� �˰���
	//	- ������ �� ���� ���� �̿��ϹǷ� ������ �Ұ����ϴ�
	//	- ������ ������ ���� ���� ã�� ���� �Ұ��ɿ� ������  
	//	- �ٽ� ���� ������ ���ư� �� ���� �ܹ��⼺ �˰���
	//	- �ӵ��� ������ ���ȼ��� �پ �˰���
	
	// a	->	5341341243
	// b 	->	5123341512
	// c	->	3435232123
	
	public static void main(String[] args) {

		HashSet<Integer> even = new HashSet<>();
		
		// �Ȱ��� �����͸� ���� �Ҽ� ���� (Set Ư¡)
		even.add(2);
		even.add(2);
		even.add(2);
		even.add(4);
		even.add(6);
		even.add(16);
		// ���� ������� �������� �ʴ´� index�� ������ ���� (Hash Ư¡)
		System.out.println(even);
		
		// HashSet�� index�� ���� ������ �ϳ��� �������� ����.
		for(int i : even) {
			System.out.println("�ϳ��� ���� : " + i);
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
		//��ĳ���� Ȱ�� / Set�� HashSet �ֱ�  / Collection�� ArrayList�ֱ�
		// �ߺ����� ȿ��
		Set<String> animal_set = new HashSet<>(animal_list);
		System.out.println(animal_set);
		
		////////////////////////////////////////////////////////////////////////////
		// �÷����� �迭�� ��ȯ�ϱ� 1
		Object[] animal_arr = animal_list.toArray();
		//String���� ���� �� �ٿ�ĳ���� �ʿ�
		String first_animal = (String)animal_arr[0];
		System.out.println(first_animal);
		
		// �÷����� �迭�� ��ȯ�ϱ� 2
		//	- �̸� ������ ���׸� �迭�� �����ϴ� ���
		String[] animal_arr2 = new String[animal_set.size()];
		animal_set.toArray(animal_arr2);
		
		first_animal = animal_arr2[0];
		System.out.println(first_animal);
		
		///////////////////////////////////////////////////////////////////////////
		// contains : �÷��ǿ� �ش��Ұ� �ִ��� ���θ� ��ȯ
		System.out.println(animal_list.contains("lion"));
		System.out.println(animal_set.contains("lion"));
		
		// size
		System.out.println(animal_set.size());
		
		// remove - ������ true ��ȯ 
		System.out.println(animal_set.remove("lion"));
		
		
		// # �ٸ� �÷����� �̿��ϴ� �޼����
		Set<Character> alphabets01 = new HashSet<>();
		Set<Character> alphabets02 = new HashSet<>();
		
		Collections.addAll(alphabets01, 'A', 'B', 'C', 'D', 'E');
		Collections.addAll(alphabets02, 'D', 'E', 'F', 'G', 'H');
		
		System.out.println(alphabets01);
		System.out.println(alphabets02);
		
		// 1. addAll(Collection) : ������ �÷����� ��� ���� �߰��Ѵ�.
		List<Character> alpha_all = new ArrayList<>();
		
		alpha_all.addAll(alphabets01);
		alpha_all.addAll(alphabets02);
		
		System.out.println(alpha_all);
		
		// 2. removeAll(Collection) : ������ �÷��ǰ� ��ġ�ϴ� ��� ���� �����Ѵ�
		Set<Character> to_remove = new HashSet<>();
		Collections.addAll(to_remove, 'A', 'D');
		
		alpha_all.removeAll(to_remove);
		
		System.out.println(alpha_all);
		
		// 3. retainAll(Collection) : ������ �÷��ǰ� ��ġ�ϴ� ���� �����Ѵ�.
		List<Character> to_retain = new ArrayList<>();
		
		to_retain.add('E');
		to_retain.add('G');
		
		alpha_all.retainAll(to_retain);
		System.out.println(alpha_all);
		
		// 4. coniansAll(Collection) : ������ �÷����� ��� ��Ұ� ���ԵǾ��ִ��� Ȯ��
		Collections.addAll(alpha_all, 'A', 'B', 'C', 'D');
		
		Set<Character> must_contain = new HashSet<>();
		
		must_contain.add('A');
		must_contain.add('B');
		must_contain.add('C');
		must_contain.add('D');
//		must_contain.add('Z');
		
		System.out.println(alpha_all + "�� "
						+ must_contain + "�� ��� ���ԵǾ� �ֳ���? "
						+ alpha_all.containsAll(must_contain));
		
		
	}

}
