package study;

public class B00_operator01 {

	public static void main(String[] args) {
		
		// ������ operator
		
		// ��� ������
		int a = 10, b=7;
		double c =7.0;
		System.out.printf("a = %d, b = %d\n",a,b);
		// ���� �켱����
		System.out.println("+ : "+(a + b));
		System.out.println("- : "+(a - b));
		System.out.println("X : "+ a * b);
		
		// ���� ���� ������ �� ���´�.
		System.out.println(a / b);
		System.out.println(a / c);
		System.out.println(a / (double)b);
		System.out.println(a % b); // ������
		
		System.out.println("����  : "+Math.pow(10, 3)); // ���� double Ÿ��
		System.out.println("������ : "+Math.sqrt(2));// ������
		System.out.println("���밪 : "+Math.abs(-20));// ���밪
		System.out.println("�ݿø� : "+Math.round(1.234));// �ݿø�
		System.out.println("�ø�  : "+Math.ceil(1.001));
		System.out.println("����  : "+Math.floor(1.999));
		System.out.println("�� ū ���� : "+Math.max(a, b));
		System.out.println("�� ���� ���� : "+Math.min(a, b));
		
		System.out.println(a ^ b); // ������ �ƴϴ� (XOR - ���� �ٸ��� 1)
		
		
	}
		
}
