package quiz;

public class B11_count_369_clap {

	// ����ڷκ��� ���� �ϳ��� �Է� �ް�
	// �ش� ���� ���� 369������ ����ȴٸ� �ڼ��� �� ��� �ľ��ϴ��� �������

	public static void main(String[] args) {

		// ���α׷� ����ð� ���� System.currentTimeMillis(); �и�������
		Long start_time = System.currentTimeMillis();	
		// '��Ʈ'�� �ϱ�
		int user = 99999999;
		int i = 0, check = 0, clap_count = 0;
		
		boolean debugMode = false;
		
		while(i < user) { 
			++i;
			check = i;
			
			if(debugMode) {
				System.out.printf("%d : ", i);
			}
			
			while(check != 0) {
				if(check % 10 == 3 || check % 10 == 6 || check % 10 == 9) {
					++clap_count;
					if(debugMode) {
						System.out.print("¦");
					}
				}
				check /= 10;			
			}
			if(debugMode) {
				System.out.println();
			}
		}
		System.out.println(clap_count+"ȸ");
		
		Long end_time = System.currentTimeMillis();
		
		System.out.println("�ɸ� �ð� : "+(end_time - start_time));
	
		// ���� ���� �ϱ�
//		int clap = 0;
//		
//		for (int i = 1; i <= user; ++i) {
//			String ch = "" + i;
//			int len = ch.length();
//			
//			for (int k = 0; k < len; ++k) {
//				if(ch.charAt(k) == '3' ||
//						ch.charAt(k) == '6' ||
//						ch.charAt(k) == '9') {
//					++clap;
//				}
//			}
//		}System.out.println(clap);
//		
//		Long end_time = System.currentTimeMillis();
//		
//		System.out.println("�ɸ� �ð� : "+(end_time - start_time));

	}
}

