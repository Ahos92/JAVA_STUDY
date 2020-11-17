package study;
import java.util.Arrays;

public class C01_function {

	// 함수 (function) 
	// 	- 기능을 미리 정의해두고 나중에 가져다 쓰는것
	// 	- 함수 이름 뒤에 ()를 붙여서 함수를 호출하면 함수의 실행 결과가 반환된다.
	//	- 나중에 재사용할 가능성이 있는 기능을 미리 만들어둠으로써 작업의 반복을 줄인다.
	
	// ex) 사과의 개수와 바구니의 크기를 전달받으면 필요한 바구니 개수를 알려주는 기능 / 미리만들어 놓기
	public static int appleBasket(int appleNum, int basketSize) {
		
		int result;
		
		if (appleNum % basketSize == 0) {
			result = appleNum / basketSize;
		} else {
			result = appleNum / basketSize + 1;
		}
		
		// 함수 타입이 int이므로 반환 값도 int여야한다. / return을 만나면 함수 종료
		return result;  
	}
	
	
	// ex) 여러 슈퍼의 사과 가격을 입력 받으면 가장 싼 가격을 알려주는 함수
	public static int cheapPrice(int[] prices) {
		int min = 0;
		
		for(int i = 0; i < prices.length; ++i) {
			if(i == 0) {
				min = prices[i];
			}else {
				min = Math.min(min, prices[i]);
			}
		}
		
		return min;
	}
	
	// ex) 사과들의 평균 가격 리턴
	public static double avgPrice(int[] price) {
		int sum = 0;
		
		for(int i = 0; i < price.length; ++i) {
			sum += price[i];
		}
		
		return sum / (double) price.length;
	}
	
	// ex) 전달한 사과 가격들을 10000원씩 증가시키는 함수
	
	public static void raisePrice(int[] prices) {
		
		for(int i = 0; i < prices.length; ++i) {
			prices[i] += 10000;
		}
		// void 타입은 return 하지않는다. / 해도무방
	}
	
	public static void main(String[] args) {
		
		int count = appleBasket(25, 10);
		
		count = appleBasket(33, 8);
		
		System.out.println("필요한 바구니 갯수 : " + count);
		
		int[] apples = {1000, 2000, 3000, 1500, 5000, 990}; 
		int[] apples2 = {1000, 2000, 3000, 1500, 5000, 990, 1320, 32130, 123}; 
				
		System.out.println(cheapPrice(apples));
		
		System.out.println(avgPrice(apples));
		System.out.println(avgPrice(apples2));
		
		// 반환값이 없는 함수 / 프린트 X
		raisePrice(apples);
		raisePrice(apples);
		raisePrice(apples);
		raisePrice(apples);
		
		System.out.println(Arrays.toString(apples));
		
	}
	
}
