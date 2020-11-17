package myobj.comp;

import java.util.Comparator;

import myobj.Student;
/*
 *  Compare Student class by average score
 */
public class StudentComparatorA implements Comparator<Student>{

	@Override
	public int compare(Student this_student, Student next_student) {
		if (this_student.getAvg() > next_student.getAvg()) {
			return 1;
		} else if (this_student.getAvg() < next_student.getAvg()) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
