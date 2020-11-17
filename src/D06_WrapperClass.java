
public class D06_WrapperClass {

	// WrapperClass
	//	- �⺻�� Ÿ�Ե��� ������ Ÿ������ ����ϰ� ���� �� ����Ѵ�.
	//	- �� Ÿ�Ե鿡 ���� ������ ��ɵ��� ���ִ�.
	//	- 
	
	// �⺻�� : byte, char, int, long ....
	// ������ : Byte. Character, Integer, Long ....
	
	public static void main(String[] args) {
		// Integer b = new Integer(10); // JDK9 ���ķ� ������deprecated(��õ����)
		
		// typeValue() �ø��� : �������� ����� ���� ���ϴ� �⺻ Ÿ������ ��ȯ�Ѵ�.
		Integer a = 10;
		System.out.println(a.byteValue());
		System.out.println(a.doubleValue());
		System.out.println(a.floatValue());
		System.out.println(a.shortValue());
		System.out.println();
		
		// parseType �ø��� : ���ڿ��� ����� ���� ���ϴ� Ÿ������ ��ȯ�Ѵ�.
		String str = "10";
		System.out.println(Integer.parseInt(str));
		System.out.println(Integer.parseInt(str, 16));
		System.out.println(Double.parseDouble(str));		
		System.out.println(Byte.parseByte(str));
		System.out.println();
		
		//��
		System.out.println(new Integer(10) == new Integer(10));
		System.out.println(new Integer(10).equals(new Integer(10)));
		System.out.println();
		
		// WrapperŬ������ toString() ���� ������ȯ�� ���� (radix default 10����)
		System.out.println(Integer.toString(123, 16).toUpperCase());
		System.out.println(Integer.toString(123, 2));
		System.out.println(Integer.toString(123, 8));
		System.out.println(Double.toHexString(123.123));
		System.out.println();
		
		// boolean ���ڿ��� Boolean���� ��ȯ
		Boolean b1 = Boolean.valueOf("true");
		System.out.println(b1);
		System.out.println();
		
		// char
		System.out.println(Character.toString('c'));
		// �ش� ������ ���ڸ� charŸ������ ��ȯ���ش�.
		// ex> 36������ 35�� �ش��ϴ� ����
		System.out.println(Character.forDigit(35, 36));
		
		
	}
	
}
