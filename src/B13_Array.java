import java.util.Arrays;

public class B13_Array {

	// 배열
	// 	- 같은 타입의 변수를 한번에 여러개 선언하는 방법
	// 	- 인덱스를 활용해 해당 번째의 값에 접근할 수 있다.
	// 		(반복문과 함께 활용하기 편하다)
	// 	- 한번 크기가 정해지면 크기를 변경할 수 없다.
	//	- 초기화가 자동으로 되어있다.
	//	  (정수 : 0, 실수 : 0.0, boolean : false, 참조형 : null)
	
	public static void main(String[] args) {
		
		// 변수 100개를 쉽게만드는 방법
		String[] fruits = new String[5];
		System.out.println(fruits[0]);
		
		int[] a = new int[100];
		
		a[0] = 10;
		a[1] = 55;
		a[2] = 60;
		a[99] = 1200; // 100의 배열은 [99]까지
		
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[50]);
		System.out.println(a[99]);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		// 배열 선언 방법
		
		// 1. 타입[] 배열이름 = new 타입[배열크기];
		// 2. 타입[] 배열이름 = {값1, 값2, 값3 ...};
		String[] colors = {"red", "blue", "green", "gray", "yellow"};
		
		System.out.println(colors[0]);
		System.out.println(colors[1]);
		System.out.println(colors[2]);
		System.out.println(colors[3]);
		System.out.println(colors[4]);
		
		double[] scores = {9.9, 8.8, 7.7, 6.6, 5.5, 4.4, 
							3, 2, 1, 
							'B', 'A', 
							123.123f,
							3000000000L}; // double되는애들 다됨
			
		// 3. 탑[] 배열이름 = new 타입[] {값1, 값2, 값3 ...};
		//   		배열을 요구하는 함수가있어서 'new 타입[]'가 쓰임
		boolean[] testResult = new boolean[] {true, false, true, false, 
											1 > 0 , 1 < 0, 1 == 0, 1 != 0};	
		// 배열요구 함수 예제 
		String result = Arrays.toString(new int[] {1, 2, 3});
		System.out.println(result);
		
		// java.util.Arrays.toString 
		// 베열을 스트링으로 반환!
		System.out.println(Arrays.toString(colors));
		System.out.println(Arrays.toString(scores));
		String strbool = Arrays.toString(testResult);
		System.out.println(strbool);
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// 배열과 반복문 활용하기
		System.out.println("colors 배열의 길이 : " + colors.length);
		
		for(int index = 0; index < colors.length; ++index) {
			System.out.printf("%d번째 색깔 : %s\n",	index, colors[index]);
		}
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		// String형을 char형 배열로 변환하기
		String msg = "Hello, World!";
		
		char[] msgArr = msg.toCharArray();
		
		System.out.println(msgArr[0]);
		System.out.println(msg.charAt(1));
		
		for(int i= 0 ; i < msgArr.length; i++) {
			System.out.print(msgArr[i]);
		}
		
		
		
	}
	
}
