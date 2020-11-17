package study;

public class C05_extends {

	// # 클래스 상속
	//	- 미리 만들어둔 클래스를 그대로 물려 받아서 사용하는 것
	// 	- 상속해주는 클래스를 부모 클래스 혹은 super 클래스 라고 한다.
	// 	- 상속받는 클래스를 자식 클래스 혹은 sub 클래스 라고 한다.
	//	- 자식 클래스는 부모클래스가 가진 모든 기능을 그대로 물려받는다.
	// 	- 자식 클래스는 부모에게 물려받은 기능을 마음대로 수정해서 쓸 수 있다.(Override)
	// 	- 자식 클래스는 부모에게 없던 기능을 망므대로 추가해서 쓸 수 있다.
	public static void main(String[] args) {

		Person minsu = new Person("민수", 20);
		minsu.sayHi();

		Police police01 = new Police();
		Doctor doctor01 = new Doctor();
		Dentist dentist01 = new Dentist();

		police01.sayHi();
		doctor01.sayHi();
		
		/////////////////////////////////		
		// 객체의 다형성 ★★★
		//  김경찰은 경찰이기도 하지만 사람이기도하다.
		// 		- Person을 요구하는 자리에 Police가 들어가기도한다 (double 타입에 여러가지가 들어가는 거랑 비슷)
		dentist01.scaling(minsu);
		dentist01.scaling(police01);
		// Police는 부모인 Person의 모든정보를 가지고있ㅇ므
		// 아무문제없이 Person타입이 될 수 있다(업캐스팅)
		//  ※ 업캐스팅이 되면 원래있던 기능 잠깐 상실 => 다시 사용하고싶으면 돌아가야함
		Person person01 = new Police();  
		// Police police02 = new Person(); <= X
		// Person은 자식인 Police에 모르는 기능이 존재 할수 있기 떄문에
		// 자식타입이 될수 없다.(다운 캐스팅)
		
		// 	다운 캐스팅은 특별한 경우를 제외하고는 불가능
		// 특별한 경우 -> 원래 폴리스였던 인스턴스는 다시 Police로 다운캐스팅 될 수 있다.
		// (업캐스팅이 한번이라도 됬으면 다운캐스팅 가능)
		Police police = (Police) person01;
		
		Person person02 = new Dentist();
		Police police2 = (Police) person02; // <= X
		////////////////////////////////////
	}
}

class Person {
	String name; 
	int age;

	public Person() {
		this("default name", 0);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void sayHi() { 
		System.out.printf("안녕! 내 이름은 %s이고 나이는 %d살이야.\n", name, age);
	}

}

class Police extends Person{
	String name;
	// 1. 상속받은 개체는 부모의 생성자를 가장 먼저 호출해야한다.
	//  ※ 부모의 생성자가 매개변수를 요구하는 생성자만 있다면 
	//		반드시 값을 채워줘야한다.
	public Police() {
		super("김경찰", 25);

		// this() 현재 인스턴스의 현재 클래스 생성자
		// super() 현재 인스턴스의 부모 클래스 생성자

		System.out.println("super.name : "+super.name);
		System.out.println("this.name : "+this.name);
	}

}

class Doctor extends Person {
	// 기본 생성자가 있는 부모클래스를 상속받는 경우 자동으로
	// 부모의 기본생성자를 호출한다.

	// Person클래스의 sayHi를 고쳐서 사용하고있다.
	@Override
	public void sayHi() {
		System.out.printf("안녕하세요. 닥터 %s입니다.\n", name);
		// super.sayHi(); 
		// 부모의 메서드는 사라진것이 아니고 그대로 사용 가능
	}
}

class Dentist extends Doctor {

	public void scaling(Person target) {
		System.out.printf("치과의사 %s가 %s에게 스케일링을 해줬습니다.\n", name, target.name);

	}
}