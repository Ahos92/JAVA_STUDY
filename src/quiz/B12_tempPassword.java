package quiz;

import java.util.Random;

public class B12_tempPassword {
	
	// ���� 4�ڸ��� �ӽ� ��й�ȣ ���ڿ��� �����ϴ� ���α׷��� ��������
	// (��й�ȣ�� �����ϴ� ����  - ���ĺ� �빮��, ����)
	
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
		
		//   ������ ���ڵ��� ���� �ϱ�
		String charset = "ABCDEFGHIGKLMNOPQRSTUVWXYZ1234567890";
		for(int i = 0;  i < 4; ++i) {
			char ch;
			
			// �׳��� Ȯ���� �����ִ� �ڵ�
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
