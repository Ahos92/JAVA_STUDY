package study;

public class B06_switch {

	public static void main(String[] args) {
		
		// switch-case-default
		// ()���� ���� ��������� ������ �ڵ����
		
		int a = 9;
		
		switch (a % 2) {
		case 0:
			System.out.println("¦���Դϴ�.");
			break;
			
		case 1:
			System.out.println("Ȧ���Դϴ�.");
			break;
		}
		
		
		String word ="apple";
		
		switch(word.charAt(0)) {
		case'A': case'a': //break �ǵ������� ���� ���ʴ�Ȱ���ϴ°�� , break�ƿ� ���� �ɼ�Ȱ�밡��
			System.out.println("a�� �����ϴ� �ܾ��Դϴ�.");
			break;
			
		case'b':
			System.out.println("b�� �����ϴ� �ܾ��Դϴ�.");
			break;
			
		case'c':
			System.out.println("c�� �����ϴ� �ܾ��Դϴ�.");
			break;
			
		default :
			System.out.println("���� case�� ��ξƴմϴ�.");
			break;
		}
	}
	
}
