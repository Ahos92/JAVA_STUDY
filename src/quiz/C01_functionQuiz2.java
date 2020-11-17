package quiz;

import java.util.Arrays;

public class C01_functionQuiz2 {

	// 1. �ּҰ�. �ִ밪 �Ű������� ������, �� ������ ��� ���� �����ϴ� int �迭�� ��ȯ�ϴ� range �Լ��� ����� ������
	//			( �ּ� �̻� �ִ� �̸�)
	public static int[] range(int min, int max) {
		int[] range = new int[max-min];
		if(min > max) {
			return null;
		}
		for(int i = 0; i < range.length; ++i) {
			range[i] = min + i;
		}
		return range;
	}

	//2. �ִ밪�� �Ű������� ���� ������, 0���� �ִ밪 �̸��� ��� ���� �����ϴ� range2 �Լ�
	//				Overloading �����̸��ᵵ�� �������� �ٸ���
	public static int[] range(int max) {
		int[] range2 = new int[max];
		for(int i = 0; i < max; ++i) {
			range2[i] = i;
		}
		return range2;
	}

	//3. ���ڿ� �迭 ���� ������, �ش� �迭�� ��� "/"�� �̾���̴� �Լ��� ����� ������
	//		{"apple" , "banana", oragne}; return> "apple/banana/orage"
	public static String join(String[] word) {
		StringBuilder msg = new StringBuilder();
		msg.append("\"");
		for(int i = 0; i < word.length; ++i) {
			if(i == word.length-1) {
				msg.append(word[i]);	
			}else {	
				msg.append(word[i]+"/");
			}
		}
		msg.append("\"");

		return msg.toString();
	}

	//4. ���ڿ� Ÿ���� ����(num), ���� ����(base_from) , �ٲٷ��� ����(base_to)�� ���� ������
	//	base_from�� �ش� ���ڸ� base_to ������ ���ڿ��� ��ȯ�Ͽ� ��ȯ�ϴ� �Լ�
	//	����, ������ �߸��� ��� null�� ��ȯ�մϴ�.
	// 	��ȯ �Ҽ� �ִ� �ִ� ������ 36����, �ּ� ������ 2����

	public static char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static int getValue(char digit) {
		// index���� ���� ������ �̿��ϱ����� char���迭
		for(int i = 0; i < digits.length; ++i) {
			if(digits[i] == digit) {
				return i;		
			}
		}
		return -1;
	}

	public static char getSymbol(int value) {
		return digits[value];
	}
	public static String convert_base(String num, int base_from, int base_to) {

		if(base_from < 2 || base_from > 36 || base_to < 2 || base_to > 36) {
			System.err.println("RadixError : ��� ������ ������ 2���� 36�Դϴ�.");
			// ��������Ʈ
			return null;
		}

		int pow = num.length() - 1;
		long real_value = 0;

		// ���� �� 10���� �����
		//  (base_from, length-0) * charAt(0) 
		// +(base_from, length-1) * charAt(1)
		// +(base_from, length-2) * charAt(2)		
		for(int i = pow; i > -1; --i) {
			char digit = num.charAt(pow - i);
			int value = getValue(digit);// ACDEFG ... XYZ ���� ���������� �ޱ����� �Լ�

			if(value >= base_from) {
				System.err.println("base_from �̻��� ���ڰ� �ֽ��ϴ�.");
				return null;
			}
			
			System.out.println(digit);
			System.out.println("\t���� �� :" + value);
			System.out.println("\t" + Math.pow(base_from, i) + "�� �ڸ�");

			real_value += value * Math.pow(base_from, i);
		}
		System.out.printf("%d���� ���ڿ� \"%s\"�� ���� ������ %d�Դϴ�.\n", base_from, num, real_value);

		// �״��� ��ȯ�� �������� �����
		//		while(ch / base_to != 0) {
		//			ch = ch / base_to;
		//			result += ch % base_to * (int)Math.pow(10, i);
		//			i++;
		//		}
		StringBuilder result = new StringBuilder();
		while(real_value > 0) {			
			
			result.append(getSymbol((int)(real_value % base_to)));
			real_value /= base_to;
		}
			
		return result.reverse().toString(); // reverse()
	}


	public static void main(String[] args) {
		String[] fruits = {"apple", "banana", "orange"};

		// # �Լ��� �����ε� - ex) println();
		// 	- ���� �Լ��̸����� ���� ����
		// 	- �ٸ� ������ �Լ��� �����ޱ� ���ؼ���
		// 	   �Ű������� ���� Ȥ�� Ÿ���� �޶�� �Ѵ�.
		System.out.println(Arrays.toString(range(0, 5)));
		System.out.println(Arrays.toString(range(5)));

		System.out.println(join(fruits));

		System.out.println(convert_base("1234ZD", 36, 10));
	}
}
