package myobj;

import java.util.ArrayList;

public class Student implements Comparable<Student> {
	
	// �ܺ� Ŭ�������� �ʵ��� ���� ������ ������� �ʴ� ���� �� �� ��ü �������̴�.
	//	�ܺ� Ŭ������ ���� �ִ°͸� ����� �� �հ� �� ���� �ϴ°��� �̻����̴�.
	private int kor, eng, math;
	private String name;
	
	final static double NUM_OF_SUBJECT = 3.0;
	static int stu_count = 0;
	
	public Student() {
		
		this.kor = (int)(Math.random() * 50 + 50);
		this.eng = (int)(Math.random() * 50 + 50);
		this.math = (int)(Math.random() * 50 + 50);
		this.name = String.format("�׽�Ʈ�л�%04d", stu_count++);
	}

	public double getAvg() {
		return  kor + eng + math / NUM_OF_SUBJECT;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}
	// toString()�� ObjectŬ������ �޼����̱� ������ ��� ��ü�� �������ִ�.
	@Override
	public String toString() {
		// Stirng.format() - printfó�� ������ �̿��Ͽ� ���ڿ��� �����ϴ� �޼���
		return String.format("%s / ���� : %d / ���� : %d / ���� : %d / �� ���� : %d / ��� : %.2f\n"
								, name, kor, eng, math, getTotal(), getAvg());
	}

	///////////////////////////////////////////////////
	@Override				// �Ű����� - �񱳰�ü 
	public int compareTo(Student next_studnet) {
		// ũ�� �񱳸� �� ���� ������ �ϰڴ�.
		//	- ��� ���� : ���� ��ü�� ���� �� ��ü���� �� ŭ 
		//	- ���� ���� : ���� ��ü�� ���� �� ��ü���� �� ���� (
		//	- 0�� ���� :  ���� ��ü�� ���� �� ��ü�� ũ�Ⱑ ����
		
		if (this.eng > next_studnet.eng) {
			// ���� ������ �� ���� �л��� ���Ľ� ������ ������
			return -1; // ���� (������ ���� �� ���� �񱳷� �Ѿ��)
		}else if(this.eng < next_studnet.eng) {
			// ���� ������ �� ū �л��� ���Ľ� �ڿ� ������
			return 1; // ��� (������ ���� �� ���� �μ��� �ٲٰڴ�)
		}
		
		// ���� ������ ���� ���� �׳� �������ΰڴ�.
		return 0;
	}
	
	
}
