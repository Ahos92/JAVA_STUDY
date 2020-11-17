package quiz;

import java.util.Scanner;
import java.util.regex.Pattern;

public class D10_OnlyPhoneNumber {

	// ����ڷκ��� ��ȭ��ȣ�� �Է� �޾ƺ����� 
	//	(��ȭ ��ȣ ���°� �ƴҰ�� �����޼��� ��� �� �ٽ��Է�)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String user_in = null;
		String phoneNumber_regex = "01[016789]-\\d{3,4}-[0-9]{4}";

		while (true) {
			System.out.print("�ڵ��� ��ȣ�� �Է��� �ּ���\n>>>");
			user_in = sc.next();

			if (Pattern.matches(phoneNumber_regex, user_in)) {
				
				System.out.println("����� ��ȣ\n " + user_in);
				break;
			}
			System.err.println("��ȣ�� ���°� �߸� �Ǿ����ϴ�. �ٽ� �Է��� �ּ���\n��) 0XX-XXX-XXXX, 0XX-XXXX-XXXX");
		}

	}
}
