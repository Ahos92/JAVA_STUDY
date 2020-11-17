import myobj.animal.Animal;

public class C10_AnonymousClass {

	// # 익명 클래스
	//	- 클래스를 바로 구현하여 사용하는 방식
	//	- 따로 저장되지 않고 '한번만' 사용한다.  => System.out.println(10 + 30); 에서 "10 + 30" 같은 개념
	public static void useAnimal(Animal animal) {
		animal.breath();
		animal.eat();
	}

	public static void main(String[] args) {

		Animal animal01 = new Animal();

		// 이렇개 생성한 클래스는 다시는 사용할 수 없기 때문에 익명 클래스라 부른다 (localInnerClass이기도하다)
		// animal을 상속받은 이름없는 클래스를 작성할 수 있다.
		Animal animal02 = new Animal() {
			@Override
			public void breath() {
				System.out.println("물고기의 숨쉬기");
			}

			@Override
			public void eat() {
				System.out.println("물고기의 먹이 먹기");
			}
		};

		// 익명으로 선언한 새로운 클래스를 함수의 인자로 전달 (변수랑 비슷하게 생각함)
		useAnimal(new Animal() {
			@Override
			public void breath() {
				System.out.println("고양이가 숨을 쉽니다.");
			}
			@Override
			public void eat() {
				System.out.println("고양이가 참치캔을 먹습니다.");
			}

		});
		
		useAnimal(animal01);
		useAnimal(animal02);

		// 추상 클래스는 인스턴스화가 불가능
		abstract class Monster {
			int attack;
			int hp;
			
			public Monster(int attack, int hp) {
				this.attack = attack;
				this.hp = hp;
			}
			
			abstract void attack();
			abstract void attacked();
		}
		// 익명클래스로 즉석에서 상속받아 사용가능
		Monster monster = new Monster(50, 300) {
			@Override
			void attack() {
				System.out.printf("%d의 공격력으로 공격합니다.\n", attack);
			}
			
			@Override
			void attacked() {
				System.out.printf("체력이 1 감소했습니다.");
			}
		};
		
		monster.attack();
		monster.attacked();
		
	}
}
