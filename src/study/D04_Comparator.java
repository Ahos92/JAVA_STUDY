package study;
import java.util.*;

import myobj.Student;
import myobj.comp.StudentComparatorA;

public class D04_Comparator {

	public static void main(String[] args) {
		List<String> words = new LinkedList<>();
		// String Ŭ�������� �̹� ũ�� �� ������ ��������ִ�.
		words.add("ariplane");
		words.add("jet");
		words.add("coffee");
		words.add("glasses");
		words.add("oriental");

		Collections.sort(words);
		System.out.println(words);
		System.out.println();

		List<Student> group = new LinkedList<>();
		// ����ڰ� ���� Ŭ�������� ũ��� ������ �Ǵ� Comparable<T>(default Object) �������̽��� �����ؾ��Ѵ�
		group.add(new Student());
		group.add(new Student());
		group.add(new Student());
		group.add(new Student());

//		Collections.sort(group, new StudentComparatorA());
		Collections.sort(group, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (int)Math.ceil(o1.getAvg() - o2.getAvg());
			}
		});
		System.out.println(group);
		
		// ũ�� �񱳰� ������ Ŭ������ ��� sort , min , max ���̿밡��
	
	}
}
 