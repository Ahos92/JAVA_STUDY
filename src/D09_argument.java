
public class D09_argument {

	// Eclipse���� argument �׽�Ʈ�ϱ�
	
	// 1. �ش� ���� ������Ƽ
	// 2. Run and Debug Setting - > Edit
	// 3. Arguments�� ���ϴ� �� �߰�
	
	public static void main(String[] args) {
		
		// ���������� ����� �ɼ� �ֵ��� ����ϴ� ��
		
		System.out.println("���� ���� �ɼ� : " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(i + "ù��° ���α׷� ���� �ɼ� : " + args[i]);
		}
	}
	
}
