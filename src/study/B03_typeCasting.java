package study;

public class B03_typeCasting {

	public static void main(String[] args) {
		
		// Ÿ�� ĳ���� - ������ ������� �Ȼ�����İ� �߿�
		//	- �ڿ������� ���ϴ� ��� (������ ���� ������ ���� ��)
		//	- ������ ��ȯ�ϴ� ��� (������ ��) 

		// Ÿ�� ũ��
		// byte (1) < char, short (2) < int (4) < long (8)
		// 					   		      float < double
		
		byte _byte = 10;
		int _int = 2_000_000_000; // ���� ���ͷ��� _�� ���� �ڸ��� ǥ������
	
		// 1.�ڿ�
		_int = _byte;
		System.out.println(_int);
		
		// 2. ���� - ���� �սǵ� �� �ִ� ��� ���
		// ������ �Ұ�� - (��ȭ��Ÿ��) ����;
		_int = 2_000_000_000; 
		_byte = (byte) _int;
		System.out.println(_byte); // ��� ������ ������ ���
		
		// 3. ���� Ÿ���� ������ �Ǽ�Ÿ�Կ� ���� ����
		long _long = 200000000000L;
		float _float = _long;
		System.out.println(_float);
		
		_float = 123.1234f;
		_long = (long)_float; // �Ҽ��� �Ʒ� ������ �ս�
		System.out.println(_long);
		
		// 4. ���� ���̴��� �ٸ��� �ؼ��� �� �ִ� Ÿ���� ��쿡
		//		Ÿ��ĳ���� �ʿ�
		int a = 70;
		System.out.println("a : "+a);
		System.out.println("(char)a : "+ (char)a);
		System.out.println("(char)70 : "+ (char)70);
		System.out.println("(int)'F' : "+ (int)'F');
		// ���� 70�̴��� Ÿ�Կ� ���� �ؼ������ �޶�����.
		// char : ����ǥ�� ���� �ؼ�
		// int : ���� �״�� �ؼ�
		
		// char Ÿ���� �����ڵ带 �����ϱ� ���ϵ��� 2byte ����� �����ϵ��� ����
		
		// char Ÿ���� ������ �������� ������ �־ ���� Ÿ���� ���� ������ �����ϴ�
		System.out.println("K ���� A������ ĭ�� : "+('K' - 'A'));
		System.out.println((char)('A'+10));
		System.out.println("���ĺ��� �� ���� : "+('Z'-'A'+1)+"��");

	}

}
