
public class A04_varNaming {

	public static void main(String[] args) {
		
		// ������ ����ؾ� �ϴ� ����
		// ���� �ѹ��� ���� (ȿ����)
		// ���� �ǹ� �ο� (������) �̸� ���°� �ſ��߿�
		
		int apple_count = 45;
		int apple_price = 485;
		int apple_gram = 50;
		int apple_calorie=112;
		
		System.out.println("����� �� ������ "
						+apple_count * apple_price+"�� �Դϴ�.");
		
		System.out.println("����� �� ���Դ� "
				+apple_count * apple_gram+"g �Դϴ�.");
		
		System.out.println("����� �� Į�θ��� "
				+apple_count * apple_calorie+"kcal �Դϴ�.");
		
		/*
		 *  # ���� �۸� ��Ģ (�������)
		 *   - �� �ܾ� �̻��� �̾���� �� _�� Ȱ���Ѵ� (snake_case) - apple_count
		 *   - �� �ܾ� �̻��� �̾���� �� �빮�ڸ� Ȱ���Ѵ� (CamelCase) - appleCount
		 *   - ������ ù ���ڴ� �ҹ��ڸ� ���
		 *   - ���α׷� ������ ���� ������ ���� ����(���)�� ��� �빮�ڸ� ���
		 *   - ������ ���� ���� ������ ������ �ܾ� ���
		 *   
		 *   # ���� �۸� ��Ģ (�ʼ�����)
		 *    - ù ��° ���ڴ� ���ڰ� �� �� ����.
		 *    - ���� ���̿��� ���� ����� �� ����. 
		 *    - Ư�����ڴ� _�� $ �� ����� �� �ִ�.
		 *    - �̹� �ڹٿ��� ����ϰ� �ִ� Ű����� ����� �� ����.  
		 */
	}
	
}
