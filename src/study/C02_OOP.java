package study;

public class C02_OOP {

	// 객체지향 프로그래밍 (OOP : Object Oriented Programming)
	//	- 존재하는 모든 것들을 변수와 메서드로 표현하려는 프로그래밍 방법 
	//		ex) 강의실(메서드) -> 인원 수(변수), 최대수용인원(상수)

	// - 객체 : 세상에 존재하는 모든 개념 (사물, 개념, 알고리즘 등등)

	//ex: 사과
	//	- 사과의 변수 : 크기, 색, 수확날짜, 당도, 칼로리 등
	//	- 사과의 메서드 - ※ 메서드 : 객체의 변수에 영향을 미치는 함수
	//			-> 먹는다(크기, 칼로리 변화)
	//		-> 갈변 (색, 당도 변화)
	//		-> ...

	// -> Class
	// 객체를 프로그래밍 언어로 표현한 것 
	// 클래스를 통해 새엇ㅇ하는 실제 객체를 '인스턴스'라고 부른다.
	// 클래스는 참조형 변수 타입이다.
	//	(사과 클래스를 만든다면 사과 타입을 사용할 수 있게 된다.)

	public static void main(String[] args) {

		Apple apple01 = new Apple(); // 클래스 생성 (설계도로 실체(Apple의 인스턴스)를 만들고 그 실체의 주소를 변수 apple01에저장 )
		Apple apple02 = new Apple();
		Apple apple03 = new Apple();

		
		// 배열의 실체만 생성되어있는것 -> String[] fruits = new String[];
		Apple[] appleBox = new Apple[10];
		
		// 배열에 사과 실체 생성
		for(int i = 0; i < appleBox.length; ++i) {
			appleBox[i] = new Apple();
		}

		apple02.sweet = 10;
		apple03.sweet = 8;

		// 실체가 생겨 설계도를 사용가능
		apple01.birthday = "2020/10/29";
		apple01.size = 10;
		apple01.calorie = apple01.size * 10;
		apple01.color = "red";
		apple01.sweet = 7;

		apple01.eat();
		apple02.eat();
		apple03.eat();
		
		//1. myobj.fruit 패키지에 클래스하나 정의하고 인스턴스
		//2. myobj.vehicle 패키지에 클래스하나 정의하고 인스턴스
		
	}

}

class Apple {
	
	// 인스턴스 변수 ( 필드, 멤버변수 ..)
	// 	- 모든 인스턴스마다 각자 다른 값을 가지고 있는 변수
	int size;
	int sweet;
	int calorie;
	int damage;
	String color;
	String birthday;

	// 인스턴스 메서드
	// 인스턴스 변수를 활용하는 메서드
	void eat() {
		System.out.println("사과를 먹었습니다.");
		System.out.println(this.sweet + "만큼 기분이 좋아졌습니다.");
		this.size -= 1;
		this.calorie -= 10;
		System.out.printf("크기 : %d , 보유 칼로리 : %d\n", this.size, this.calorie);
	}


}
