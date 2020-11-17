
public class A03_varTypes {

	public static void main(String[] args) {

		//정수
		byte _byte = 10;
		char _char = '#'; // ''문자 타입도 정수취급 , char는 음수 표시 못함
		short _short = 10;
		int _int = 10;
		long _long = 90000000000L;
		//int 의 범위를 벗어나는 숫자를 적을때는 뒤에 L을 붙여야함

		//실수 
		// float 4byte , double 8byte
		float _float=123.123f; // f 
		double _double=123.123;

		/* 리터럴 (literal)
		 *  - 그냥 적는 값
		 *  - "", '', 소수, 소수f, 정수, 정수L ...
		 *  - 0숫자(8), 0x숫자(16), 0b숫자(2)
		 *  -  true, false
		 */
		System.out.println("111(10) : "+111);
		System.out.println("111(8) : "+0111);
		System.out.println("111(16) : "+0x111);
		System.out.println("111(2) : "+0b111);

		// boolean
		boolean _boolean = true;
		boolean _boolean2 = false;
		
		// 참조
		// String, 그외 모든 클래스들, 대문자로 시작하는 타입들은 참조형
		String hiMsg="Hello, nice to meet you";
		String byeMsg="Good bye";
		
		System.out.println(hiMsg);
		System.out.println(byeMsg+byeMsg);
	}

}
