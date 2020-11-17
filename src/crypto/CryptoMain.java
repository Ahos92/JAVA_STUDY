package crypto;

import java.util.Scanner;

public class CryptoMain {

	// ����ڰ� �޼����� Ű���� �����ϰ� ���ϴ� ��ȣ �˰�������
	// ��ȣȭ/��ȣȭ �۾��� �� �� �ִ� ���α׷��� ��������
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
		System.out.println("1.�޼��� ����");
		System.out.println("2.Ű �� ����");
		System.out.println("3.�˰��� ����");
		System.out.println("4.����");
		System.out.println("-----------------------------");
	}

	public static void programPrint(String msg, int key, int code) {
		System.out.println("-----------------------------");
		System.out.printf("�޼��� : %s\n", msg);
		System.out.printf("Ű �� : %d\n", key);
		System.out.printf("�˰��� : %s\n", algorithmPrint(code));
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

		
		// ����� ���� Ŭ������ �Ϲ�ȭ (��ĳ����) ��Ű�� �뵵�� �ַ� ���� ����Ѵ�.
		
		while(true) {
			programPrint();

			int select = user.nextInt();

			Scanner sc = new Scanner(System.in);

			switch(select) {

			case 1:
				System.out.print("�޼��� ���� > ");
				msg = sc.nextLine();
				break;
			case 2:
				System.out.print("Ű �� ���� > ");
				key = sc.nextInt();
				break;
			case 3:
				System.out.println("1. Caesar");
				System.out.println("2. Transposition");
				System.out.print("�˰��� ���� > ");
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
