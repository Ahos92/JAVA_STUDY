package study;

public class B04_if {

	public static void main(String[] args) {

		// if
		// 	- ()안의 값이 true일때 {}실행, false면 무시
		//	- {} 내용이 한줄이면 생략 가능
		if (true) System.out.println("hi");

		// else if
		char lastname='김';
		String result;//변수 선언은 함수 바깥에

		if(lastname == '김') {
			result="김씨입니다.";
		} else if(lastname == '박') { 
			result = "박씨입니다.";
		} else if(lastname=='이') {
			result = "이씨입니다.";
		} else { // else
				 //  - else문이 있으면 else는 무조건 실행
			result = "해당하는 성이 없습니다.";
		}
		System.out.println(result);
		
		
		int num = 9999;
		
		if(num > 10000) 
			System.out.println("num이 10000보다 큽니다.");
		else if(num > 1000)
			System.out.println("num이 1000보다 큽니다.");
	
		
	}

}
