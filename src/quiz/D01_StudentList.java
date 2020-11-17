package quiz;

import java.util.ArrayList;
import java.util.Collections;

import myobj.Student;

public class D01_StudentList {

	// 학생 클래스를 요소로 받는 ArrayList group를 생성
	// 학생을 30명 추가해보세요
	
	// 1. 30명의 점수가 자동으로 설정
	// 2. 모든 학생의 총 점수와 평균 점수를 구해보세요
	// 3. 반 평균을 구해보세요
	// 4. 이름 생성 규칙
	// 		테스트학생0000 0001 ...
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
		System.out.printf("\t반의 총 점수 : %d\t총 평균 : %.2f\n", result, avg);
		
	}


	public static void main(String[] args) {
		
		ArrayList<Student> group01 = groupGradeInfo();

		// println 함수는 해당 객체의 toString() 메서드를 호출한다.
		System.out.println(group01);
		
		showScore(group01);
		
	}
}
