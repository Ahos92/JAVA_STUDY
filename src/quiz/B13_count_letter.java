package quiz;

public class B13_count_letter {

	// ����ڷκ��� ������ �ϳ� �Է� �޾Ҵ� ġ��
	// �ش� ���ڿ��� ����ĺ��� ��� �����ߴ��� ��� ����غ�����
	// ��ҹ��� ����X
	public static void main(String[] args) {

		String str = "GitHub is home to over 50 million developers working together to host and review code";
		str= str.toUpperCase();

		int[] count = new int[26];

		for(int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if(ch >= 'A' && ch <= 'Z') {
				count[ch - 'A'] += 1;
				/*
		  			'A' - 'A' -> 0 -> count[0] += 1
				 */
			}
		}
		for(int i = 0; i < 26; ++i) {
			if(count[i] > 0) {
				System.out.printf("%c�� ������ Ƚ���� %d�Դϴ�.\n", i+'A', count[i]);
			}
		}
	}
}
