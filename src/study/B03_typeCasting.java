package study;

public class B03_typeCasting {

	public static void main(String[] args) {
		
		// 타입 캐스팅 - 문제가 생기느냐 안생기느냐가 중요
		//	- 자연스럽게 변하는 경우 (문제가 생길 위험이 없을 때)
		//	- 강제로 변환하는 경우 (위험할 때) 

		// 타입 크기
		// byte (1) < char, short (2) < int (4) < long (8)
		// 					   		      float < double
		
		byte _byte = 10;
		int _int = 2_000_000_000; // 숫자 리터럴은 _를 통해 자릿수 표현가능
	
		// 1.자연
		_int = _byte;
		System.out.println(_int);
		
		// 2. 강제 - 값이 손실될 수 있는 경우 경고
		// 강제로 할경우 - (변화할타입) 변수;
		_int = 2_000_000_000; 
		_byte = (byte) _int;
		System.out.println(_byte); // 계속 돌고돌아 남은거 출력
		
		// 3. 정수 타입은 더작은 실수타입에 들어갈수 있음
		long _long = 200000000000L;
		float _float = _long;
		System.out.println(_float);
		
		_float = 123.1234f;
		_long = (long)_float; // 소수점 아래 데이터 손실
		System.out.println(_long);
		
		// 4. 같은 값이더라도 다르게 해석될 수 있는 타입의 경우에
		//		타입캐스팅 필요
		int a = 70;
		System.out.println("a : "+a);
		System.out.println("(char)a : "+ (char)a);
		System.out.println("(char)70 : "+ (char)70);
		System.out.println("(int)'F' : "+ (int)'F');
		// 같은 70이더라도 타입에 따라 해석방식이 달라진다.
		// char : 문자표에 따라 해석
		// int : 숫자 그대로 해석
		
		// char 타입은 문자코드를 저장하기 편하도록 2byte 양수만 저정하도록 설꼐
		
		// char 타입은 실제로 정수값을 가지고 있어서 문자 타입을 통한 연산이 가능하다
		System.out.println("K 에서 A까지의 칸수 : "+('K' - 'A'));
		System.out.println((char)('A'+10));
		System.out.println("알파벳의 총 갯수 : "+('Z'-'A'+1)+"개");

	}

}
