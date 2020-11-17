package quiz;

import java.util.Arrays;

public class C01_functionQuiz2 {

	// 1. 최소값. 최대값 매개변수로 받으면, 그 사이의 모든 값을 포함하는 int 배열을 반환하는 range 함수를 만들어 보세요
	//			( 최소 이상 최대 미만)
	public static int[] range(int min, int max) {
		int[] range = new int[max-min];
		if(min > max) {
			return null;
		}
		for(int i = 0; i < range.length; ++i) {
			range[i] = min + i;
		}
		return range;
	}

	//2. 최대값을 매개변수로 전달 받으면, 0부터 최대값 미만의 모든 값을 포함하는 range2 함수
	//				Overloading 같은이름써도됨 변수값이 다르면
	public static int[] range(int max) {
		int[] range2 = new int[max];
		for(int i = 0; i < max; ++i) {
			range2[i] = i;
		}
		return range2;
	}

	//3. 문자열 배열 전달 받으면, 해당 배열을 모두 "/"를 이어붙이는 함수를 만들어 보세요
	//		{"apple" , "banana", oragne}; return> "apple/banana/orage"
	public static String join(String[] word) {
		StringBuilder msg = new StringBuilder();
		msg.append("\"");
		for(int i = 0; i < word.length; ++i) {
			if(i == word.length-1) {
				msg.append(word[i]);	
			}else {	
				msg.append(word[i]+"/");
			}
		}
		msg.append("\"");

		return msg.toString();
	}

	//4. 문자열 타입의 숫자(num), 원래 진법(base_from) , 바꾸려는 진법(base_to)를 전달 받으면
	//	base_from인 해당 숫자를 base_to 진법의 문자열로 변환하여 반환하는 함수
	//	만약, 진법이 잘못된 경우 null을 반환합니다.
	// 	변환 할수 있는 최대 진법은 36진법, 최소 진법은 2진법

	public static char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static int getValue(char digit) {
		// index값을 직접 값으로 이용하기위한 char형배열
		for(int i = 0; i < digits.length; ++i) {
			if(digits[i] == digit) {
				return i;		
			}
		}
		return -1;
	}

	public static char getSymbol(int value) {
		return digits[value];
	}
	public static String convert_base(String num, int base_from, int base_to) {

		if(base_from < 2 || base_from > 36 || base_to < 2 || base_to > 36) {
			System.err.println("RadixError : 사용 가능한 진법은 2부터 36입니다.");
			// 에러프린트
			return null;
		}

		int pow = num.length() - 1;
		long real_value = 0;

		// 들어온 값 10진법 만들기
		//  (base_from, length-0) * charAt(0) 
		// +(base_from, length-1) * charAt(1)
		// +(base_from, length-2) * charAt(2)		
		for(int i = pow; i > -1; --i) {
			char digit = num.charAt(pow - i);
			int value = getValue(digit);// ACDEFG ... XYZ 값을 실제값으로 받기위한 함수

			if(value >= base_from) {
				System.err.println("base_from 이상의 문자가 있습니다.");
				return null;
			}
			
			System.out.println(digit);
			System.out.println("\t실제 값 :" + value);
			System.out.println("\t" + Math.pow(base_from, i) + "의 자리");

			real_value += value * Math.pow(base_from, i);
		}
		System.out.printf("%d진법 문자열 \"%s\"의 값은 실제로 %d입니다.\n", base_from, num, real_value);

		// 그다음 변환할 진법으로 만들기
		//		while(ch / base_to != 0) {
		//			ch = ch / base_to;
		//			result += ch % base_to * (int)Math.pow(10, i);
		//			i++;
		//		}
		StringBuilder result = new StringBuilder();
		while(real_value > 0) {			
			
			result.append(getSymbol((int)(real_value % base_to)));
			real_value /= base_to;
		}
			
		return result.reverse().toString(); // reverse()
	}


	public static void main(String[] args) {
		String[] fruits = {"apple", "banana", "orange"};

		// # 함수의 오버로딩 - ex) println();
		// 	- 같은 함수이름으로 정의 가능
		// 	- 다른 형태의 함수로 인정받기 위해서는
		// 	   매개변수의 개수 혹은 타입이 달라야 한다.
		System.out.println(Arrays.toString(range(0, 5)));
		System.out.println(Arrays.toString(range(5)));

		System.out.println(join(fruits));

		System.out.println(convert_base("1234ZD", 36, 10));
	}
}
