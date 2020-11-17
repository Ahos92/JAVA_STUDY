package study;
import java.util.*;

import myobj.Student;
import myobj.comp.StudentComparatorA;

public class D04_Comparator {

	public static void main(String[] args) {
		List<String> words = new LinkedList<>();
		// String 클래스에는 이미 크기 비교 기준이 만들어져있다.
		words.add("ariplane");
		words.add("jet");
		words.add("coffee");
		words.add("glasses");
		words.add("oriental");

		Collections.sort(words);
		System.out.println(words);
		System.out.println();

		List<Student> group = new LinkedList<>();
		// 사용자가 만든 클래스에는 크기비교 기준이 되는 Comparable<T>(default Object) 인터페이스를 구현해야한다
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
		
		// 크기 비교가 구현된 클래스의 경우 sort , min , max 다이용가능
	
	}
}
 