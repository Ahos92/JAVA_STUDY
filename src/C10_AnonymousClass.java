import myobj.animal.Animal;

public class C10_AnonymousClass {

	// # �͸� Ŭ����
	//	- Ŭ������ �ٷ� �����Ͽ� ����ϴ� ���
	//	- ���� ������� �ʰ� '�ѹ���' ����Ѵ�.  => System.out.println(10 + 30); ���� "10 + 30" ���� ����
	public static void useAnimal(Animal animal) {
		animal.breath();
		animal.eat();
	}

	public static void main(String[] args) {

		Animal animal01 = new Animal();

		// �̷��� ������ Ŭ������ �ٽô� ����� �� ���� ������ �͸� Ŭ������ �θ��� (localInnerClass�̱⵵�ϴ�)
		// animal�� ��ӹ��� �̸����� Ŭ������ �ۼ��� �� �ִ�.
		Animal animal02 = new Animal() {
			@Override
			public void breath() {
				System.out.println("������� ������");
			}

			@Override
			public void eat() {
				System.out.println("������� ���� �Ա�");
			}
		};

		// �͸����� ������ ���ο� Ŭ������ �Լ��� ���ڷ� ���� (������ ����ϰ� ������)
		useAnimal(new Animal() {
			@Override
			public void breath() {
				System.out.println("����̰� ���� ���ϴ�.");
			}
			@Override
			public void eat() {
				System.out.println("����̰� ��ġĵ�� �Խ��ϴ�.");
			}

		});
		
		useAnimal(animal01);
		useAnimal(animal02);

		// �߻� Ŭ������ �ν��Ͻ�ȭ�� �Ұ���
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
		// �͸�Ŭ������ �Ｎ���� ��ӹ޾� ��밡��
		Monster monster = new Monster(50, 300) {
			@Override
			void attack() {
				System.out.printf("%d�� ���ݷ����� �����մϴ�.\n", attack);
			}
			
			@Override
			void attacked() {
				System.out.printf("ü���� 1 �����߽��ϴ�.");
			}
		};
		
		monster.attack();
		monster.attacked();
		
	}
}
