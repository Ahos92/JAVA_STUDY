package study;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class D10_Regex {
	
	// # Á¤±ÔÇ¥Çö½Ä (Regular Expression)
	// 	- ¹®ÀÚ¿­ÀÇ ÆĞÅÏÀ» Ç¥ÇöÇÏ´Â ¹æ½Ä
	//	- ÇØ´ç ÆĞÅÏ°ú ÀÏÄ¡ÇÏ´Â ¹®ÀÚ¿­À» °Ë»öÇÒ ¼ö ÀÖ´Ù

	// ´ëÇ¥ÀûÀ¸·Î 
	// # pattern Å¬·¡½º
	//	- Á¤±ÔÇ¥Çö½ÄÀ» ´Ù·ç´Â Å¬·¡½º
	
	// # Matcher Å¬·¡½º
	//	- ÆĞÅÏÀ» ÀÌ¿ëÇÏ¿© ´ë»ó ¹®ÀÚ¿­À» °Ë»öÇÒ ¶§ »ç¿ëÇÏ´Â Å¬·¡½º
	
	public static void main(String[] args) {
	
		String str = "abc@naver.com";
		
		// 
//		if (str.contains("@") && str.contains(".")) {
//			System.out.println("ÀÌ¸ŞÀÏÀÔ´Ï´Ù.");
//		} else {
//			System.out.println("ÀÌ¸ŞÀÏÀÌ ¾Æ´Õ´Ï´Ù. Çü½ÄÀ» ¸ÂÃß½Ã¿À.");
//		}
		// =>
					
		// Pattern.matche(regex, str);
		//	- Àü´ŞÇÑ ¹®ÀÚ¿­ÀÌ Á¤±ÔÇ¥Çö½Ä°ú ÀÏÄ¡ÇÏ¸é true
		
		System.out.println(Pattern.matches("sleep", "sleep"));
		System.out.println();
		
		// [] : ÇØ´çÀ§Ä¡ÀÇ 'ÇÑ ±ÛÀÚ'¿¡ ¾î¶² ¹®ÀÚµéÀÌ ¿Ã ¼ö ÀÖ´ÂÁö Á¤ÀÇÇÑ´Ù.
		System.out.println(Pattern.matches("s[lh]eep", "sleep"));
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "skeep"));
		System.out.println();
		
		// []³»ºÎ¿¡ Á¤ÀÇ ÇÒ ¼ö ÀÖ´Â °Íµé
		//	1. abc	 : abc¸¸ Çã¿ë
		//	2. ^abc  : abc¸¦ Á¦¿ÜÇÑ ¸ğµÎ Çã¿ë
		// 	3. a-z 	 : aºÎÅÍ z±îÁö Çã¿ë
		//	4. && 	 : ±³ÁıÇÕ
		System.out.println(Pattern.matches("s[^1-9]eep", "s0eep"));
		System.out.println(Pattern.matches("s[a-zA-Z]eep", "sheep"));
		System.out.println(Pattern.matches("s[aeiou]eep", "sieep"));
		System.out.println(Pattern.matches("s[a-dm-z]eep", "smeep"));
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sceep"));
		System.out.println();
		
		//	¿©·¯ ¹®ÀÚ¸¦ °£´ÜÇÏ°Ô Ç¥ÇöÇÏ´Â °Íµé
		//	1. . : ÇØ´ç ÀÚ¸®¿¡ ¸ğµç ¹®ÀÚ¸¦ Çã¿ë ( []¹Û¿¡ ½á¾ßÇÔ )
		//	2. \d : ÇØ´ç ÀÚ¸®¿¡ ¼ıÀÚµéÀ» Çã¿ë
		//	3. \D : ÇØ´ç ÀÚ¸®¿¡ ¼ıÀÚ¸¦ Á¦¿ÜÇÑ ¸ğµç°ÍÇã¿ë
		// 	4. \s : ÇØ´çÀÚ¸®¿¡ °ø¹éÀ» Çã¿ë -> [\t \n \r.... µîÀÇ ¸ğµç °ø¹éµé]
		//	5. \S : ÇØ´çÀÚ¸®¿¡ °ø¹éÀÌ ¿À¸é ¾ÈµÊ
		//	6. \w : ÀÏ¹İÀûÀÎ ¹®ÀÚ¸¦ Çã¿ë [a-zA-Z_0-9]
		//	6. \W : ÀÏ¹İÀûÀÎ ¹®ÀÚµéÀ» Á¦¿ÜÇÑ ¸ğµç °ÍÀ» Çã¿ë
		System.out.println(Pattern.matches("s.eep", "s*eep"));
		System.out.println(Pattern.matches("s\\deep", "s2eep"));
		System.out.println(Pattern.matches("s\\Deep", "s2eep"));
		System.out.println(Pattern.matches("s\\seep", "s eep"));
		System.out.println(Pattern.matches("s\\Seep", "s eep"));
		System.out.println();
		
		// # ÇØ´ç ÆĞÅÏÀÌ Àû¿ëµÉ ¹®ÀÚÀÇ °³¼ö¸¦ Á¤ÀÇÇÏ´Â ¹æ¹ı
		//	1. Ex{n} 	: ¾Õ¿¡ ÀÖ´Â ÆĞÅÏÀÌ n±ÛÀÚ ÀÏÄ¡ÇØ¾ß ÇÔ.
		//	2. Ex{n,m} 	: ¾Õ¿¡ ÀÖ´Â ÆĞÅÏÀÌ ÃÖ¼Ò n±ÛÀÚºÎÅÍ ÃÖ´ë m±ÛÀÚ ÀÏÄ¡ÇØ¾ß ÇÔ.
		//	3. Ex{n,} 	: n±ÛÀÚ ÀÌ»ó ÀÏÄ¡ÇØ¾ß ÇÔ.
		//	4. Ex?		: 0¹ø È¤Àº ÇÑ¹ø
		//	5. Ex+		: ÃÖ¼Ò ÇÑ¹ø
		//	6. Ex*		: 0¹ø È¤Àº ¿©·¯¹ø
		System.out.println(Pattern.matches("....[\\d]{2}", "ahos92"));
		System.out.println("À¯È¿ÇÑ ¾ÆÀÌµğ : " + Pattern.matches("[\\w°¡-ÆR]{2,12}", "¾ÆÈ£½ºahos92"));
		System.out.println(Pattern.matches("....[\\d]{2,}", "ahos9213123213213213211232312513265343687364"));
		System.out.println(Pattern.matches("[@]?", ""));
		System.out.println();
		
		// 
		String email = "abc@gmail.com";
		System.out.println("ÀÌ¸ŞÀÏ ÆĞÅÏ : "
				+ Pattern.matches("[\\w]+@[a-zA-Z0-9]+[.][a-zA-Z.]+", email));
		System.out.println();
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		// # Pattern.compile(regex)
		//	- Àü´ŞÇÑ Á¤±ÔÇ¥Çö½ÄÀ» ÀÌ¿ëÇØ »ı¼ºÇÑ ÀÎ½ºÅÏ½º¸¦ ¹İÈ¯
		Pattern splie_regex = Pattern.compile("/");
		
		String fruit[] = splie_regex.split("apple/banana/orange/kiwi");
		System.out.println(Arrays.toString(fruit));
		System.out.println();
		// # »ı¼ºµÈ apttern ÀÎ½ºÅÏ½º·Î Matcher »ı¼ºÇÏ±â
		
		// # Matcher
		//	- java.util.regex.Matcher
		//	- ¹®ÀÚ¿­À» Ã³À½ºÎÅÍ ³¡±îÁö °Ë»çÇÏ¸é¼­ Á¤±ÔÇ¥Çö½Ä°ú ÀÏÄ¡ÇÏ´Â ÀÎµ¦½º¸¦ Ã£¾ÆÁØ´Ù.
		Pattern fruit_regex = Pattern.compile("[a-zA-Z[^/]]+"); // [a-zA-Z]+
										
		Matcher matcher = fruit_regex.matcher("apple/banana/orange/kiwi");
		
		// find : Á¤±ÔÇ¥Çö½ÄÀ» ÅëÇØ Ã£Àº °ÍÀÌ ÀÖÀ¸¸é true
		while (matcher.find()) {
			System.out.println("Ã£Àº °Í : " + matcher.group());
			System.out.println(matcher.start() + " to " + matcher.end());
		}
	}

}
