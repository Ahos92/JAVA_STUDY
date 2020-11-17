package crypto;

public class CaesarHacker {

	// '암호문'과 'chartset'을 '알고리즘'이 시저암호 방식임을 알고 있다고 가정한 상태로
	// 암호문을 이용하여 평문을 추출해 보세요
	
	// ※ 암호의 강력함을 논할 때 위으 ㅣ3가지는 모두 공격자가 알고있다고 가정한다.
	static char[] pwd = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz").toCharArray();
	
	static String text = "UryyBmhJBEyqi";
	
	public static void main(String[] args) {
		
//		String text = plain_text("UryyBmhJBEyqi");
		for(int key = 0; key < pwd.length; ++key) {
			// 모든 key값을 대입해보면 평문을 쉽게 추측할 수 있다.
			CaesarCipher cipher = new CaesarCipher(key);
			System.out.println(cipher.decryption(text));
		}
	}
	
	
}
