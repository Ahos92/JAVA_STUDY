package crypto;

import java.util.Arrays;

public class CaesarCipher extends Cipher {

	// # 암호란?
	// 	- 비밀 메세지를 주고받기 위한 것
	//	- 암호화(Encryption) : 평문(일반 메세지)를 암호문(비밀 메세지)로 바꾸는것
	//	- 복호화(Decryption) : 암호문을 평문으로 되돌리는 것
	//	- 키(key) : 암호화와 복호화에 사용되는 비밀 값

	// # 시저(카이사르) 암호
	//	- 알파벳을 키(Key)값 만큼 오른쪽으로 이동시키는 암호 방식
	//	- 암호화 : 평문을 키 값 만큼 오른쪽으로 이동시킨다.
	//	- 복호화 : 암호문을 키 값 만큼 왼쪽으로 이동시킨다.

	// ex>
	// ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcef....
	//	# Key값이 3인 경우 암호화 (+3)
	//	"Hello, Wordl!"	=> "Khoorc#Zruog$"
	//	# Key값이 3인 경우 복호화 (-3)
	//	"Khoorc#Zruog$" => "Hello, Wordl!"

	int key;
	char[] pwd = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$,abcdefghijklmnopqrstuvwxyz").toCharArray();

	public CaesarCipher(int key) {
		// this.key = key;
		this.key = key % pwd.length;
	}

	public int indexOf(char ch) {
		for(int i = 0; i < pwd.length; ++i) {
			if (ch == pwd[i]) {
				return i;
			}
		}
		return -1;
	}
	public String encryption(String plain_text) {
		// 매개변수로 받은 평문을 암호화 하여 리턴하는 함수 
		StringBuilder encryp = new StringBuilder();	
		for(int i = 0; i < plain_text.length(); ++i) {
			char ch = plain_text.charAt(i);
			int index = indexOf(ch);
			
			if(index != -1) {
				encryp.append(pwd[(index + key) % pwd.length]);
			}else {
				// pwd에 없는 문자는 그대로 유지.
				encryp.append(ch);
			}
		}
		return encryp.toString();
	}

	public String decryption(String crypto_text) {
		// 매개변수로 받은 암호문을 복호화 하여 리턴하는 함수
		StringBuilder decryp = new StringBuilder();	
		for(int i = 0; i < crypto_text.length(); ++i) {
			char ch = crypto_text.charAt(i);
			int index = indexOf(ch);
			
			if(index != -1) {
				int plain_index = index - key;
				plain_index = plain_index < 0 ?
						plain_index + pwd.length : plain_index;
				
				decryp.append(pwd[plain_index]);
			}else {
				// pwd에 없는 문자는 그대로 유지.
				decryp.append(ch);
			}
		}

		return decryp.toString();
	}

	public static void main(String[] args) {

		String a = new CaesarCipher(999).encryption("Hello, world!");
		System.out.println(a);
		
		String b = new CaesarCipher(999).decryption(a);
		System.out.println(b);
	}

}
