package study;

// �߻� Ŭ���� : Ŭ���� ���ο� �߻� �޼��带 ���� Ŭ����

// # �߻� �޼��� abstract
//	- �Լ��� ���¸� ���س��� �ڽ� Ŭ�������� �����ϰ�(�������̵�) �����.
//	- �ڽ� Ŭ�������� �������̵� ���� ������ ������ �߻� (������ ȿ��)
//	- �ڽ� Ŭ������ ���� ������ �ش� �޼��尡 100% ����
// 	- ��ĳ���� ���� �� �ڽ� Ŭ�������� ������ �ڵ带 ����ϰ� �ȴ�.

// �ڽ� Ŭ�������� ���¸� �̸� ������ �� 
// �ڽ� Ŭ�������� �޼��带 �������̵� �Ͽ� ����ϰ� �����.

public class C06_abstract {

	public static void app(String msg, String read, C06_ChatApp chatapp) {
		chatapp.send(msg);
		chatapp.read(read);
		System.out.println();
	}

	public static void messenger(String msg, String read, int code) {
		switch(code) {
		case 1:
			app(msg, read, new C06_Kakao());
			break;
		case 2:
			app(msg, read, new C06_Line());
			break;
		case 3:
			app(msg, read, new C06_Telegram());
			break;
		}

	}

	public static void main(String[] args) {

		// abstract Ŭ������ �װ��� ��� �޴� ���̽��� ���� �غ�����
		// (�߻� �޼��尡 �ݵ�� �����ؾ� ��)
		
		messenger("����", "�׷�", 1);
		messenger("����", "�׷�", 2);
		messenger("����", "�׷�", 3);

	}

}




