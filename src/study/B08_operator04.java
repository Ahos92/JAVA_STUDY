package study;

public class B08_operator04 {

	public static void main(String[] args) {
		
		// ���� ����
		// = : ���� ������ �����ʰ� ����
		int num = 10;
		num = num+5;
		System.out.println(num);
		System.out.println();
		
		num = 10;
		// ���� ���� ���� 
		// - ������Ű�� ����
		num += 5; 
			System.out.println(num);
		num -= 2; 
			System.out.println(num);
		num *= 2; 
			System.out.println(num);
		num /= 4; 
			System.out.println(num);
		num %= 6; 
			System.out.println(num);
		System.out.println();
		
		num = 10;
		// ���� ����
		num++; 
			System.out.println(num);		
		++num; 
			System.out.println(num);
		num--;
			System.out.println(num);
		--num;
			System.out.println(num);
		// ++, -- ��ġ������ ������ٸ� , �տ� ������� ��������
		int a = 3, b = 10;
		int result = ++a*b;
		System.out.println(result);
		System.out.println(a);
	}
}
