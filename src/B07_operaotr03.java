
public class B07_operaotr03 {

	public static void main(String[] args) {
		// # 3�׿�����(���ǿ�����)
		//	- if���� ���ٷ� ǥ���� �� �ִ�.
		// ���� ? true : false;
		
		// ex) �ʿ��� ��� ���� ���� ��� 
		int apple = 32;
		int size = 10;
		
		int needs = apple % 10 == 0 ? apple/size : apple/size+1;
		System.out.printf("�ʿ��� ������ ��� %d�� �Դϴ�.", needs);
		
		
		// ex2) Ȧ¦ ����
		String msg = apple%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�.";
		System.out.printf("\n���� ����� ������ %s", msg);
	}
	
}
