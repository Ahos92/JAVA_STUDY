package myobj;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
	
	// 외부 클래스에서 필드의 직접 접근을 허용하지 않는 것이 좀 더 객체 지향적이다.
	//	외부 클래스는 내가 주는것만 사용할 수 잇게 끔 설계 하는것이 이상적이다.
	private int kor, eng, math;
	private String name;
	
	final static double NUM_OF_SUBJECT = 3.0;
	static int stu_count = 0;
	
	public Student() {
		
		this.kor = (int)(Math.random() * 50 + 50);
		this.eng = (int)(Math.random() * 50 + 50);
		this.math = (int)(Math.random() * 50 + 50);
		this.name = String.format("테스트학생%04d", stu_count++);
	}

	public double getAvg() {
		return  kor + eng + math / NUM_OF_SUBJECT;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}
	// toString()은 Object클래스의 메서드이기 떄문에 모든 객체가 가지고있다.
	@Override
	public String toString() {
		// Stirng.format() - printf처럼 서식을 이용하여 문자열을 생성하는 메서드
		return String.format("%s / 국어 : %d / 영어 : %d / 수학 : %d / 총 점수 : %d / 평균 : %.2f\n"
								, name, kor, eng, math, getTotal(), getAvg());
	}

	///////////////////////////////////////////////////
	@Override				// 매개변수 - 비교객체 
	public int compareTo(Student next_studnet) {
		// 크기 비교를 이 값을 가지고 하겠다.
		//	- 양수 리턴 : 현재 객체가 다음 비교 객체보다 더 큼 
		//	- 음수 리턴 : 현재 객체가 다음 비교 객체보다 더 작음 (
		//	- 0을 리턴 :  현재 객체와 다음 비교 객체의 크기가 같음
		
		if (this.eng > next_studnet.eng) {
			// 수학 점수가 더 작은 학생이 정렬시 앞으로 나오게
			return -1; // 음수 (조건이 맞을 시 다음 비교로 넘어간다)
		}else if(this.eng < next_studnet.eng) {
			// 수학 점수가 더 큰 학생이 정렬시 뒤에 나오게
			return 1; // 양수 (조건이 맞을 시 비교한 두수를 바꾸겠다)
		}
		
		// 수학 점수가 같을 때는 그냥 내버려두겠다.
		return 0;
	}
	
	
}
