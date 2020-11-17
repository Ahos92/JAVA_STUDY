
public class D09_argument {

	// Eclipse에서 argument 테스트하기
	
	// 1. 해당 파일 프로퍼티
	// 2. Run and Debug Setting - > Edit
	// 3. Arguments에 원하는 값 추가
	
	public static void main(String[] args) {
		
		// 리눅스에서 실행시 옵션 주듯이 사용하는 것
		
		System.out.println("받은 실행 옵션 : " + args.length);
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(i + "첫번째 프로그램 실행 옵션 : " + args[i]);
		}
	}
	
}
