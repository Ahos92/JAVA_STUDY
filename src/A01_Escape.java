
public class A01_Escape {

	public static void main(String[] args) {

		/* Escape 문자
		 * 	- 특수한 기능을 가짐
		 * 	- 그냥 출력하려하면 문제가 생김
		 * 	- 앞에 \ 가 붙은 문자가 Escape문자
		 * 	- 두 문자가 합쳐서 하나의 문자로 인식
		 */
		
		// \n 줄바꿈
		System.out.println("안녕하세요!\n반갑습니다.\n");
		
		// \t 
		System.out.println("안녕하세요!\t반갑습니다.");
		System.out.println("이름\t혈액형\t최근헌혈여부");
		System.out.println("홍길동\tA형\tNO");
		System.out.println("임꺽정\tB형\tYES");
		
		// \\ 역슬래시를 출력하고 싶을때 사용
		System.out.println("C:\\Program Files\\Java\\jdk");
		
		// \" 큰따옴표를 출력하고 싶을 때 사용 ( \' 도 마찬가지)
		System.out.println("저녁은 \"지옥\'에서 먹는다.ㅎ");
		
	}

}
