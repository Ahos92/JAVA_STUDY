package study;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class D10_Regex {
	
	// # ����ǥ���� (Regular Expression)
	// 	- ���ڿ��� ������ ǥ���ϴ� ���
	//	- �ش� ���ϰ� ��ġ�ϴ� ���ڿ��� �˻��� �� �ִ�

	// ��ǥ������ 
	// # pattern Ŭ����
	//	- ����ǥ������ �ٷ�� Ŭ����
	
	// # Matcher Ŭ����
	//	- ������ �̿��Ͽ� ��� ���ڿ��� �˻��� �� ����ϴ� Ŭ����
	
	public static void main(String[] args) {
	
		String str = "abc@naver.com";
		
		// 
//		if (str.contains("@") && str.contains(".")) {
//			System.out.println("�̸����Դϴ�.");
//		} else {
//			System.out.println("�̸����� �ƴմϴ�. ������ ���߽ÿ�.");
//		}
		// =>
					
		// Pattern.matche(regex, str);
		//	- ������ ���ڿ��� ����ǥ���İ� ��ġ�ϸ� true
		
		System.out.println(Pattern.matches("sleep", "sleep"));
		System.out.println();
		
		// [] : �ش���ġ�� '�� ����'�� � ���ڵ��� �� �� �ִ��� �����Ѵ�.
		System.out.println(Pattern.matches("s[lh]eep", "sleep"));
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "skeep"));
		System.out.println();
		
		// []���ο� ���� �� �� �ִ� �͵�
		//	1. abc	 : abc�� ���
		//	2. ^abc  : abc�� ������ ��� ���
		// 	3. a-z 	 : a���� z���� ���
		//	4. && 	 : ������
		System.out.println(Pattern.matches("s[^1-9]eep", "s0eep"));
		System.out.println(Pattern.matches("s[a-zA-Z]eep", "sheep"));
		System.out.println(Pattern.matches("s[aeiou]eep", "sieep"));
		System.out.println(Pattern.matches("s[a-dm-z]eep", "smeep"));
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sceep"));
		System.out.println();
		
		//	���� ���ڸ� �����ϰ� ǥ���ϴ� �͵�
		//	1. . : �ش� �ڸ��� ��� ���ڸ� ��� ( []�ۿ� ����� )
		//	2. \d : �ش� �ڸ��� ���ڵ��� ���
		//	3. \D : �ش� �ڸ��� ���ڸ� ������ �������
		// 	4. \s : �ش��ڸ��� ������ ��� -> [\t \n \r.... ���� ��� �����]
		//	5. \S : �ش��ڸ��� ������ ���� �ȵ�
		//	6. \w : �Ϲ����� ���ڸ� ��� [a-zA-Z_0-9]
		//	6. \W : �Ϲ����� ���ڵ��� ������ ��� ���� ���
		System.out.println(Pattern.matches("s.eep", "s*eep"));
		System.out.println(Pattern.matches("s\\deep", "s2eep"));
		System.out.println(Pattern.matches("s\\Deep", "s2eep"));
		System.out.println(Pattern.matches("s\\seep", "s eep"));
		System.out.println(Pattern.matches("s\\Seep", "s eep"));
		System.out.println();
		
		// # �ش� ������ ����� ������ ������ �����ϴ� ���
		//	1. Ex{n} 	: �տ� �ִ� ������ n���� ��ġ�ؾ� ��.
		//	2. Ex{n,m} 	: �տ� �ִ� ������ �ּ� n���ں��� �ִ� m���� ��ġ�ؾ� ��.
		//	3. Ex{n,} 	: n���� �̻� ��ġ�ؾ� ��.
		//	4. Ex?		: 0�� Ȥ�� �ѹ�
		//	5. Ex+		: �ּ� �ѹ�
		//	6. Ex*		: 0�� Ȥ�� ������
		System.out.println(Pattern.matches("....[\\d]{2}", "ahos92"));
		System.out.println("��ȿ�� ���̵� : " + Pattern.matches("[\\w��-�R]{2,12}", "��ȣ��ahos92"));
		System.out.println(Pattern.matches("....[\\d]{2,}", "ahos9213123213213213211232312513265343687364"));
		System.out.println(Pattern.matches("[@]?", ""));
		System.out.println();
		
		// 
		String email = "abc@gmail.com";
		System.out.println("�̸��� ���� : "
				+ Pattern.matches("[\\w]+@[a-zA-Z0-9]+[.][a-zA-Z.]+", email));
		System.out.println();
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// # Pattern.compile(regex)
		//	- ������ ����ǥ������ �̿��� ������ �ν��Ͻ��� ��ȯ
		Pattern splie_regex = Pattern.compile("/");
		
		String fruit[] = splie_regex.split("apple/banana/orange/kiwi");
		System.out.println(Arrays.toString(fruit));
		System.out.println();
		// # ������ apttern �ν��Ͻ��� Matcher �����ϱ�
		
		// # Matcher
		//	- java.util.regex.Matcher
		//	- ���ڿ��� ó������ ������ �˻��ϸ鼭 ����ǥ���İ� ��ġ�ϴ� �ε����� ã���ش�.
		Pattern fruit_regex = Pattern.compile("[a-zA-Z[^/]]+"); // [a-zA-Z]+
										
		Matcher matcher = fruit_regex.matcher("apple/banana/orange/kiwi");
		
		// find : ����ǥ������ ���� ã�� ���� ������ true
		while (matcher.find()) {
			System.out.println("ã�� �� : " + matcher.group());
			System.out.println(matcher.start() + " to " + matcher.end());
		}
	}

}
