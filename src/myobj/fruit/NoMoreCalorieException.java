package myobj.fruit;

// ����� ū �ǹ�
// Exception Ŭ������ ��ӹ����� ���ܰ� �ȴ�.
//		- �ݵ�� ó���ؾ� �ϴ� ���ܰ� �ȴ�.

public class NoMoreCalorieException extends Exception {

	public NoMoreCalorieException() {
		super("�� �̻� ���� �� ���� ���");
	}
	
}
