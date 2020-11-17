package quiz;

import java.util.Scanner;

public class B04_scoreToGrade {

	//점수 입력 받아서 해당하는 등급 출력

	// 90 이상 A
	// 80 이상 B
	// 70 이상 C
	// 60 이상 D
	// 그외 F
	// 점수 0~100

	public static void main(String[] args) {

		System.out.println(" #### 등급확인 프로그램 #### ");
		
		Scanner sc = new Scanner(System.in);

		System.out.print("점수를 입력 해주세요 > ");
		int score = sc.nextInt();
		char grade;

		if(score < 0 || score >100) {
			System.out.println("점수를 잘못 입력 하였습니다.");
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
			System.out.printf("%c 등급\n", grade);
		}

		System.out.println("프로그램을 종료합니다.");

		sc.close();
	}

}
