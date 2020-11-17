
public class C03_Constructer {

	// 클래스의 생성자 
	//	- 클래스의 이름과 똑같은 이름의 함수 
	// 	- new와 함께 생성자를 호출하면 클래스에 정의된 대로 인스턴스가 생성
	// 	- 생성자가 모두 실행된 후에는 생성된 인스턴스의 주소가 반환된다.
	// 	- 생성자를 따로 정의하지 않으면 아무것도 정의되지 않은 기본생성자 사용
	//				기본 생성자 - 매개변수가 없는 생성자
	
	public static void main(String[] args) {
		
		Orange o1 = new Orange();
		Orange o2 = new Orange(5, 5, "green");
		
		
		System.out.println(o1.sweet);
		System.out.println(o1.size);
		System.out.println(o1.color);
		
		System.out.println(o2.sweet);
		System.out.println(o2.size);
		System.out.println(o2.color);
		
		Strawberry s1 = new Strawberry();
		
		Grape g1 = new Grape(30);
		Grape g2 = new Grape(25);
		
		for(int i = 0; i < 31; ++i) {
			g1.eat();
			
		}

		g2.eat();
		
	}
	
	
}

class Orange {
	
	int sweet;
	int size;
	String color;
	
	//인스턴스 호출시 가장 먼저 호출됨
	// 주로 인스턴스 변수값을 초기화 하는데 사용.
	// return 타입 X
	public Orange() {
		// 평상시에는 클래스 내부에서 this를 생략해도 필드에 접근가능
		sweet = 10;
		size = 5; 
		color = "orange";
	}
	
	//생성자도 함수처럼 오버로딩 가능
	//	- 하나의 클래스가 다양한 형태의 생성자를 가지고있을수 있음
	public Orange(int sweet, int size, String color) {
		// 필드값과 지역 변수명이 겹치는 경우 this를 통해 어느쪽 변수인지 명확히 지정
		this.sweet = sweet;
		this.size = size;
		this.color = color;
		// this - 클래스 내부에서 현재 인스턴스를 참조할 때 사용하는 키워드
	}
}

class Strawberry {
	int seed;
	String color;
	
}

//정의된 생성자가 있을 경우 기본생성자 자동으로 생성되지 않는다. 사용하고싶을 경우 직접 정의.
class Grape {
	int podo;
	int skin;
	
	public Grape() {
		this(20);
		
		// 생성자에서 this(); 을통해 다른 생성자를 호출할 수있다.
		// 다른 생성자는 반드시 생성자 맨 윗줄 호출
	}
	
	public Grape(int podo) {
		this.podo = podo;
		this.skin = 0;
	}
	
	public void eat() {
		if(podo == 0) {
			System.err	.println("이 포도는 다먹었습니다.");
			System.out.printf("현재 남은 포도는 %d개, 껍질은 %d개 입니다.\n", podo, skin);
			return;
		}
		podo--;
		skin++;
		System.out.printf("현재 남은 포도는 %d개, 껍질은 %d개 입니다.\n", podo, skin);
	}
}