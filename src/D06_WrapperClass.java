
public class D06_WrapperClass {

	// WrapperClass
	//	- 기본형 타입들을 참조형 타입으로 사용하고 싶을 때 사용한다.
	//	- 각 타입들에 대한 유용한 기능들이 모여있다.
	//	- 
	
	// 기본형 : byte, char, int, long ....
	// 참조형 : Byte. Character, Integer, Long ....
	
	public static void main(String[] args) {
		// Integer b = new Integer(10); // JDK9 이후로 생성자deprecated(추천안함)
		
		// typeValue() 시리즈 : 참조형에 저장된 값을 원하는 기본 타입으로 변환한다.
		Integer a = 10;
		System.out.println(a.byteValue());
		System.out.println(a.doubleValue());
		System.out.println(a.floatValue());
		System.out.println(a.shortValue());
		System.out.println();
		
		// parseType 시리즈 : 문자열에 저장된 값을 원하는 타입으로 변환한다.
		String str = "10";
		System.out.println(Integer.parseInt(str));
		System.out.println(Integer.parseInt(str, 16));
		System.out.println(Double.parseDouble(str));		
		System.out.println(Byte.parseByte(str));
		System.out.println();
		
		//비교
		System.out.println(new Integer(10) == new Integer(10));
		System.out.println(new Integer(10).equals(new Integer(10)));
		System.out.println();
		
		// Wrapper클래스의 toString() 통해 진법변환이 가능 (radix default 10진수)
		System.out.println(Integer.toString(123, 16).toUpperCase());
		System.out.println(Integer.toString(123, 2));
		System.out.println(Integer.toString(123, 8));
		System.out.println(Double.toHexString(123.123));
		System.out.println();
		
		// boolean 문자열을 Boolean으로 변환
		Boolean b1 = Boolean.valueOf("true");
		System.out.println(b1);
		System.out.println();
		
		// char
		System.out.println(Character.toString('c'));
		// 해당 진법의 숫자를 char타입으로 반환해준다.
		// ex> 36진법의 35에 해당하는 문자
		System.out.println(Character.forDigit(35, 36));
		
		
	}
	
}
