import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class D10_Regex {
	
	// # 정규표현식 (Regular Expression)
	// 	- 문자열의 패턴을 표현하는 방식
	//	- 해당 패턴과 일치하는 문자열을 검색할 수 있다

	// 대표적으로 
	// # pattern 클래스
	//	- 정규표현식을 다루는 클래스
	
	// # Matcher 클래스
	//	- 패턴을 이용하여 대상 문자열을 검색할 때 사용하는 클래스
	
	public static void main(String[] args) {
	
		String str = "abc@naver.com";
		
		// 
//		if (str.contains("@") && str.contains(".")) {
//			System.out.println("이메일입니다.");
//		} else {
//			System.out.println("이메일이 아닙니다. 형식을 맞추시오.");
//		}
		// =>
					
		// Pattern.matche(regex, str);
		//	- 전달한 문자열이 정규표현식과 일치하면 true
		
		System.out.println(Pattern.matches("sleep", "sleep"));
		System.out.println();
		
		// [] : 해당위치의 '한 글자'에 어떤 문자들이 올 수 있는지 정의한다.
		System.out.println(Pattern.matches("s[lh]eep", "sleep"));
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "skeep"));
		System.out.println();
		
		// []내부에 정의 할 수 있는 것들
		//	1. abc	 : abc만 허용
		//	2. ^abc  : abc를 제외한 모두 허용
		// 	3. a-z 	 : a부터 z까지 허용
		//	4. && 	 : 교집합
		System.out.println(Pattern.matches("s[^1-9]eep", "s0eep"));
		System.out.println(Pattern.matches("s[a-zA-Z]eep", "sheep"));
		System.out.println(Pattern.matches("s[aeiou]eep", "sieep"));
		System.out.println(Pattern.matches("s[a-dm-z]eep", "smeep"));
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sceep"));
		System.out.println();
		
		//	여러 문자를 간단하게 표현하는 것들
		//	1. . : 해당 자리에 모든 문자를 허용 ( []밖에 써야함 )
		//	2. \d : 해당 자리에 숫자들을 허용
		//	3. \D : 해당 자리에 숫자를 제외한 모든것허용
		// 	4. \s : 해당자리에 공백을 허용 -> [\t \n \r.... 등의 모든 공백들]
		//	5. \S : 해당자리에 공백이 오면 안됨
		//	6. \w : 일반적인 문자를 허용 [a-zA-Z_0-9]
		//	6. \W : 일반적인 문자들을 제외한 모든 것을 허용
		System.out.println(Pattern.matches("s.eep", "s*eep"));
		System.out.println(Pattern.matches("s\\deep", "s2eep"));
		System.out.println(Pattern.matches("s\\Deep", "s2eep"));
		System.out.println(Pattern.matches("s\\seep", "s eep"));
		System.out.println(Pattern.matches("s\\Seep", "s eep"));
		System.out.println();
		
		// # 해당 패턴이 적용될 문자의 개수를 정의하는 방법
		//	1. Ex{n} 	: 앞에 있는 패턴이 n글자 일치해야 함.
		//	2. Ex{n,m} 	: 앞에 있는 패턴이 최소 n글자부터 최대 m글자 일치해야 함.
		//	3. Ex{n,} 	: n글자 이상 일치해야 함.
		//	4. Ex?		: 0번 혹은 한번
		//	5. Ex+		: 최소 한번
		//	6. Ex*		: 0번 혹은 여러번
		System.out.println(Pattern.matches("....[\\d]{2}", "ahos92"));
		System.out.println("유효한 아이디 : " + Pattern.matches("[\\w가-힣]{2,12}", "아호스ahos92"));
		System.out.println(Pattern.matches("....[\\d]{2,}", "ahos9213123213213213211232312513265343687364"));
		System.out.println(Pattern.matches("[@]?", ""));
		System.out.println();
		
		// 
		String email = "abc@gmail.com";
		System.out.println("이메일 패턴 : "
				+ Pattern.matches("[\\w]+@[a-zA-Z0-9]+[.][a-zA-Z.]+", email));
		System.out.println();
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// # Pattern.compile(regex)
		//	- 전달한 정규표현식을 이용해 생성한 인스턴스를 반환
		Pattern splie_regex = Pattern.compile("/");
		
		String fruit[] = splie_regex.split("apple/banana/orange/kiwi");
		System.out.println(Arrays.toString(fruit));
		System.out.println();
		// # 생성된 apttern 인스턴스로 Matcher 생성하기
		
		// # Matcher
		//	- java.util.regex.Matcher
		//	- 문자열을 처음부터 끝까지 검사하면서 정규표현식과 일치하는 인덱스를 찾아준다.
		Pattern fruit_regex = Pattern.compile("[a-zA-Z[^/]]+"); // [a-zA-Z]+
										
		Matcher matcher = fruit_regex.matcher("apple/banana/orange/kiwi");
		
		// find : 정규표현식을 통해 찾은 것이 있으면 true
		while (matcher.find()) {
			System.out.println("찾은 것 : " + matcher.group());
			System.out.println(matcher.start() + " to " + matcher.end());
		}
	}

}
