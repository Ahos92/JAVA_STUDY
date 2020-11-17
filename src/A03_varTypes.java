
public class A03_varTypes {

	public static void main(String[] args) {

		//����
		byte _byte = 10;
		char _char = '#'; // ''���� Ÿ�Ե� ������� , char�� ���� ǥ�� ����
		short _short = 10;
		int _int = 10;
		long _long = 90000000000L;
		//int �� ������ ����� ���ڸ� �������� �ڿ� L�� �ٿ�����

		//�Ǽ� 
		// float 4byte , double 8byte
		float _float=123.123f; // f 
		double _double=123.123;

		/* ���ͷ� (literal)
		 *  - �׳� ���� ��
		 *  - "", '', �Ҽ�, �Ҽ�f, ����, ����L ...
		 *  - 0����(8), 0x����(16), 0b����(2)
		 *  -  true, false
		 */
		System.out.println("111(10) : "+111);
		System.out.println("111(8) : "+0111);
		System.out.println("111(16) : "+0x111);
		System.out.println("111(2) : "+0b111);

		// boolean
		boolean _boolean = true;
		boolean _boolean2 = false;
		
		// ����
		// String, �׿� ��� Ŭ������, �빮�ڷ� �����ϴ� Ÿ�Ե��� ������
		String hiMsg="Hello, nice to meet you";
		String byeMsg="Good bye";
		
		System.out.println(hiMsg);
		System.out.println(byeMsg+byeMsg);
	}

}
