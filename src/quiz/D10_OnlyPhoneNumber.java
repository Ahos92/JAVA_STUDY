package quiz;

import java.util.Scanner;
import java.util.regex.Pattern;

public class D10_OnlyPhoneNumber {

	// 사용자로부터 전화번호만 입력 받아보세요 
	//	(전화 번호 형태가 아닐경우 에러메세지 출력 후 다시입력)

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String user_in = null;
		String phoneNumber_regex = "01[016789]-\\d{3,4}-[0-9]{4}";

		while (true) {
			System.out.print("핸드폰 번호를 입력해 주세요\n>>>");
			user_in = sc.next();

			if (Pattern.matches(phoneNumber_regex, user_in)) {
				
				System.out.println("저장된 번호\n " + user_in);
				break;
			}
			System.err.println("번호의 형태가 잘못 되었습니다. 다시 입력해 주세요\n예) 0XX-XXX-XXXX, 0XX-XXXX-XXXX");
		}

	}
}
