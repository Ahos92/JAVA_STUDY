package myobj.poker;

public enum Suit {

	// enum 
	//      Rank클래스의 자동버전
	
									// order와 	 name은 기본적으로 설정된다.
	
	SPADE(3, "스페이드", "♠"), 			// order 0,  name "SPADE"  / suitValue 3 , korName "스페이드" 	....
	DIAMOND(2, "다이아몬드", "◇"),			// order 1,  name "DIAMOND"/ suitValue 2 , korName "다이아몬드"	....
	HEART(1, "하트", "◇"),				// order 2,  name "HEART"  / suitValue 1 , korName "하트"		....
	CLOVER(0, "클로버", "♣");				// order 3,  name "CLOVER" / suitValue 0 , korName "클로버"	....

	public static final int NUM_OF_SUIT = 4;
	
	private int suitValue; // 크기 비교할떄 쓰일 값
	private String korName; // 내가 이해하기 위해 쓰인 값
	private String shape;
	
	//	새로운 상수를 추가하고 싶다면 생성자를 이용한다. -> (상수들의 집합)
	// enum타입 객체는 생성자가 반드시 private이다 ( 안적어도 됨 ) 
	private Suit(int suitValue, String korName, String shape) {
		this.suitValue = suitValue;
		this.korName = korName;
		this.shape = shape;
	}

	public int getSuitValue() {
		return suitValue;
	}
	
	public String getKorName() {
		return korName;
	}
	
	public String getShape() {
		return shape;
	}
}
