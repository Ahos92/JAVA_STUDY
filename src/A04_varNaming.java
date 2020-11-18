
public class A04_varNaming {

	public static void main(String[] args) {
		
		// 변수를 사용해야 하는 이유
		// 값을 한번에 변경 (효율성)
		// 값에 의미 부여 (가독성) 이름 짓는것 매우중요
		
		int apple_count = 45;
		int apple_price = 485;
		int apple_gram = 50;
		int apple_calorie=112;
		
		System.out.println("사과의 총 가격은 "
						+apple_count * apple_price+"원 입니다.");
		
		System.out.println("사과의 총 무게는 "
				+apple_count * apple_gram+"g 입니다.");
		
		System.out.println("사과의 총 칼로리는 "
				+apple_count * apple_calorie+"kcal 입니다.");
		
		/*
		 *  # 변수 작명 규칙 (권장사항)
		 *   - 두 단어 이상을 이어붙일 때 _를 활용한다 (snake_case) - apple_count
		 *   - 두 단어 이상을 이어붙일 때 대문자를 활용한다 (CamelCase) - appleCount
		 *   - 변수명 첫 글자는 소문자를 사용
		 *   - 프로그램 내에서 값이 변하지 않을 변수(상수)는 모두 대문자를 사용
		 *   - 변수의 내용 추측 가능한 적절한 단어 사용
		 *   
		 *   # 변수 작명 규칙 (필수사항)
		 *    - 첫 번째 글자는 숫자가 될 수 없다.
		 *    - 변수 사이에는 공백 사용할 수 없다. 
		 *    - 특수문자는 _와 $ 만 사용할 수 있다.
		 *    - 이미 자바에서 사용하고 있는 키워드는 사용할 수 없다.  
		 */
	}
	
}
