package crypto;

public class CaesarHacker {

	// '��ȣ��'�� 'chartset'�� '�˰���'�� ������ȣ ������� �˰� �ִٰ� ������ ���·�
	// ��ȣ���� �̿��Ͽ� ���� ������ ������
	
	// �� ��ȣ�� �������� ���� �� ���� ��3������ ��� �����ڰ� �˰��ִٰ� �����Ѵ�.
	static char[] pwd = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz").toCharArray();
	
	static String text = "UryyBmhJBEyqi";
	
	public static void main(String[] args) {
		
//		String text = plain_text("UryyBmhJBEyqi");
		for(int key = 0; key < pwd.length; ++key) {
			// ��� key���� �����غ��� ���� ���� ������ �� �ִ�.
			CaesarCipher cipher = new CaesarCipher(key);
			System.out.println(cipher.decryption(text));
		}
	}
	
	
}
