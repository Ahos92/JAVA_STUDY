package quiz;

import java.util.Scanner;

public class B04_scoreToGrade {

	//���� �Է� �޾Ƽ� �ش��ϴ� ��� ���

	// 90 �̻� A
	// 80 �̻� B
	// 70 �̻� C
	// 60 �̻� D
	// �׿� F
	// ���� 0~100

	public static void main(String[] args) {

		System.out.println(" #### ���Ȯ�� ���α׷� #### ");
		
		Scanner sc = new Scanner(System.in);

		System.out.print("������ �Է� ���ּ��� > ");
		int score = sc.nextInt();
		char grade;

		if(score < 0 || score >100) {
			System.out.println("������ �߸� �Է� �Ͽ����ϴ�.");
		} else {
			if(score >= 90) {
				grade = 'A';
			} else if(score >= 80) {
				grade = 'B';
			}  else if(score >= 70) {
				grade = 'C';
			}  else if(score >= 60) {
				grade = 'D';
			}  else{
				grade = 'F';
			}
			System.out.printf("%c ���\n", grade);
		}

		System.out.println("���α׷��� �����մϴ�.");

		sc.close();
	}

}
