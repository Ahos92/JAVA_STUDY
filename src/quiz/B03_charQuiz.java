package quiz;

public class B03_charQuiz {

	public static void main(String[] args) {
		/*
		 	[�˸��� ���ǽ� �����]
		 	1. char�� ���� a�� 'q'�Ǵ� 'Q'�� �� true
		 	2. char�� ���� b�� �����̳� ���� �ƴ� �� true
		 	3. char�� ���� c�� ����('0' ~ '9')�� �� true
		 	4. char�� ���� d�� ������(�빮�� �Ǵ� �ҹ���)�� �� true
		 	5. char�� ���� e�� �ѱ��� �� true
		 	6. char�� ���� f�� �Ϻ����� �� true
		 */
		
		char a = 'q';
		System.out.println(a=='q' || a=='Q');
		
		char b = 'b';
		System.out.println(!(b==' ' || b=='\t'));
		
		char c = '0';
		System.out.println(c >= 48 && c <= 57);
		
		char d = 'z';
		System.out.println((d >= 65 && d <=90) || (d >= 97 && d <= 122));
		
		char e = '��';
		System.out.println(e >= 12593 && e <= 12686 || e >= 44032 && e <= 55215);
		//�ѱ�
		// Hangul Jamo : 0x1100 ~ 0x11FF
		// Hangul Syllables : 0xAC00 ~ 0xD7A3
		
		char f = '��';
		System.out.println(f >= 12352 && f <= 12543);
		
	}

}
