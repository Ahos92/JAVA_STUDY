package quiz;

import java.util.ArrayList;
import java.util.Collections;

import myobj.Student;

public class D01_StudentList {

	// �л� Ŭ������ ��ҷ� �޴� ArrayList group�� ����
	// �л��� 30�� �߰��غ�����
	
	// 1. 30���� ������ �ڵ����� ����
	// 2. ��� �л��� �� ������ ��� ������ ���غ�����
	// 3. �� ����� ���غ�����
	// 4. �̸� ���� ��Ģ
	// 		�׽�Ʈ�л�0000 0001 ...
	public static ArrayList<Student> groupGradeInfo() {
		ArrayList<Student> group = new ArrayList<>();
		
		for (int i = 0; i < 30; ++i) {
			group.add(new Student());			
		}
		return group;
	}
	
	public static void showScore(ArrayList<Student> group) {
		int result = 0;
		for(int i = 0; i < group.size(); ++i) {
			result += group.get(i).getTotal();
		}
		double avg = result / 90.0;
		System.out.println("------------------------------------------------");
		System.out.printf("\t���� �� ���� : %d\t�� ��� : %.2f\n", result, avg);
		
	}


	public static void main(String[] args) {
		
		ArrayList<Student> group01 = groupGradeInfo();

		// println �Լ��� �ش� ��ü�� toString() �޼��带 ȣ���Ѵ�.
		System.out.println(group01);
		
		showScore(group01);
		
	}
}
