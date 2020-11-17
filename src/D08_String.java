import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;



public class D08_String {

	public static void main(String[] args) {
		
		String str = "apple/banana/orange/sagwa";
		
		// split : ���ڿ��� �ش� ���� �������� �߶� ���ڿ� �迭�� ��ȯ�Ѵ�.
		String[] fruits = str.split("/");
		System.out.println(Arrays.toString(fruits));
		System.out.println();
		
		// join : ������ ���ڸ� �̿��Ͽ� ���ڿ� �迭�� ��ģ�� 
		System.out.println(String.join(", ", fruits));
		System.out.println();
		
		// replace : ��ġ�ϴ� ���ڿ��� ��� ���ϴ� ���ڿ��� ��ü�� ����� ��ȯ�Ѵ�.
		str = "abc123@naver.com";
		str = str.replace("@naver.com", "@gamil.com");
		System.out.println(str);
		System.out.println();
		
		str = "My name is Bob. My name is Sue. My name is John";
		str = str.replace("is", "was");
		System.out.println(str);
		System.out.println();
		
		// replaceAll 
		//  - �ش� ���� ǥ���İ� ��ġ�ϴ� ���ڿ��� ��� ���ϴ� ���ڿ��� ��ü�� ����� ��ȯ
		///////////////////////////////////////////////////////////////////////
		
		// format : ������ �̿��� ���ϴ� ���ڿ��� �����Ѵ�.
		System.out.println(String.format("%d�� %d�� %d.%d", 1, 2, 3, 1234));
		System.out.println();
		
		// contains : �ش� ���ڿ��� ���ԵǾ��ִ����� �˻��Ѵ�.
		System.out.println(str.contains("bob"));
		System.out.println(str.toLowerCase().contains("bob"));
		System.out.println();
		
		// eqaulsIgnoreCase() : ��ҹ��ڿ� ������� ��ġ�ϴ��� �˻��Ѵ�.
		System.out.println("Apple".equalsIgnoreCase("aPPLE"));
		System.out.println();
		
		// startsWith(seq) : ���ڿ��� �ش� ���ڿ��� �����ϴ��� �˻��Ѵ�.
		str = "image-fruit-apple.jpg";
		System.out.println(str.startsWith("image"));
		// endsWith(seq) : ���ڿ��� �ش� ���ڿ��� �������� �˻��Ѵ�.
		System.out.println(str.endsWith(".jpg"));
		System.out.println();
		
		// getBytes : ���ڿ��� byteŸ�� �迭�� �����Ѵ�.
		str = "ABCDEFG";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes));
		System.out.println(new String(bytes));
		
		str = "�ȳ��ϼ���";
		try {
			// ���ڿ� �ڵ�ȭ (���ڵ�)
			byte[] utf8_bytes = str.getBytes("UTF-8");
			byte[] euc_bytes = str.getBytes("EUC-KR"); // default
			
			System.out.println(Arrays.toString(utf8_bytes));
			System.out.println(Arrays.toString(euc_bytes));

			// �ڵ带 ���ڿ��� (���ڵ�)
			//	- ���ڵ��� �� ����ߴ� ������� ���ڵ����� ������ �ѱ��� ������
			System.out.println(new String(utf8_bytes, "UTF-8"));
			System.out.println(new String(utf8_bytes, "EUC-KR"));
			
 		} catch(UnsupportedEncodingException e) {
 			System.out.printf("�������� �ʴ� �ڵ��Դϴ� %s", e.getMessage());
 		}
		System.out.println();
		
		// getChars : char[]�� ���ڿ��� ���ϴ� �κ��� ����ش�.
		str = "Hello java python c-lang!!";
		char[] buffer = new char[10];
		str.getChars(6, 16, buffer, 0);
		System.out.println(buffer);
		System.out.println();		
		
		// substring : ���ڿ��� ���ϴ� �κ��� ���ڿ��� ����
		System.out.println(str.substring(10)); // ���������ָ� ��������
		System.out.println(str.substring(11, 17));
		System.out.println();
		
		// compareTo : Comparable �������̽� �޼���
		System.out.println("compare result : " + " car ".compareTo("jet"));
		System.out.println();
		
		// trim :  ���ڿ� �ٱ����� ������ �����Ѵ�
		str = "   good bye   ";
		System.out.println(str.length());
		System.out.println(str.trim().length());
		System.out.println();
		
		//valueOF : �ٸ� Ÿ���� ������ ���ڿ��� ��ȯ�Ѵ�.
		//			(�ش� ������ toStirign ����� ����-
		String out = String.valueOf(123);
		System.out.println(out);
		System.out.println();
		
		// StringTokenizer
		//	- ���ڿ��� �ڸ��µ��� Ưȭ�� Ŭ����
		//	-	split�� ���������� ���� �� �� �դ���.
		str = "99/88/77/66/55/44/33/22/11";
		
		// �ڸ� �� ����߶� ���ڿ��� �ʿ��ϴٸ� ����° �Ķ���͸� true�� Ȱ��ȭ
		StringTokenizer st = new StringTokenizer(str, "/");
		System.out.println("��ū ���� : " + st.countTokens());
		// Element�� ObjectŸ������ ��ȯ�ϳ�
		// Token�� String
		while(st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		//String ������
		new String();
		
	}
	
}
