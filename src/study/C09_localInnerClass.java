package study;

public class C09_localInnerClass {

	// # 지역 내부 클래스
	//	- 메서드 내부에서도 클래스 사용이 가능하다
	//	- 메서드의 범위를 벗어날 수 없다.
	//	- 
	
	void method() {
		
		class Apple{
			int size;
			String color;
		}
		
		Apple a = new Apple();
		
		System.out.println(a.color);
		System.out.println(a.size);
		
	}
	
	public static void main(String[] args) {
		
		// 마찬가지로 변수가 내부클래스에 영향을 미침
		String a = "대구";
		String b = "빨간색";
		
		// 지역 내부 클래스 (메서드 끝나면 클래스도 사라지게 된다)
		class Apple{
			String addr;
			String color;
			
			public Apple() {
				addr = a;
				color = b;
			}
		}
		
		Apple apple = new Apple();
		
		System.out.println(apple.addr);
		System.out.println(apple.color);
		
	}
}
