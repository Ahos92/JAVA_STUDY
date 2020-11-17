package quiz;

import java.util.Random;

public class B12_tempPassword {
	
	// 랜덤 4자리의 임시 비밀번호 문자열을 생성하는 프로그램을 만들어보세요
	// (비밀번호를 구성하는 문자  - 알파벳 대문자, 숫자)
	
	public static void main(String[] args) {
		
		Random ran = new Random();
		char temp_ch = ' ';
		StringBuilder temp_pwd = new StringBuilder();
		
		// me
//		while(true){
//			temp_ch = (char)(ran.nextInt(43)+48);
//			if((temp_ch >= 'A' && temp_ch <= 'Z') || 
//					(temp_ch >= '0' && temp_ch <= '9')) {
//				temp_pwd.append(temp_ch);
//			}
//			if(temp_pwd.length() == 4) {
//				break;
//			}
//		}
//		System.out.println(temp_pwd);
		
		//   나만의 인코딩을 만들어서 하기
		String charset = "ABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";
		for(int i = 0;  i < 4; ++i) {
			char ch;
			
			// 그나마 확률을 맞춰주는 코드
			if(ran.nextBoolean()) {
				ch = (char)(ran.nextInt(26) + 'A');
			}else {
				ch = (char)(ran.nextInt(10) + '0');
			}
			temp_pwd.append(ch);			
		}
		System.out.println(temp_pwd);
	}

}
