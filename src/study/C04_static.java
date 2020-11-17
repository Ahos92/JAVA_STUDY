package study;

public class C04_static {

	// # static (정적, 클래스 영역) <=> 인스턴스 영역
	//	- 같은 클래스의 모든 인스턴스가 '공동'으로 사용하는 영역 
	// 	- static 영역은 클래스당 하나 이므로 
	//		클래스 이름에 .을 찍고 사용하는것이 권장 (인스턴스에 찍어봐야 다 같은 값이기떄문에)
	//	- static 영역의 변수/메서드(자원)는 인스턴스가 생기기 전에도 호출할 수 있다.
	
	//	- 인스턴스가존재하지 않을 떄도 Static이 사용될 가능성이 있기 떄문에
	//		static 메서드에서는 instance자원을 사용할 수 없다.
	//		(인스턴스에서 스태틱으로의 접근은 허용)
	
	public static void main(String[] args) {
		// 인스턴스없이 막사용 가능 static 변수
		System.out.println(Card.width);
		System.out.println(Card.height);

		Card c1 = new Card("Clover", 1);
		Card s1 = new Card("Spade", 1);
		Card h1 = new Card("Heart", 1);
		Card d1 = new Card("Diamond", 1);

		Card.width = 333;// 같은 값 가리킴

		System.out.println(Card.width); // 권장
		System.out.println(c1.width); // 노란줄
		System.out.println(s1.width);
		System.out.println(h1.width);
		System.out.println(d1.width);
	}
}

// 1 ex
class Card {
	// 각 카드마다 다른 값을 가지고 있어야하는 변수 
	// 인스턴스 영역에 적합
	String shape;
	int number;

	// 카드의 크기는 반드시 전부 같아야함 
	//  인스턴스에서 사용하기 공간 낭비 -> 공동 영역에 적합
	static int width;
	static int height;
	// 생성자 대신 static block에서 초기화를 진행하는 것이 좋다.
	static {
		width = 100;
		height = 200;
		System.out.println("static block called");
	}

	// instance block
	{
		System.out.println("instance block called");
	}
	
	public Card(String shape, int number) {
		this.shape = shape;
		this.number = number;
		System.out.println("constructor called");
		// 생성자에서 static을 초기화하는 경우 -> bad
		// 초기화 되지 ㅇ낳은 static필드를 사용할 위험이 있다.
		// width = 100;
		// height = 200;
	}

	// static 메서드는 매개변수, static 변수만 사용가능
	//	- this존재하지 않음
	// 			(아직 인스턴스가 생성되지 않았을수도 있으므로)
	// 인스턴스와 무관하게 항상 일정한 기능을 구현할 떄 사용한다
	public static void changeCardSize (int width, int height) {
		Card.width = width;
		Card.height = height;
	}
	
	public static int[] getCardSize() {
		return new int[] {width, height};
	}
}

// 2 ex
class Coffe {

	int from;

	// 원산지 번호는 모든 커피들이 같은 벊를 상ㅇ해야함
	//	-> 공동 영역을 사용하는것이 합리적.
	final static int SOUTH_KOREA = 0;
	final static int COLUMBIA = 1;
	final static int BRAZIL = 2;
}
