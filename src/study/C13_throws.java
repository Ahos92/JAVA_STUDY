package study;

public class C13_throws {

	// # throws
	//	- ���� �޼��忡�� �߻��ϴ� ������ ó���� �޼��带 ȣ�� �� ������ �̷�� (���� ����)
	// 	- �޼��� �ڿ� �߻��� ������ �ִ� ���ܸ� �Բ� �����Ѵ�.
	//	- �ش� �޼��带 ȣ���ϴ� ���� ��� ���� �� �ִ�.
	
	// # throw
	//	- ���ϴ� ���ܸ� �߻���Ų��
	// 	- 

	//////////////////////////////////////////////////////
	// myobj.fruit.Apple / Exception Ŭ������
	// Exception�� ��� ���� ��ü�� �ݵ�� ó���ؾ� �Ѵ�
	
	// RuntimeException�� ��ӹ��� ��ü�� �ݵ�� ó������ �ʾƵ� �Ǵ� ���� ��ü
	// 			- throw�� ����������, �ݵ�� ó���϶�� �������� ���� ����
	
	public static void stupid_method1() 
			throws ArrayIndexOutOfBoundsException{
		
		throw new ArrayIndexOutOfBoundsException("�׳� �߻�");
	}
	
	public static void main(String[] args) {
		
		int a = 2;
		
		if(a == 1) {
			throw new ArithmeticException("�׳� �߻��� 1");
		} else if (a == 2) {
			throw new java.util.EmptyStackException();
		}
		
		stupid_method1();
		
	}
	
}
