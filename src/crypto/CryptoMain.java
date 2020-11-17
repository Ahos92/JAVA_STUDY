package crypto;

import java.util.Scanner;

public class CryptoMain {

	// 사용자가 메세지와 키값을 설정하고 원하는 암호 알고리즘으로
	// 암호화/복호화 작업을 할 수 있는 프로그램을 만들어보세요
	int key;
	int code;
	String msg;

	public CryptoMain(int key, String msg, int code) {
		this.key = key;
		this.msg = msg;
		this.code = code;
	}

	public static String selectEncryption(int key, String msg, int code) {
		Cipher cipher = null;

		if(code == 1) {
			cipher = new CaesarCipher(key);
		}else if (code == 2) {
			cipher = new TranspositionCipher(key);
		}
		
		String result = cipher.encryption(msg);
		
		return result;
	}

	public static void programPrint() {
		System.out.println("-----------------------------");
		System.out.println("1.메세지 설정");
		System.out.println("2.키 값 설정");
		System.out.println("3.알고리즘 설정");
		System.out.println("4.실행");
		System.out.println("-----------------------------");
	}

	public static void programPrint(String msg, int key, int code) {
		System.out.println("-----------------------------");
		System.out.printf("메세지 : %s\n", msg);
		System.out.printf("키 값 : %d\n", key);
		System.out.printf("알고리즘 : %s\n", algorithmPrint(code));
		System.out.println("-----------------------------");

	}

	public static String algorithmPrint(int code) {
		String text = "";
		return text = code == 1 ? "Caesar" : "Transposition";
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		String msg = "";
		int key = 0 , code = 0;

		
		// 상속은 여러 클래스를 일반화 (업캐스팅) 시키는 용도로 주로 많이 사용한다.
		
		while(true) {
			programPrint();

			int select = user.nextInt();

			Scanner sc = new Scanner(System.in);

			switch(select) {

			case 1:
				System.out.print("메세지 설정 > ");
				msg = sc.nextLine();
				break;
			case 2:
				System.out.print("키 값 설정 > ");
				key = sc.nextInt();
				break;
			case 3:
				System.out.println("1. Caesar");
				System.out.println("2. Transposition");
				System.out.print("알고리즘 선택 > ");
				code = sc.nextInt();
				break;
			case 4:
				selectEncryption(key, msg, code);
				break;
			default :
				break;

			}
			programPrint(msg, key, code);

		}
	
	}
}
