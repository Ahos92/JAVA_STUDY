package study;

public class B04_if {

	public static void main(String[] args) {

		// if
		// 	- ()���� ���� true�϶� {}����, false�� ����
		//	- {} ������ �����̸� ���� ����
		if (true) System.out.println("hi");

		// else if
		char lastname='��';
		String result;//���� ������ �Լ� �ٱ���

		if(lastname == '��') {
			result="�达�Դϴ�.";
		} else if(lastname == '��') { 
			result = "�ھ��Դϴ�.";
		} else if(lastname=='��') {
			result = "�̾��Դϴ�.";
		} else { // else
				 //  - else���� ������ else�� ������ ����
			result = "�ش��ϴ� ���� �����ϴ�.";
		}
		System.out.println(result);
		
		
		int num = 9999;
		
		if(num > 10000) 
			System.out.println("num�� 10000���� Ů�ϴ�.");
		else if(num > 1000)
			System.out.println("num�� 1000���� Ů�ϴ�.");
	
		
	}

}
